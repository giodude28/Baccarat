package io.giodude.baccaratnhcaobil.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.baccaratnhcaobil.Connections.Repositories;
import io.giodude.baccaratnhcaobil.Model.TipsModel;

public class TipsViewModel extends ViewModel {

    private MutableLiveData<List<TipsModel>> tips;
    public Repositories repositories;

    public void init(){
        if (tips != null){
            return;
        }
        repositories = Repositories.getInstance();
        tips = repositories.getTips();
    }

    public LiveData<List<TipsModel>> getTips(){
        return tips;
    }
}
