package com.example.sneaky;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {

    private List<Sneaker> lSneaker;
    private RecyclerView rcv;

    public StoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        lSneaker = new ArrayList<>();

        //lSneaker.add(new Sneaker("TEST IMAGE",456,"http://i.imgur.com/DvpvklR.png"));
        rcv = (RecyclerView) view.findViewById(R.id.recyclerview);
        rcv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rcv.addItemDecoration( new LayoutMarginDecoration( 2, 60 ) );
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),lSneaker);
        rcv.setAdapter(adapter);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("sneaker");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Sneaker item = data.getValue(Sneaker.class);
                    lSneaker.add(item);
                    rcv.setAdapter(new RecyclerViewAdapter(getActivity(),lSneaker));
                    Log.d(TAG, "Value is: " + data.getKey());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getActivity(),"Failed to read value",Toast.LENGTH_LONG).show();
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return view;
    }

}
