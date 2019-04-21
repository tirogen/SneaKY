package com.example.sneaky;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RentFragment extends Fragment {

    private int sneaker;
    private String rent_name;
    private int rent_price;
    private String rent_image;

    public RentFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RentFragment(int sneaker, String rent_name, int rent_price, String rent_image){
        this.sneaker = sneaker;
        this.rent_name = rent_name;
        this.rent_price = rent_price;
        this.rent_image = rent_image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rent, container, false);

        TextView rt_name = (TextView)view.findViewById(R.id.rent_name);
        TextView rt_price = (TextView)view.findViewById(R.id.rent_price);
        ImageView rt_image = (ImageView)view.findViewById(R.id.rent_image);
        final Spinner rt_size = (Spinner)view.findViewById(R.id.rent_size);
        Button rt_rent = (Button)view.findViewById(R.id.rent_rent);

        rt_name.setText(this.rent_name);
        rt_price.setText("฿"+this.rent_price);
        Picasso.get().load(this.rent_image)
                .error(R.drawable.sneaker)
                .placeholder(R.drawable.sneaker)
                .into(rt_image);

        String[] size = new String[]{"Size 8","Size 8.5","Size 9","Size 9.5","Size 10","Size 10.5","Size 11","Size 11.5","Size 12"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_item,size);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        rt_size.setAdapter(spinnerArrayAdapter);

        rt_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = "6031032921";
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                CartModel cartData = new CartModel(rent_name, rent_price, rent_image, rt_size.getSelectedItem().toString(), new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()), "On progress", "Waiting Contact");
                DatabaseReference mUsers = mDatabase.child("user").child(key);
                mUsers.push().setValue(cartData);

                Toast.makeText(getActivity(),rent_name + " : " + rt_size.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
