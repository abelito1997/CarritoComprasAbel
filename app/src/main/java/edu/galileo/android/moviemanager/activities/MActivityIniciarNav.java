package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;

public class MActivityIniciarNav extends AppCompatActivity
      {

          Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);



        next=(Button)findViewById(R.id.btnIni);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                //Intent iniNav=new Intent(MActivityIniciarNav.this, Registrarse.class);
                //startActivity(iniNav);

            }
        });

       


    }


}
