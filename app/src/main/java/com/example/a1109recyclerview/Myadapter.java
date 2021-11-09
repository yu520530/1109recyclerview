package com.example.a1109recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Data> mData;
    public Myadapter(Context context, ArrayList<Data> data) {
        this.mContext = context;
        this.mData = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.view_tv1 = view.findViewById(R.id.view_tv1);
        holder.view_btn = view.findViewById(R.id.view_btn);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data d = mData.get(position);
        holder.view_tv1.setText(String.valueOf(d.id));
        holder.view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, d.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView view_tv1;
        public Button view_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
