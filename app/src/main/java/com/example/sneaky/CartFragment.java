package com.example.sneaky;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private RecyclerView rcv;
    private List<Cart> cSneaker;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        cSneaker = new ArrayList<>();
        rcv = (RecyclerView) view.findViewById(R.id.cart);
        rcv.setLayoutManager(new GridLayoutManager(getActivity(),1));
        rcv.addItemDecoration( new LayoutMarginDecoration( 1, 60 ) );
        RecyclerCartAdapter adapter = new RecyclerCartAdapter(getActivity(),cSneaker);
        rcv.setAdapter(adapter);

        String key = "6031032921";
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("user").child(key);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Cart item = data.getValue(Cart.class);
                    //Log.d(TAG,item.getName());
                    cSneaker.add(item);
                }
                rcv.setAdapter(new RecyclerCartAdapter(getActivity(),cSneaker));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getActivity(),"Failed to read value",Toast.LENGTH_LONG).show();
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return view;
    }

}
