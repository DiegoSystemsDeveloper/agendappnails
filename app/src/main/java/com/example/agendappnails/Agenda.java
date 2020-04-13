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

public class Agenda extends AppCompatActivity implements View.OnClickListener{
    EditText txtFechaInicio, txtFechaFinal, txtHoraInicio, txtHoraFinal;
    Button btnFechaInicio, btnFechaFinal, btnHoraInicio, btnHoraFinal, btnRegistrar;

    //Calendario para obtener fecha
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    private static final String CERO = "0";
    private static final String BARRA = "/";
    private static final String DOS_PUNTOS = ":";

    //Variables para obtener la hora hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        getSupportActionBar().hide();

        //Conexion XML - JAVA
        btnFechaInicio = findViewById(R.id.btnFechaInicio);
        btnFechaFinal = findViewById(R.id.btnFechaFinal);
        btnHoraInicio = findViewById(R.id.btnHoraInicio);
        btnHoraFinal = findViewById(R.id.btnHoraFinal);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtFechaInicio = findViewById(R.id.txtFechaInicio);
        txtFechaFinal = findViewById(R.id.txtFechaFinal);
        txtHoraInicio = findViewById(R.id.txtHoraInicio);
        txtHoraFinal = findViewById(R.id.txtHoraFinal);

        btnFechaInicio.setOnClickListener(this);
        btnFechaFinal.setOnClickListener(this);
        btnHoraInicio.setOnClickListener(this);
        btnHoraFinal.setOnClickListener(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposCompletos()) {
                    //guardar(txtFechaInicio.getText().toString(), txtFechaFinal.getText().toString(), txtHoraInicio.getText().toString(), txtHoraFinal.getText().toString() );
                    Intent i = new Intent( getApplicationContext(), Menu.class );
                    startActivity( i );
                } else
                {
                    Toast.makeText( getApplicationContext(), "¡Diligencie todos los campos!", Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }

    private void guardar() {
    }

    //Método booleano que comprueba que todos los campos estén diligenciados
    //Retorna true en caso que todos estén diligenciados y false en caso que todos o alguno no lo esté
    private boolean camposCompletos()
    {
        if(txtFechaInicio.getText().toString().equals( "" )||
                txtFechaFinal.getText().toString().equals( "" )||
                txtHoraInicio.getText().toString().equals( "" )||
                txtHoraFinal.getText().toString().equals( "" ))
        {
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFechaInicio:
                obtenerFechaInicio();                
                break;
            case R.id.btnFechaFinal:
                obtenerFechaFinal();
                break;
            case R.id.btnHoraInicio:
                obtenerHoraInicio();
                break;
            case R.id.btnHoraFinal:
                obtenerHoraFinal();
                break;
        }
    }

    private void obtenerHoraInicio(){
        TimePickerDialog recogerHoraInicio = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                String horaFormateada =  (hourOfDay < 10)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hora con el formato deseado
                txtHoraInicio.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);
        recogerHoraInicio.show();
    }
    private void obtenerHoraFinal(){
        TimePickerDialog recogerHoraFinal = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                String horaFormateada =  (hourOfDay < 10)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hora con el formato deseado
                txtHoraFinal.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);
        recogerHoraFinal.show();
    }
    private void obtenerFechaInicio(){
        DatePickerDialog recogerFechaInicio = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                txtFechaInicio.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFechaInicio.show();
    }
    private void obtenerFechaFinal(){
        DatePickerDialog recogerFechaFinal = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                txtFechaFinal.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFechaFinal.show();
    }
}
