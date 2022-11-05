package com.example.jcrypto.view.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jcrypto.R;
import com.example.jcrypto.util.AuthService;

public class SignUp extends Fragment {
    EditText etEmail, etPassword;
    Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // init widgets
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        btnRegister = view.findViewById(R.id.btnRegister);


        view.findViewById(R.id.swipeLeft).setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_signUp_to_signIn);
        });

        view.findViewById(R.id.btnRegister).setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_signUp_to_dashboard);
        });

        // handling click event for signUp
        btnRegister.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            new AuthService().signUpService(email, password, view);
        });


        return view;
    }
}