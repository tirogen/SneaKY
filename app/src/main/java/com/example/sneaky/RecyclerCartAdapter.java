package com.example.sneaky;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerCartAdapter.ViewHolder> {

    private List<Cart> mData;
    private Context context;

    public RecyclerCartAdapter(Context context, List<Cart> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cart,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.cart_name.setText(mData.get(i).getName());
        viewHolder.cart_price.setText("฿"+(int) mData.get(i).getPrice());
        Picasso.get().load(mData.get(i).getImage())
                .error(R.drawable.sneaker)
                .placeholder(R.drawable.sneaker)
                .into(viewHolder.cart_image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView cart_name;
        TextView cart_price;
        ImageView cart_image;
        CardView cart_card;

        public  ViewHolder(View view){
            super(view);
            cart_name = (TextView) view.findViewById(R.id.cart_name);
            cart_price = (TextView) view.findViewById(R.id.cart_price);
            cart_image = (ImageView) view.findViewById(R.id.cart_image);
            cart_card = (CardView) view.findViewById(R.id.cart_id);
        }
    }
}
