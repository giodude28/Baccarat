package io.giodude.baccaratnhcaobil.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.baccaratnhcaobil.Connections.Repositories;
import io.giodude.baccaratnhcaobil.Model.SystemModel;

public class SystemViewModel extends ViewModel {

    private MutableLiveData<List<SystemModel>> system;
    public Repositories repositories;

    public void init(){
        if (system != null){
            return;
        }
        repositories = Repositories.getInstance();
        system = repositories.getSystem();
    }

    public LiveData<List<SystemModel>> getSystem(){
        return system;
    }
}
