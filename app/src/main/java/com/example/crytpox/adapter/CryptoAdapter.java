package com.example.jcrypto.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jcrypto.R;
import com.example.jcrypto.model.CoinModel;

import java.util.List;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder> {

    List<CoinModel> coinModelList;

    public CryptoAdapter(
            List<CoinModel> coinModelList
    ) {
        this.coinModelList = coinModelList;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_list, parent, false);
        return new CryptoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        CoinModel coinModel = coinModelList.get(position);
        holder.c_symbol.setText(coinModel.getSymbol());
        holder.c_name.setText(coinModel.getName());
        holder.c_price.setText(coinModel.getPrice());
        holder.crypto_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("icon", coinModel.getIcon());
                bundle.putString("symbol", coinModel.getSymbol());
                bundle.putString("name", coinModel.getName());
                bundle.putString("price", coinModel.getPrice());
                Navigation.findNavController(view).navigate(R.id.action_dashboard_to_coinDetails, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coinModelList.size();
    }

    public class CryptoViewHolder extends RecyclerView.ViewHolder {

        CardView crypto_card;
        TextView c_name, c_symbol, c_price;

        public CryptoViewHolder(@NonNull View itemView) {
            super(itemView);

            crypto_card = itemView.findViewById(R.id.crypto_card);
            c_symbol = itemView.findViewById(R.id.c_symbol);
            c_price = itemView.findViewById(R.id.c_price);
            c_name = itemView.findViewById(R.id.c_name);
        }
    }
}
