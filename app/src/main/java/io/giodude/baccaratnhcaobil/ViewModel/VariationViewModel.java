package io.giodude.baccaratnhcaobil.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.baccaratnhcaobil.Connections.Repositories;
import io.giodude.baccaratnhcaobil.Model.VariationModel;

public class VariationViewModel extends ViewModel {

    private MutableLiveData<List<VariationModel>> variation;
    public Repositories repositories;

    public void init(){
        if (variation != null){
            return;
        }
        repositories = Repositories.getInstance();
        variation = repositories.getVar();
    }

    public LiveData<List<VariationModel>> getVariations(){
        return  variation;
    }

}
