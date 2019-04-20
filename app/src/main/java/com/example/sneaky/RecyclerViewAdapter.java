package com.example.sneaky;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Sneaker> mData;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Sneaker> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.sneaker_name.setText(mData.get(i).getName());
        viewHolder.sneaker_price.setText("฿"+(int) mData.get(i).getPrice());
        viewHolder.sneaker_image.setImageResource(mData.get(i).getImage());
        viewHolder.sneaker_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"test click",Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = ((AppCompatActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainFrame, new RentFragment(mData.get(i).getName(),(int) mData.get(i).getPrice(), mData.get(i).getImage()));
                fragmentTransaction.commit();

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
