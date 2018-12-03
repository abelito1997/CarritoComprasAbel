package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.fragments.IniciarSesion;

public class MainActivityIniciar extends AppCompatActivity
      {
          Button ir;
          Button ini;
          Button face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panregis);


  ir=(Button)findViewById(R.id.btnregistrar);
  ir.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

          //Context context = getApplicationContext();
          //CharSequence text = "Hello toast!";
          //int duration = Toast.LENGTH_SHORT;

          //Toast toast = Toast.makeText(context, text, duration);
          //toast.show();
          Intent ir=new Intent(MainActivityIniciar.this, Registrarse.class);
          startActivity(ir);

      }
  });

        ini=(Button)findViewById(R.id.btniniciar);
        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Context context = getApplicationContext();
                //CharSequence text = "Hello toast!";
                //int duration = Toast.LENGTH_SHORT;

                //Toast toast = Toast.makeText(context, text, duration);
                //toast.show();
                Intent ini=new Intent(MainActivityIniciar.this, Iniciarse.class);
                startActivity(ini);

            }
        });

        face=(Button)findViewById(R.id.btnfacebook);
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Context context = getApplicationContext();
                //CharSequence text = "Hello toast!";
                //int duration = Toast.LENGTH_SHORT;

                //Toast toast = Toast.makeText(context, text, duration);
                //toast.show();
                Intent face=new Intent(MainActivityIniciar.this, MainActivity.class);
                startActivity(face);

            }
        });


    }


}
