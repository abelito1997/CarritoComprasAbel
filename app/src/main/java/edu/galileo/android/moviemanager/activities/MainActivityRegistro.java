package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.galileo.android.moviemanager.R;

public class MainActivityRegistro extends AppCompatActivity {

    Button ir_login;
    Button face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ir_login=findViewById(R.id.ir_login);
        face=findViewById(R.id.inicar_facebook);
        ir_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityRegistro.this,Login.class));
                finish();

            }
        });

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityRegistro.this,MainActivity.class));
                finish();
            }
        });

    }

}
