package com.example.agendappnails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Trabajos extends AppCompatActivity {
    EditText txtTrabajo, txtValor, txtDuracion;
    Button btnAnadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);
        getSupportActionBar().hide();

        conectar();

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposCompletos()) {
                    //guardar(txtTrabajo.getText().toString(), txtValor.getText().toString(), txtDuracion.getText().toString() );
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
        if(txtTrabajo.getText().toString().equals( "" )||
                txtValor.getText().toString().equals( "" )||
                txtDuracion.getText().toString().equals( "" ))
        {
            return false;
        }
        return true;
    }

    private void conectar() {
        txtTrabajo = findViewById(R.id.txtTrabajo);
        txtValor = findViewById(R.id.txtValor);
        txtDuracion = findViewById(R.id.txtDuracion);
        btnAnadir = findViewById(R.id.btnAnadir);
    }
}
