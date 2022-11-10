package com.example.jcrypto.view.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jcrypto.R;
import com.example.jcrypto.util.AuthService;

public class SignIn extends Fragment {
    EditText loginEmail, loginPassword;
    Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        // init widgets
        loginEmail = view.findViewById(R.id.loginEmail);
        loginPassword = view.findViewById(R.id.loginPassword);
        btnLogin = view.findViewById(R.id.btnLogin);


        view.findViewById(R.id.swipeReg).setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_signIn_to_signUp);
        });

        view.findViewById(R.id.btnLogin).setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_signIn_to_dashboard);
        });

        // Event Handling For SignIn
        btnLogin.setOnClickListener(v -> {
            String email = loginEmail.getText().toString();
            String password = loginPassword.getText().toString();

            new AuthService().signInService(email, password, view);
        });

        return view;
    }
}