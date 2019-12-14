package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.model.ItemModel;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ItemModel> imageModelArrayList;

    public ItemsAdapter(Context ctx, ArrayList<ItemModel> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item_for_trips, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.MyViewHolder holder, int position) {

        holder.tv_currency_symbol.setText(Integer.parseInt(imageModelArrayList.get(position).getCurrency_symbol()));
        holder.tv_value.setText(imageModelArrayList.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title,tv_currency_symbol,tv_value;
        ImageView img_next, img_types;

        public MyViewHolder(View itemView) {
            super(itemView);

           // tv_title =  itemView.findViewById(R.id.tv_title);
            tv_currency_symbol =  itemView.findViewById(R.id.tv_currency_symbol);
            tv_value =  itemView.findViewById(R.id.tv_value);
        }

    }
}
