package com.example.jcrypto.util;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.example.jcrypto.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthService {
    public void signUpService(String email, String password, View view) {

        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(view.getContext(), "enter email and password", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Navigation.findNavController(view).navigate(R.id.action_signUp_to_dashboard);
                            } else {
                                Toast.makeText(view.getContext(), "error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void signInService(String email, String password, View view) {
        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(view.getContext(), "enter email and password", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Navigation.findNavController(view).navigate(R.id.action_signIn_to_dashboard);
                            } else {
                                Toast.makeText(view.getContext(), "error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
