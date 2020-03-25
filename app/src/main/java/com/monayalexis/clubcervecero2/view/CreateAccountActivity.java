package com.monayalexis.clubcervecero2.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.monayalexis.clubcervecero2.LoginActivity;
import com.monayalexis.clubcervecero2.R;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Button crearCuenta;
    private TextInputEditText textInputCorreo;
    private TextInputEditText textInputContrasenia;
    private TextInputEditText textInputNombre;
    private TextInputEditText getTextInputContraseniaConfirmacion;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        showToolbar(getResources().getString(R.string.app_toolbar_title_createacount));

        textInputCorreo = findViewById(R.id.textInputCorreo);
        textInputContrasenia = findViewById(R.id.textInputContraseniaNueva);
        getTextInputContraseniaConfirmacion = findViewById(R.id.textInputcontraseniaConfirmacion);
        textInputNombre = findViewById(R.id.textInputNombre);
        mAuth = FirebaseAuth.getInstance();
        crearCuenta = findViewById(R.id.crearCuenta);

        crearCuenta.setOnClickListener(this);
    }

    @SuppressLint("RestrictedApi")
    public void showToolbar(String titulo) {

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(titulo);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View view) {

        if (textInputCorreo.getText().toString().isEmpty() || textInputContrasenia.getText().toString().isEmpty() ||
                getTextInputContraseniaConfirmacion.getText().toString().isEmpty() || textInputNombre.getText().toString().isEmpty()) {

            Toast.makeText(CreateAccountActivity.this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();

        }
        else {

            if (!textInputContrasenia.getText().toString().equals(getTextInputContraseniaConfirmacion.getText().toString())) {

                Toast.makeText(CreateAccountActivity.this, "Las contraseñas deben ser iguales", Toast.LENGTH_LONG).show();

            }
            else {

                mAuth.createUserWithEmailAndPassword(textInputCorreo.getText().toString(), textInputContrasenia.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = mAuth.getCurrentUser();

                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(textInputNombre.getText().toString())
                                            .setPhotoUri(Uri.parse("https://static.independent.co.uk/s3fs-public/thumbnails/image/2019/08/02/10/beer-main-0.jpg?w968"))
                                            .build();

                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Intent intent = new Intent(CreateAccountActivity.this, ContainerActivity.class);
                                                        startActivity(intent);
                                                        Toast.makeText(CreateAccountActivity.this, "Authentication successfully.",
                                                                Toast.LENGTH_SHORT).show();
                                                        Toast.makeText(CreateAccountActivity.this, "Bienvenido " + textInputNombre.getText().toString(),
                                                                Toast.LENGTH_SHORT).show();

                                                    }
                                                }
                                            });

                                }
                                else {
                                    Toast.makeText(CreateAccountActivity.this, task.getException().getMessage(),
                                            Toast.LENGTH_LONG).show();
                                }

                            }

                        });

            }

        }

    }
}
