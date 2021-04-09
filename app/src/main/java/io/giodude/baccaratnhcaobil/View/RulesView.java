package io.giodude.baccaratnhcaobil.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.giodude.baccaratnhcaobil.Adapter.RulesAdapter;
import io.giodude.baccaratnhcaobil.Model.RulesModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.ViewModel.RulesViewModel;

public class RulesView extends Fragment {
private RulesAdapter rulesAdapter;
private RulesViewModel rulesViewModel;
private List<RulesModel> rModel = new ArrayList<>();
private static RecyclerView recyclerView;
private RecyclerView.LayoutManager ruleOut;
    public ProgressBar progressBar;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_rules_view,container,false);
        progressBar = view.findViewById(R.id.progress);
        showRules();
        return view;
    }


private void getRules(List<RulesModel> rules){
        recyclerView = view.findViewById(R.id.rulesRecyclerview);
        ruleOut = new GridLayoutManager(getActivity(),1,RecyclerView.HORIZONTAL,false);
    PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
    pagerSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(ruleOut);
        rulesAdapter = new RulesAdapter(getActivity(),rules);
        recyclerView.setAdapter(rulesAdapter);
}

private void showRules(){
        rulesViewModel = ViewModelProviders.of(RulesView.this).get(RulesViewModel.class);
        rulesViewModel.init();
        rulesViewModel.getRules().observe(this, rulesModels -> {
            if (rulesModels == null){
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(),"Can't connect to the Server",Toast.LENGTH_LONG).show();
            }else {
                progressBar.setVisibility(View.INVISIBLE);
                getRules(rulesModels);
                rModel.addAll(rulesModels);
                rulesAdapter.notifyDataSetChanged();
            }
        });
}


}