package com.example.jcrypto.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jcrypto.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_dashboard);
                } else {
                    Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_signIn);
                }
            }
        },2000);

        return view;
    }
}