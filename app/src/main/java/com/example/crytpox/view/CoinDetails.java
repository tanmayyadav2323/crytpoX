package com.example.jcrypto.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jcrypto.R;

public class CoinDetails extends Fragment {
    ImageView img_back, coin_icon;
    TextView coin_symbol, coin_name, coin_price;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coin_details, container, false);

        img_back = view.findViewById(R.id.img_back);
        coin_icon = view.findViewById(R.id.coin_icon);
        coin_symbol = view.findViewById(R.id.coin_symbol);
        coin_name = view.findViewById(R.id.coin_name);
        coin_price = view.findViewById(R.id.coin_price);

        img_back.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_coinDetails_to_dashboard);
        });

        // Get All Data
        String icon = getArguments().getString("icon");
        String symbol = getArguments().getString("symbol");
        String name = getArguments().getString("name");
        String price = getArguments().getString("price");


        Glide.with(view).load(icon).into(coin_icon);
        coin_symbol.setText(symbol);
        coin_name.setText("Name: " + name);
        coin_price.setText("Price: " + price);

        return view;
    }
}