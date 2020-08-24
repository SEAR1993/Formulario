package com.santiago.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String EXTRA_NOMBRE = "com.santiago.formulario.EXTRA_NOMBRE";
    public static final String EXTRA_TELEFONO = "com.santiago.formulario.EXTRA_TELEFONO";
    public static final String EXTRA_FECHA = "com.santiago.formulario.EXTRA_FECHA";
    public static final String EXTRA_EMAIL ="com.santiago.formulario.EXTRA_EMAIL";
    public static final String EXTRA_DESCRPCION ="com.santiago.formulario.EXTRA_DESCRPCION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button boton_siguiente = (Button)findViewById(R.id.boton_siguiente);
        boton_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityDatos();
            }
        });

        ImageButton fecha_button =(ImageButton)findViewById(R.id.fecha_button);
        fecha_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "datePicker");

            }
        });

        Intent intent = getIntent();
        String nombre_datos = intent.getStringExtra(Datos.EXTRA_NOMBRE_DATOS);
        String telefono_datos = intent.getStringExtra(Datos.EXTRA_TELEFONO_DATOS);
        String email_datos = intent.getStringExtra(Datos.EXTRA_EMAIL_DATOS);
        String descripcion_datos = intent.getStringExtra(Datos.EXTRA_DESCRIPCION_DATOS);
        String fecha_datos = intent.getStringExtra(Datos.EXTRA_FECHA_DATOS);

        EditText tiet_nombre = (EditText) findViewById(R.id.tiet_nombre);
        EditText et_fecha = (EditText) findViewById(R.id.et_fecha);
        EditText tiet_telefono = (EditText) findViewById(R.id.tiet_telefono);
        EditText tiet_email = (EditText) findViewById(R.id.tiet_email);
        EditText tiet_descripcion = (EditText) findViewById(R.id.tiet_descripcion);

        tiet_nombre.setText(nombre_datos);
        et_fecha.setText(fecha_datos);
        tiet_telefono.setText(telefono_datos);
        tiet_email.setText(email_datos);
        tiet_descripcion.setText(descripcion_datos);


    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c =Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView tv_fecha =(TextView) findViewById(R.id.et_fecha);
        tv_fecha.setText(year + "/" + (month+1) + "/" + dayOfMonth);



    }
    public void openActivityDatos(){
        EditText tiet_nombre = (EditText) findViewById(R.id.tiet_nombre);
        String nombre = tiet_nombre.getText().toString();

        EditText et_fecha = (EditText)findViewById(R.id.et_fecha);
        String fecha = et_fecha.getText().toString();

        EditText tiet_telefono = (EditText)findViewById(R.id.tiet_telefono);
        String telefono = tiet_telefono.getText().toString();

        EditText tiet_email = (EditText) findViewById(R.id.tiet_email);
        String email = tiet_email.getText().toString();

        EditText tiet_descripcion = (EditText) findViewById(R.id.tiet_descripcion);
        String descripcion = tiet_descripcion.getText().toString();

        Intent intent = new Intent(this, Datos.class);
        intent.putExtra(EXTRA_NOMBRE, nombre);
        intent.putExtra(EXTRA_FECHA, fecha);
        intent.putExtra(EXTRA_TELEFONO, telefono);
        intent.putExtra(EXTRA_EMAIL, email);
        intent.putExtra(EXTRA_DESCRPCION, descripcion);
        startActivity(intent);
    }



}

