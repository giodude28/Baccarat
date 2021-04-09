package io.giodude.baccaratnhcaobil.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.giodude.baccaratnhcaobil.Adapter.TipsAdapter;
import io.giodude.baccaratnhcaobil.Model.TipsModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.ViewModel.TipsViewModel;

public class TipsView extends Fragment {
private TipsAdapter tipsAdapter;
private TipsViewModel tipsViewModel;
private List<TipsModel> tModel = new ArrayList<>();
private static RecyclerView recyclerView;
private RecyclerView.LayoutManager tipOut;
    public ProgressBar progressBar;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_tips_view,container,false);
        progressBar = view.findViewById(R.id.progress);
        showTips();
        return view;
    }

    private void getTips(List<TipsModel> tips){
        recyclerView = view.findViewById(R.id.tipsRecyclerview);
        tipOut = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(tipOut);
        tipsAdapter = new TipsAdapter(getActivity(),tips);
        recyclerView.setAdapter(tipsAdapter);
    }

    private void showTips(){
        tipsViewModel = ViewModelProviders.of(TipsView.this).get(TipsViewModel.class);
        tipsViewModel.init();
        tipsViewModel.getTips().observe(this, tipsModels -> {
           if (tipsModels == null){
               progressBar.setVisibility(View.VISIBLE);
               Toast.makeText(getActivity(),"Can't connect in Server",Toast.LENGTH_LONG).show();
           }else {
               progressBar.setVisibility(View.INVISIBLE);
               getTips(tipsModels);
               tModel.addAll(tipsModels);
               tipsAdapter.notifyDataSetChanged();
           }
        });
    }
}