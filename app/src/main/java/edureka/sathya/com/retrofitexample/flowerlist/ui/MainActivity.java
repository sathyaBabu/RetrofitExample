package edureka.sathya.com.retrofitexample.flowerlist.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import edureka.sathya.com.retrofitexample.R;
import edureka.sathya.com.retrofitexample.flowerlist.adapter.FlowersAdapter;
import edureka.sathya.com.retrofitexample.flowerlist.model.Flower;
import edureka.sathya.com.retrofitexample.flowerlist.model.FlowersCollection;
import edureka.sathya.com.retrofitexample.flowerlist.web.adapter.FlowerWebAdapter;
import edureka.sathya.com.retrofitexample.flowerlist.web.service.FlowerService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

//import retrofit.Callback;
//import retrofit.RetrofitError;
//import retrofit.client.Response;
//



// retrofit vs volley
//http://instructure.github.io/blog/2013/12/09/volley-vs-retrofit/


/*
http://www.json-generator.com/api/json/get/coGUFiJJmG

//    base url                                           Tail url
http://www.json-generator.com/api/json/get               /coGUFiJJmG



{
  "flowers": [
    {
      "url": "http://sg.cdnmob.org/pic/v2/gallery/111x185/cvety-rasteniya-29024.jpg",
      "details": "This is additional information about flower1. This information will be only shown if you click on show more link.",
      "rating": 1,
      "name": "Flower1",
      "desc": "This is flower 1"
    },
    {
      "url": "http://sg.cdnmob.org/pic/v2/gallery/111x185/cvety-rasteniya-rozy-28798.jpg",
      "details": "This is additional information about flower2. This information will be only shown if you click on show more link.",
      "rating": 2,
      "name": "Flower2",
      "desc": "This is flower 2"
    },
    {
      "url": "http://sg.cdnmob.org/pic/v2/gallery/111x185/cvety-podsolnuhi-rasteniya-28745.jpg",
      "details": "This is additional information about flower3. This information will be only shown if you click on show more link.",
      "rating": 3,
      "name": "Flower3",
      "desc": "This is flower 3"
    },
    {
      "url": "http://sg.cdnmob.org/pic/v2/gallery/111x185/cvety-rasteniya-28842.jpg",
      "details": "This is additional information about flower4. This information will be only shown if you click on show more link.",
      "rating": 4,
      "name": "Flower4",
      "desc": "This is flower 4"
    },
    {
      "url": "http://sg.cdnmob.org/pic/v2/gallery/111x185/cvety-pejzazh-polya-zakat-28952.jpg",
      "details": "This is additional information about flower5. This information will be only shown if you click on show more link.",
      "rating": 5,
      "name": "Flower5",
      "desc": "This is flower 5"
    },
    {
      "url": "http://sg.cdnmob.org/pic/v2/gallery/111x185/cvety-rasteniya-28857.jpg",
      "details": "This is additional information about flower6. This information will be only shown if you click on show more link.",
      "rating": 2,
      "name": "Flower6",
      "desc": "This is flower 6"
    }
  ]
}

 */

public class MainActivity extends AppCompatActivity {

    private ListView flowersList;
    private FlowersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowersList = (ListView) findViewById(R.id.flowersList);

    FlowerService flowerService =  new FlowerWebAdapter().getFlowerService();

    flowerService.getFlowerList(new Callback<FlowersCollection>() {
        @Override
        public void success(FlowersCollection flowersCollection, Response response) {
            Log.d("tag"," : "+flowersCollection.flowers.length);  // 6


            for( int i = 0 ; i< flowersCollection.flowers.length;i++)
                {
                    Log.d("tag"," name"+flowersCollection.flowers[i].name+" Desc "+
                            flowersCollection.flowers[i].desc+"  Details "+flowersCollection.flowers[i].details
                             +flowersCollection.flowers[i].rating);

//                    flowersCollection.flowers[i].
                }

                // lets give the data to the adapter.. recy

            adapter = new FlowersAdapter(MainActivity.this, flowersCollection.flowers);
               flowersList.setAdapter(adapter);

        }

        @Override
        public void failure(RetrofitError error) {

            error.printStackTrace();

        }
    });


    }
}
