package jiyun.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView rec;
    private MyPre pre;
    private List<Bean.DatasBean> list=new ArrayList<>();
    private RecAdapter adapter;
    private int mPosition;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pre = new MyPre(this);
        initView();
        requestDatas();
    }

    private void requestDatas() {
        pre.getRequestDatas();

    }

    private void initView() {
        sp = getSharedPreferences("mysp", Context.MODE_PRIVATE);
        rec = findViewById(R.id.main_rec);
        rec.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecAdapter(list, this);
        adapter.setOnClickListener(new RecAdapter.MyBtnClick() {
            @Override
            public void onClick(int positon, View view) {



            }
        });
        rec.setAdapter(adapter);
    }

    @Override
    public void onsuccess(List<Bean.DatasBean> datas) {
        list.addAll(datas);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFailure(String message) {

    }
}











