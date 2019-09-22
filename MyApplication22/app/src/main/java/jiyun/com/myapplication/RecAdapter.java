package jiyun.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Windows on 2019/9/20.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyHolder> {
    private List<Bean.DatasBean> list;
    private Context context;
    private MyBtnClick onClickListener;
    private Map<Integer,String> map= new HashMap<>();
    private final static String GUANZHU="关注";
    private final static String QUXIAO="取消";
    private SharedPreferences sp;

    public void setOnClickListener(MyBtnClick onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RecAdapter(List<Bean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        sp = context.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        for (int i = 0; i <list.size() ; i++) {
            map.put(i,GUANZHU);


        }
        MyHolder myHolder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getAvatar()).circleCrop().into(holder.img);
        holder.name.setText(list.get(position).getAuthor());
        holder.title.setText(list.get(position).getTitle());
        holder.btn.setText(sp.getString("position"+position,GUANZHU));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = holder.btn.getText().toString();
                if (name.equals(GUANZHU)){
                    map.put(position,QUXIAO);
                    sp.edit().putString("position"+position,QUXIAO).commit();
                    holder.btn.setText(QUXIAO);
                } else if (name.equals(QUXIAO)){
                    map.put(position,GUANZHU);
                    sp.edit().putString("position"+position,GUANZHU).commit();
                    holder.btn.setText(GUANZHU);
                }

                onClickListener.onClick(position,v);



            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name;
        TextView title;
        Button btn;

        public MyHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.item_img);
            name=itemView.findViewById(R.id.item_name);
            title=itemView.findViewById(R.id.item_title);
            btn=itemView.findViewById(R.id.item_btn);
        }
    }
    interface MyBtnClick{
        void onClick(int positon,View view);
    }
}
