package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
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

        // Picasso.with(this).load("https://randomuser.me/api/portraits/men/78.jpg").into(profile_pic);
        holder.mTvCurrencySymbol.setText((imageModelArrayList.get(position).getCurrency_symbol()));
        holder.mTvValue.setText(imageModelArrayList.get(position).getValue());
        holder.mTvFrom.setText(imageModelArrayList.get(position).getFrom());
        holder.mTvFromTime.setText(imageModelArrayList.get(position).getFrom_time());
        holder.mTvTripDuration.setText(imageModelArrayList.get(position).getTrip_duration_in_mins());
        holder.mTvTo.setText(imageModelArrayList.get(position).getTo());
        holder.mTvToTime.setText(imageModelArrayList.get(position).getTo_time());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public void initView() {
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

      /*  TextView tv_title,tv_currency_symbol,tv_value;
        ImageView img_next, img_types;
*/
         private CardView mCardView;
        private RelativeLayout mRlFrom;
        private ImageView mImgUp;
        private LinearLayout mLlFrom;
        private TextView mTvFrom;
        private TextView mTvFromTime;
        private TextView mTvTotal;
        private TextView mTvCurrencySymbol;
        private TextView mTvValue;
        private TextView mTvTripDuration;
        private ImageView mImgTrack;
        private ImageView mImgDown;
        private LinearLayout mLlTo;
        private TextView mTvTo;
        private TextView mTvToTime;

        public MyViewHolder(View itemView) {
            super(itemView);

           // tv_title =  itemView.findViewById(R.id.tv_title);
            mTvFrom =  itemView.findViewById(R.id.tv_from);
            mTvFromTime =  itemView.findViewById(R.id.tv_from_time);
            mTvTotal =  itemView.findViewById(R.id.tv_total);
            mTvCurrencySymbol =  itemView.findViewById(R.id.tv_currency_symbol);
            mTvValue =  itemView.findViewById(R.id.tv_value);
            mTvTripDuration =  itemView.findViewById(R.id.tv_trip_duration);
            mTvTo =  itemView.findViewById(R.id.tv_to);
            mTvToTime =  itemView.findViewById(R.id.tv_to_time);


        }

    }
}
