package com.example.jcrypto.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jcrypto.adapter.CryptoAdapter;
import com.example.jcrypto.model.CoinModel;
import com.example.jcrypto.util.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiService {

    public void getRequest(
            RecyclerView recyclerView,
            Context context
    ) {
        String url = "https://api.coinstats.app/public/v1/coins/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray coinJsonArray = response.getJSONArray("coins");
                        ArrayList<CoinModel> coinModelArrayList = new ArrayList<>();
                        for (int i = 0; i < coinJsonArray.length(); i++) {
                            JSONObject coinJsonObject = coinJsonArray.getJSONObject(i);
                            CoinModel coinModel = new CoinModel(
                                    coinJsonObject.getString("id"),
                                    coinJsonObject.getString("icon"),
                                    coinJsonObject.getString("name"),
                                    coinJsonObject.getString("symbol"),
                                    "$ " + coinJsonObject.getString("price")
                            );
                            coinModelArrayList.add(coinModel);
                        }
                        Log.d("@debug", "getRequest: " + coinModelArrayList);
                        CryptoAdapter adapter = new CryptoAdapter(coinModelArrayList);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
