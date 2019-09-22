package jiyun.com.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Windows on 2019/9/20.
 */

public class Model {
    private static Model model=new Model();
    private Model(){}
    public static Model getModel(){
        return model;
    }
    public void requestDatas(final MainModel callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://static.owspace.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MySeriver mySeriver = retrofit.create(MySeriver.class);
        mySeriver.getData().enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                List<Bean.DatasBean> datas = response.body().getDatas();
                callBack.onsuccess(datas);


            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                callBack.onFailure(t.getMessage());

            }
        });


    }
    interface MySeriver{
        @GET("http://static.owspace.com/?c=api&a=getList&page_id=0")
        Call<Bean> getData();

    }




}
