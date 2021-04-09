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

import io.giodude.baccaratnhcaobil.Adapter.SystemAdapter;
import io.giodude.baccaratnhcaobil.Model.SystemModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.ViewModel.SystemViewModel;

public class SystemView extends Fragment {
private SystemAdapter systemAdapter;
private SystemViewModel systemViewModel;
private List<SystemModel> sModel = new ArrayList<>();
private static RecyclerView recyclerView;
private RecyclerView.LayoutManager sysOut;
    public ProgressBar progressBar;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_system_view,container,false);
        progressBar = view.findViewById(R.id.progress);
        showSystem();
        return view;
    }

    private void getSystem(List<SystemModel> system){
        recyclerView = view.findViewById(R.id.systemRecyclerview);
        sysOut = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(sysOut);
        systemAdapter = new SystemAdapter(getActivity(),system);
        recyclerView.setAdapter(systemAdapter);
    }

    private void showSystem(){
        systemViewModel = ViewModelProviders.of(SystemView.this).get(SystemViewModel.class);
        systemViewModel.init();
        systemViewModel.getSystem().observe(this, systemModels -> {
            if (systemModels == null){
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(),"Can't connect in Server",Toast.LENGTH_LONG).show();
            }else{
                progressBar.setVisibility(View.INVISIBLE);
                getSystem(systemModels);
                sModel.addAll(systemModels);
                systemAdapter.notifyDataSetChanged();
            }
        });
    }
}