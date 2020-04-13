package com.example.agendappnails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ingreso extends AppCompatActivity {

    static String usuario = "YoAmoMisUñas";
    static String clave = "2020";

    EditText txtUsuario, txtContraseña;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        setTitle("Ingreso");
        conectar();

        ///////////////////////////////////////////////////////////////////////////////////////////
        ////btnIngreso Inicia el evento de ingresar al menu de admin verificando si el Usuario////
        ////////////y Contraseña son correectos si no, pide que verifique sus datos////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUsuario.getText().toString().trim().equalsIgnoreCase(usuario) && txtContraseña.getText().toString().trim().equalsIgnoreCase(clave)) {
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Verifique que los datos ingresados sean correctos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void conectar() {
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnIngresar = findViewById(R.id.btnIngresar);
    }
}
