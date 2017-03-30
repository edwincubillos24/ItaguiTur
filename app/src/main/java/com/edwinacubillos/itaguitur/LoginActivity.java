package com.edwinacubillos.itaguitur;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, ePassword;
    TextView tRegistrarse;
    Button bIniciar;
    Intent intent;
    String username="", password="", correo="";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        username = prefs.getString("nombre","");
        password = prefs.getString("pass","");
        correo = prefs.getString("mail","");

        Log.d("user",username);
        Log.d("login",String.valueOf(prefs.getInt("login",-1)));

        if ( prefs.getInt("login",-1) == 1 ){  //1 hay alguien loggeado -1 no hay nadie loggeado
            intent = new Intent (LoginActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        eUsername = (EditText) findViewById(R.id.eUsername);
        ePassword = (EditText) findViewById(R.id.ePassword);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);
        bIniciar = (Button) findViewById(R.id.bIniciar);

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validan que los dos campos esten diligenciados

                //Validar los datos digitados con los del registro
                if (eUsername.getText().toString().equals(username) && ePassword.getText().toString().equals(password)){

                    editor.putInt("login",1);
                    editor.commit();

                    intent = new Intent (LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent (LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent, 1234);//request code

            }
        });
    }

    //metodos de override Ctrl + O (no es un cero)

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode == RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");

            editor.putString("nombre",username);
            editor.putString("pass",password);
            editor.putString("mail",correo);
            editor.commit();

        }
        if (requestCode==1234 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Registro cancelado", Toast.LENGTH_SHORT).show();
        }



    }
}
