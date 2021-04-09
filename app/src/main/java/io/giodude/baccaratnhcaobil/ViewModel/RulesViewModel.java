package io.giodude.baccaratnhcaobil.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.baccaratnhcaobil.Connections.Repositories;
import io.giodude.baccaratnhcaobil.Model.RulesModel;

public class RulesViewModel extends ViewModel {

private MutableLiveData<List<RulesModel>> rules;
public Repositories repositories;

public void init(){
    if (rules != null){
        return;
    }
    repositories = Repositories.getInstance();
    rules = repositories.getRule();
}


public LiveData<List<RulesModel>> getRules(){
    return rules;
}
}
