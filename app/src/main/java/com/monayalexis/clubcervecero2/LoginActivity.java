package com.monayalexis.clubcervecero2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.monayalexis.clubcervecero2.view.ContainerActivity;
import com.monayalexis.clubcervecero2.view.CreateAccountActivity;

import static com.monayalexis.clubcervecero2.R.id.container;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonLoguin;
    private TextInputEditText usuarioLogin;
    private TextInputEditText contraseniaLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botonLoguin = findViewById(R.id.buttonIniciarSesion);;
        usuarioLogin = findViewById(R.id.textInputCorreoLogin);
        contraseniaLogin = findViewById(R.id.textInputContrseniaLogin);

        botonLoguin.setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {

            Toast.makeText(LoginActivity.this, "Bienvenido " + currentUser.getDisplayName(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
            startActivity(intent);

        }

    }


    @Override
    public void onClick(View view) {

        if (usuarioLogin.getText().toString().isEmpty() || contraseniaLogin.getText().toString().isEmpty()) {

            Toast.makeText(LoginActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();

        }
        else {

            mAuth.signInWithEmailAndPassword(usuarioLogin.getText().toString(), contraseniaLogin.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LoginActivity.this, "Bienvenido " + user.getDisplayName(), Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
                                startActivity(intent);

                            } else {

                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });

        }

    }


    public void onCreateAccount(View view) {

        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);

    }
}
