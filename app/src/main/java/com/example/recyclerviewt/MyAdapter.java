package com.example.recyclerviewt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<PostData> mData; //接收需要recycleView資料

    public MyAdapter(Context context,ArrayList<PostData> data) {
        this.mContext = context;
        this.mData = data; //data存放好幾筆資料 ex {a,b,c,d,e,f,g}
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view,parent,false);
        ViewHolder holder =new ViewHolder(view);
        holder.name = (TextView) view.findViewById(R.id.name);
        holder.sex = (TextView) view.findViewById(R.id.sex);
        holder.btnLike = (Button) view.findViewById(R.id.btnLike);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostData postData = mData.get(position);
        holder.name.setText(postData.name);
        holder.sex.setText(postData.sex);
//        holder.btnLike.setText(position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public TextView name;
        public TextView sex;
        public Button btnLike;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}