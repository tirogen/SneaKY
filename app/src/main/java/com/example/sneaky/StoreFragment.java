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
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
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
                    //Log.d(TAG, "Value is: " + data.getKey());
                }
                rcv.setAdapter(new RecyclerViewAdapter(getActivity(),lSneaker));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getActivity(),"Failed to read value",Toast.LENGTH_LONG).show();
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        SearchView searchView = (SearchView)view.findViewById(R.id.search);
        searchView.setQueryHint("Search View");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchData(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                searchData(query);
                return false;
            }
        });

        return view;
    }

    private void searchData(String query){
        List<Sneaker> qSneaker = new ArrayList<>();
        for(Sneaker item: lSneaker){
            if(item.getName().toLowerCase().contains(query.toLowerCase())) qSneaker.add(item);
        }
        rcv.setAdapter(new RecyclerViewAdapter(getActivity(),qSneaker));
    }

}
