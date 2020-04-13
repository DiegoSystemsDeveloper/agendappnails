package com.example.agendappnails;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Productos extends AppCompatActivity implements View.OnClickListener {
    EditText txtProducto, txtCantidad, txtMarca, txtFecha;
    Button btnFecha, btnAnadir;

    //Calendario para obtener fecha
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    private static final String CERO = "0";
    private static final String BARRA = "/";
    private static final String DOS_PUNTOS = ":";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        getSupportActionBar().hide();
        conectar();

        btnFecha.setOnClickListener(this);

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

    //Método booleano que comprueba que todos los campos estén diligenciados
    //Retorna true en caso que todos estén diligenciados y false en caso que todos o alguno no lo esté
    private boolean camposCompletos()
    {
        if(txtProducto.getText().toString().equals( "" )||
                txtCantidad.getText().toString().equals( "" )||
                txtMarca.getText().toString().equals( "" )||
                txtFecha.getText().toString().equals( "" ))
        {
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFecha:
                obtenerFecha();
                break;
        }
    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                txtFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();
    }

    private void conectar() {
        txtProducto = findViewById(R.id.txtProducto);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtMarca = findViewById(R.id.txtMarca);
        txtFecha = findViewById(R.id.txtFecha);
        btnFecha = findViewById(R.id.btnFecha);
        btnAnadir = findViewById(R.id.btnAnadir);
    }
}
