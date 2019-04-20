package com.example.sneaky;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Sneaker> mData;

    public RecyclerViewAdapter(List<Sneaker> mData) {
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.sneaker_name.setText(mData.get(i).getName());
        viewHolder.sneaker_price.setText(mData.get(i).getPrice()+"");
        viewHolder.sneaker_image.setImageResource(mData.get(i).getImage());
        viewHolder.sneaker_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        TextView sneaker_name;
        TextView sneaker_price;
        ImageView sneaker_image;
        CardView sneaker_card;

        public  ViewHolder(View view){
            super(view);
            sneaker_name = (TextView) view.findViewById(R.id.item_name);
            sneaker_price = (TextView) view.findViewById(R.id.item_price);
            sneaker_image = (ImageView) view.findViewById(R.id.item_image);
            sneaker_card = (CardView) view.findViewById(R.id.item_id);
        }
    }
}
