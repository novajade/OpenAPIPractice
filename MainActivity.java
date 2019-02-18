package com.example.zzong.openapipractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zzong.openapipractice.Retrofit.NaverInterface;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public String Naver_id = "02CeY0VDcCFFCgc6MTPq";
    public String Naver_pw = "";
    public String keyword = "ironman";

    private ListView listView;
    public String TAG = "OPEN API";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.item_list);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://openapi.naver.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        NaverInterface naverInterface = retrofit.create(NaverInterface.class);

        Call<MovieData> call = naverInterface.getMovieData(
                Naver_id,
                Naver_pw,
                keyword );


        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                if(response.code() == 400){
                    Log.d(TAG, "Query Wrong");
                }
                else{
                    Log.d(TAG, "DK What..");
                }
                MovieData movieDataList = response.body();
                List<items> movieitems = response.body().getItems();
                Log.d(TAG, "이건 movieDataList : "+ movieDataList.items);
                for(items itemscount : movieitems){
                    Log.d(TAG, itemscount.getUserrating().toString());
                }
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {
                Log.d(TAG, "errorrrrr");
                Log.d(TAG, t.getMessage());
            }
        });
/*
        call.enqueue(new Callback<List<MovieData>>() {
            @Override
            public void onResponse(Call<List<MovieData>> call, Response<List<MovieData>> response) {
                if(response.code() == 400){
                    Log.d(TAG, "Query Wrong");
                }
                else{
                    Log.d(TAG, "DK");
                }
                //Log.d(TAG, String.valueOf(response.raw()));
                List<MovieData> data = response.body();
                Log.d(TAG, "is it working?");
                listView.setAdapter(new MovieAdapter(MainActivity.this, data));
            }

            @Override
            public void onFailure(Call<List<MovieData>> call, Throwable t) {
                Log.d(TAG, "errorrrrr");
                Log.d(TAG, t.getMessage());
            }
        });
*/


    }
}
