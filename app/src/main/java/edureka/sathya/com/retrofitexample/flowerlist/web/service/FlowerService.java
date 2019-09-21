package edureka.sathya.com.retrofitexample.flowerlist.web.service;


import edureka.sathya.com.retrofitexample.flowerlist.model.FlowersCollection;
import retrofit.Callback;
import retrofit.http.GET;
//import retrofit2.Callback;
//import retrofit2.http.GET;
//import retrofit.Callback;
//import retrofit.http.GET;
//import retrofit.http.Query;

//http://www.json-generator.com/api/json/get/coGUFiJJmG

// sathyahelp123@gmail.com

//    base url                                           Tail url
//http://www.json-generator.com/api/json/get               /coGUFiJJmG

// http://www.json-generator.com/api/json/get/coGUFiJJmG



public interface FlowerService {
    @GET("/coGUFiJJmG")
    void getFlowerList( Callback<FlowersCollection> callback) ;


}
