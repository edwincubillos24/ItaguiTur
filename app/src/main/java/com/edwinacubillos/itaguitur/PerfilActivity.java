package com.edwinacubillos.itaguitur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView tUsername, tCorreo;
    String username,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Bundle extras = getIntent().getExtras(); //Objeto para extraer la información enviada por el intent desde LoginActivity
        username = extras.getString("username");
        correo = extras.getString("correo");

        tUsername = (TextView) findViewById(R.id.tUsername);
        tCorreo = (TextView) findViewById(R.id.tCorreo);

        tUsername.setText(username);
        tCorreo.setText(correo);
    }
}
