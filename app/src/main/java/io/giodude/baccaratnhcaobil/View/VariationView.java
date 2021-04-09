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

import io.giodude.baccaratnhcaobil.Adapter.VariationAdapter;
import io.giodude.baccaratnhcaobil.Model.VariationModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.ViewModel.VariationViewModel;

public class VariationView extends Fragment {
private VariationAdapter variationAdapter;
private VariationViewModel variationViewModel;
private List<VariationModel> vModel = new ArrayList<>();
private static RecyclerView recyclerView;
private RecyclerView.LayoutManager varOut;
    public ProgressBar progressBar;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_variation_view,container,false);
        progressBar = view.findViewById(R.id.progress);
        showVariation();
        return view;
    }

    private void getVar(List<VariationModel> variation){
        recyclerView = view.findViewById(R.id.variationRecyclerview);
        varOut = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(varOut);
        variationAdapter = new VariationAdapter(getActivity(),variation);
        recyclerView.setAdapter(variationAdapter);

    }

    private void showVariation(){
        variationViewModel = ViewModelProviders.of(VariationView.this).get(VariationViewModel.class);
        variationViewModel.init();
        variationViewModel.getVariations().observe(this, data -> {
      if (data == null){
          progressBar.setVisibility(View.VISIBLE);
          Toast.makeText(getActivity(),"Can't connect in Server",Toast.LENGTH_LONG).show();
      }else {
          progressBar.setVisibility(View.INVISIBLE);
          getVar(data);
          vModel.addAll(data);
          variationAdapter.notifyDataSetChanged();
      }
        });

    }
}