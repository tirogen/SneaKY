package com.example.sneaky;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {

    public StoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        List<Sneaker> lSneaker = new ArrayList<>();
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));
        lSneaker.add(new Sneaker("xxxx",400,R.drawable.test));

        RecyclerView rcv = (RecyclerView) view.findViewById(R.id.recyclerview);
        rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(lSneaker);
        rcv.setAdapter(adapter);
        rcv.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

}
