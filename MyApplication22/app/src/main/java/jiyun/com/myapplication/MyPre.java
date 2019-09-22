package jiyun.com.myapplication;

import android.util.Log;

import java.util.List;

/**
 * Created by Windows on 2019/9/20.
 */

public class MyPre implements MainModel{
    private MainView mainView;
    private Model model=null;

    public MyPre(MainView mainView) {
        this.mainView = mainView;
        model=Model.getModel();
    }
    public void getRequestDatas(){
        model.requestDatas(this);


    }


    @Override
    public void onsuccess(List<Bean.DatasBean> datas) {
        Log.i("tag", "onsuccess: "+ datas.toString());
        mainView.onsuccess(datas);

    }

    @Override
    public void onFailure(String message) {
        Log.i("tag", "请求数据失败！"+message);
        mainView.onFailure(message);

    }
}
