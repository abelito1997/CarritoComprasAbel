package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.entity.DBHelper;

public class Login extends AppCompatActivity {

    Button btn_ir_crearCuenta,iniciar_sesion;

    DBHelper helper = new DBHelper(this,"DB1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);



        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,SignUp.class));
                finish();
            }
        });

        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtusu=(EditText)findViewById(R.id.et_correo);
                EditText txtPass = (EditText)findViewById(R.id.et_contrasena);
                try {
                    Cursor cursor = helper.ConsultarUsuPas(txtusu.getText().
                            toString(),txtPass.getText().toString());
                    if(cursor.getCount()>0){
                        Intent ir = new Intent(Login.this, MainActivity.class);
                        startActivity(ir);
                    }else{
                        Toast.makeText(getApplicationContext(),"USUARIO Y/O PASSWORD INCORRECTA.",
                                Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtPass.setText("");
                    txtusu.findFocus();
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
        });
    }
}
