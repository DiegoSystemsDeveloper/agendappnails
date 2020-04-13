package com.example.agendappnails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Menu extends AppCompatActivity {
    ImageButton imgBtnAgenda, imgBtnClientes, imgBtnProductos, imgBtnTrabajos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        conectar();
        setTitle("Menú");


        imgBtnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Agenda.class);
                startActivity(intent);
            }
        });

        imgBtnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Clientes.class);
                startActivity(intent);
            }
        });

       imgBtnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Productos.class);
                startActivity(intent);
            }
        });

        imgBtnTrabajos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Trabajos.class);
                startActivity(intent);
            }
        });
    }

    private void conectar() {
        imgBtnAgenda = findViewById(R.id.imgBtnAgenda);
        imgBtnClientes = findViewById(R.id.imgBtnClientes);
        imgBtnProductos = findViewById(R.id.imgBtnProductos);
        imgBtnTrabajos = findViewById(R.id.imgBtnTrabajos);
    }
}
