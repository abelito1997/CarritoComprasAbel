package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.entity.DBHelper;

public class SignUp extends AppCompatActivity {

    EditText txtNombre,txtTelefono, txtEmail, txtContraseña;
    Button btn_ir_inicioSesion,crear_cuenta;
    DBHelper helper = new DBHelper(this, "DB1", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_ir_inicioSesion=findViewById(R.id.btn_ir_inicioSesion);
        crear_cuenta=findViewById(R.id.crear_cuenta);
        txtNombre = (EditText) findViewById(R.id.et_nombre);
        txtTelefono = (EditText) findViewById(R.id.et_telefono);
        txtEmail = (EditText) findViewById(R.id.et_correo);
        txtContraseña = (EditText) findViewById(R.id.et_contrasena);



        btn_ir_inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,Login.class));
                finish();
            }
        });

        crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SignUp.this, "Registrar Usuario", Toast.LENGTH_SHORT).show();
            //Aquí codigo

                helper.abrir();
                helper.insertarRegistro(String.valueOf(txtNombre.getText()),
                        String.valueOf(txtTelefono.getText()),
                        String.valueOf(txtEmail.getText()),
                        String.valueOf(txtContraseña.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(), "SE HA REGISTRADO CON EXITO..!!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);

        }
        });
    }
}
