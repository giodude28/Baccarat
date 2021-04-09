package io.giodude.baccaratnhcaobil.Connections;

import java.util.List;

import io.giodude.baccaratnhcaobil.Model.RulesModel;
import io.giodude.baccaratnhcaobil.Model.SystemModel;
import io.giodude.baccaratnhcaobil.Model.TipsModel;
import io.giodude.baccaratnhcaobil.Model.VariationModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    String VARATION_URL="http://45.66.164.9:9899/api/";

    @GET("baccaratvaration")
    Call<List<VariationModel>> getVariation();

    String RULES_URL="http://45.66.164.9:7900/api/";

    @GET("baccaratrules")
    Call<List<RulesModel>> getRules();


    String SYSTEM_URL="http://45.66.164.9:7564/api/";

    @GET("baccaratbettingsystem")
    Call<List<SystemModel>> getSystem();

    String TIPS_URL="http://45.66.164.9:7563/api/";

    @GET("baccarattips")
    Call<List<TipsModel>> getTips();
}
