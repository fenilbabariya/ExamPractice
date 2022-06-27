package com.rku_21soeca21002.exampractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AssetJson extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> formulas;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_json);

        recyclerView = findViewById(R.id.recyclerView);
        formulas = getAssotJSONData();
        adapter = new UserAdapter(formulas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<User> getAssotJSONData() {
        ArrayList<User> formulas = new ArrayList<User>();
        String data = "";

        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            data= new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if(!data.equals(""))
        {
            JSONObject object = null;
            try {
                object = new JSONObject(data);
                JSONArray array = object.getJSONArray("formulas");
                for(int i=0;i<array.length();i++)
                {
                    JSONObject tempObj = array.getJSONObject(i);
                    String formula = tempObj.getString("formula");
                    String url = tempObj.getString("url");
                    formulas.add(new User(formula,url));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return formulas;
    }

}