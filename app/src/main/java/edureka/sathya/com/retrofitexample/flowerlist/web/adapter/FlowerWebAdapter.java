package edureka.sathya.com.retrofitexample.flowerlist.web.adapter;

import edureka.sathya.com.retrofitexample.flowerlist.web.service.FlowerService;
import retrofit.RestAdapter;
//import retrofit.RestAdapter;


public class FlowerWebAdapter {

    public FlowerService getFlowerService() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.json-generator.com/api/json/get")
                .build();
        return restAdapter.create(FlowerService.class);
    }
}