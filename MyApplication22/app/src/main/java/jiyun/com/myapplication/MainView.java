package jiyun.com.myapplication;

import java.util.List;

/**
 * Created by Windows on 2019/9/20.
 */

public interface MainView {
    void onsuccess(List<Bean.DatasBean> datas);

    void onFailure(String message);
}
