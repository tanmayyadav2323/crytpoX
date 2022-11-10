package com.example.jcrypto.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jcrypto.R;
import com.example.jcrypto.api.ApiService;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends Fragment {

    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        view.findViewById(R.id.auth_logout).setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Navigation.findNavController(view).navigate(R.id.action_dashboard_to_signIn);
        });

        view.findViewById(R.id.coin_track).setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_dashboard_to_coinTracker);
        });

        new ApiService().getRequest(recyclerView, getContext());

        return view;
    }
}