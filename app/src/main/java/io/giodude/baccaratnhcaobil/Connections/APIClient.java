package io.giodude.baccaratnhcaobil.Connections;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static APIInterface retrofitBuilderVariation(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.VARATION_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        APIInterface apiCall = retrofit.create(APIInterface.class);

        return apiCall;
    }

    public static APIInterface retrofitBuilderRules(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.RULES_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        APIInterface apiCall = retrofit.create(APIInterface.class);

        return apiCall;
    }
    public static APIInterface retrofitBuilderSystem(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.SYSTEM_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        APIInterface apiCall = retrofit.create(APIInterface.class);

        return apiCall;
    }
    public static APIInterface retrofitBuilderTips(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.TIPS_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        APIInterface apiCall = retrofit.create(APIInterface.class);

        return apiCall;
    }
}
