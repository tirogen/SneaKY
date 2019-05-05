package com.example.sneaky;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity{

    public static JSONObject user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View view) {
        Intent intent = new Intent(this, ChulaSSO.class);
        startActivityForResult(intent, ChulaSSO.LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ChulaSSO.LOGIN && resultCode == Activity.RESULT_OK) {
            String ticket = data.getStringExtra("ticket");
            HelperTask helperTask = new HelperTask();
            helperTask.execute(ticket);
        }
    }

    class HelperTask extends AsyncTask<String, Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String ticket=strings[0];
            String json = th.ac.chula.sso.ChulaSSOHelper.serviceValidation(ticket);
            return json;
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
            try {
                LoginActivity.user = new JSONObject(json);
                Log.i("ChulaSSO","go to mainactivity");

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                //Log.i("ChulaSSO", user.getString("username")+"\n"+json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

