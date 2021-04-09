package io.giodude.baccaratnhcaobil.Connections;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.giodude.baccaratnhcaobil.Model.RulesModel;
import io.giodude.baccaratnhcaobil.Model.SystemModel;
import io.giodude.baccaratnhcaobil.Model.TipsModel;
import io.giodude.baccaratnhcaobil.Model.VariationModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {

    private static Repositories instance;
    static APIClient rfit = new APIClient();

    public static Repositories getInstance(){
        if (instance == null){
            instance = new Repositories();
        }
        return instance;
    }


    public MutableLiveData<List<VariationModel>> getVar(){
        final MutableLiveData<List<VariationModel>> vData = new MutableLiveData<>();
        Call<List<VariationModel>> call = rfit.retrofitBuilderVariation().getVariation();
        call.enqueue(new Callback<List<VariationModel>>() {
            @Override
            public void onResponse(Call<List<VariationModel>> call, Response<List<VariationModel>> response) {
                try {
                    List<VariationModel> varList = response.body();
                    vData.setValue(varList);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<VariationModel>> call, Throwable t) {
                    vData.setValue(null);
            }
        });
        return vData;
    }

    public MutableLiveData<List<RulesModel>> getRule(){
        final MutableLiveData<List<RulesModel>> rData = new MutableLiveData<>();
        Call<List<RulesModel>> call = rfit.retrofitBuilderRules().getRules();
        call.enqueue(new Callback<List<RulesModel>>() {
            @Override
            public void onResponse(Call<List<RulesModel>> call, Response<List<RulesModel>> response) {
                try {
                    List<RulesModel> rList = response.body();
                    rData.setValue(rList);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<RulesModel>> call, Throwable t) {
                rData.setValue(null);
            }
        });
        return rData;
    }

    public MutableLiveData<List<SystemModel>> getSystem(){
        final MutableLiveData<List<SystemModel>> sData = new MutableLiveData<>();
        Call<List<SystemModel>> call = rfit.retrofitBuilderSystem().getSystem();
        call.enqueue(new Callback<List<SystemModel>>() {
            @Override
            public void onResponse(Call<List<SystemModel>> call, Response<List<SystemModel>> response) {
                try {
                    List<SystemModel> sList = response.body();
                    sData.setValue(sList);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<SystemModel>> call, Throwable t) {
                sData.setValue(null);
            }
        });
        return sData;
    }

    public MutableLiveData<List<TipsModel>> getTips(){
        final MutableLiveData<List<TipsModel>> tData = new MutableLiveData<>();
        Call<List<TipsModel>> call = rfit.retrofitBuilderTips().getTips();
        call.enqueue(new Callback<List<TipsModel>>() {
            @Override
            public void onResponse(Call<List<TipsModel>> call, Response<List<TipsModel>> response) {
                try {
                    List<TipsModel> tList = response.body();
                    tData.setValue(tList);
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<TipsModel>> call, Throwable t) {
                    tData.setValue(null);
            }
        });
        return tData;
    }
}
