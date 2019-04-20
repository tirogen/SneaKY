package com.example.sneaky;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RentFragment extends Fragment {

    private String rent_name;
    private int rent_price;
    private int rent_image;

    public RentFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RentFragment(String rent_name, int rent_price, int rent_image){
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
        Spinner rt_size = (Spinner)view.findViewById(R.id.rent_size);

        rt_name.setText(this.rent_name);
        rt_price.setText("฿"+this.rent_price);
        rt_image.setImageResource(this.rent_image);

        String[] plants = new String[]{"Size 8","Size 8.5","Size 9","Size 9.5","Size 10","Size 10.5","Size 11","Size 11.5","Size 12"};

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_item,plants);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        rt_size.setAdapter(spinnerArrayAdapter);
        return view;
    }

}
