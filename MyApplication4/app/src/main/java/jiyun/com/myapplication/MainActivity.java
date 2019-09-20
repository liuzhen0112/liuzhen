package jiyun.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button get;
    private Button post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get = findViewById(R.id.main_get);
        post = findViewById(R.id.main_post);
        get.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_get:
                getHttp();
                break;
            case R.id.main_post:
                postHttp();
                break;
        }
    }

    private void postHttp() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyServiec serviec = retrofit.create(MyServiec.class);
        Call<BeanWord> call = serviec.postWord("auto", "auto", "boy");
        call.enqueue(new Callback<BeanWord>() {
            @Override
            public void onResponse(Call<BeanWord> call, Response<BeanWord> response) {
                BeanWord body = response.body();
                List<String> word_mean = body.getContent().getWord_mean();
                Log.i("tag","MEAN:"+word_mean.toString());


            }

            @Override
            public void onFailure(Call<BeanWord> call, Throwable t) {
                Log.i("tag","Fail:"+t.getMessage());

            }
        });


    }

    private void getHttp() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://gitee.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyServiec serviec = retrofit.create(MyServiec.class);
        Call<List<Bean>> call = serviec.reqStar();
        call.enqueue(new Callback<List<Bean>>() {
            @Override
            public void onResponse(Call<List<Bean>> call, Response<List<Bean>> response) {
                Log.i("tag","Image:"+response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<List<Bean>> call, Throwable t) {
                Log.i("tag","Fail:"+t.getMessage());

            }
        });

    }
    interface MyServiec{
        @GET("https://gitee.com/Haoxueren/codes/5h3p0q4y8sa6rlme2kunw73/raw?blob_name=stars")
        Call<List<Bean>> reqStar();
        @POST("http://fy.iciba.com/ajax.php?a=fy")
        @FormUrlEncoded
        Call<BeanWord> postWord(@Field("f")String from,@Field("t")String to,@Field("w")String w);
    }
}
