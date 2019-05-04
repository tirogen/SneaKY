package com.example.sneaky;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView username = view.findViewById(R.id.username);
        TextView nameEn = view.findViewById(R.id.nameEn);
        TextView nameTh = view.findViewById(R.id.nameTh);
        TextView email = view.findViewById(R.id.email);
        Button signOut = view.findViewById(R.id.signOut);



        try {

            username.setText("User ID: "+LoginActivity.user.getString("username"));
            nameEn.setText("Name En: "+LoginActivity.user.getString("firstname")+LoginActivity.user.getString("lastname"));
            nameTh.setText("Name Th: "+LoginActivity.user.getString("firstnameth")+LoginActivity.user.getString("lastnameth"));
            email.setText("Email: "+LoginActivity.user.getString("email"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        signOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().finish();
                Log.i("ChulaSSO","before sign out");
                Intent intent = new Intent(getActivity(), ChulaSSO_SignOut.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
