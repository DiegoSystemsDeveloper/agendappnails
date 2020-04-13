package com.example.agendappnails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Clientes extends AppCompatActivity {
    EditText txtNombre, txtApellido, txtCelular, txtDireccion;
    Button btnAnadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        getSupportActionBar().hide();
        conectar();

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposCompletos()) {
                    //guardar(txtNombre.getText().toString(), txtApellido.getText().toString(), txtCelular.getText().toString(), txtDireccion.getText().toString() );
                    Intent i = new Intent( getApplicationContext(), Menu.class );
                    startActivity( i );
                } else
                {
                    Toast.makeText( getApplicationContext(), "¡Diligencie todos los campos!", Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }

    private boolean camposCompletos()
    {
        if(txtNombre.getText().toString().equals( "" )||
                txtApellido.getText().toString().equals( "" )||
                txtCelular.getText().toString().equals( "" )||
                txtDireccion.getText().toString().equals( "" ))
        {
            return false;
        }
        return true;
    }

    private void conectar() {
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtCelular = findViewById(R.id.txtCelular);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnAnadir = findViewById(R.id.btnAnadir);
    }
}
