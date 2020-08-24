package com.santiago.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Datos extends AppCompatActivity {
    public static final String EXTRA_NOMBRE_DATOS = "com.santiago.formulario.EXTRA_NOMBRE_DATOS";
    public static final String EXTRA_FECHA_DATOS = "com.santiago.formulario.EXTRA_FECHA_DATOS";
    public static final String EXTRA_TELEFONO_DATOS = "com.santiago.formulario.EXTRA_TELEFONO_DATOS";
    public static final String EXTRA_EMAIL_DATOS = "com.santiago.formulario.EXTRA_EMAIL_DATOS";
    public static final String EXTRA_DESCRIPCION_DATOS = "com.santiago.formulario.EXTRA_DESCRIPCION_DATOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Button button_editarDatos = (Button)findViewById(R.id.button_editarDatos);
        button_editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityEditarDatos();
            }

        });

        Intent intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
        String telefono = intent.getStringExtra(MainActivity.EXTRA_TELEFONO);
        String fecha = intent.getStringExtra(MainActivity.EXTRA_FECHA);
        String email = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        String descripcion = intent.getStringExtra(MainActivity.EXTRA_DESCRPCION);

        TextView tv_nombre_activityDatos = (TextView)findViewById(R.id.tv_nombre_activityDatos);
        TextView tv_telefono_activityDatos = (TextView) findViewById(R.id.tv_telefono_activityDatos);
        TextView tv_fecha_activityDatos = (TextView) findViewById(R.id.tv_fecha_activityDatos);
        TextView tv_email_activityDatos = (TextView) findViewById(R.id.tv_email_activityDatos);
        TextView tv_descripcion_activityDatos = (TextView) findViewById(R.id.tv_descripcion_activityDatos);


        tv_nombre_activityDatos.setText(nombre);
        tv_fecha_activityDatos.setText(fecha);
        tv_telefono_activityDatos.setText("" + telefono );
        tv_email_activityDatos.setText(email);
        tv_descripcion_activityDatos.setText(descripcion);

    }

    public void openActivityEditarDatos() {

        TextView tv_nomre_datos =(TextView)findViewById(R.id.tv_nombre_activityDatos);
        String nombre_datos = tv_nomre_datos.getText().toString();

        TextView tv_fecha_datos =(TextView)findViewById(R.id.tv_fecha_activityDatos);
        String fecha_datos = tv_fecha_datos.getText().toString();

        TextView tv_telefono_datos =(TextView)findViewById(R.id.tv_telefono_activityDatos);
        String telefono_datos = tv_telefono_datos.getText().toString();

        TextView tv_email_datos =(TextView)findViewById(R.id.tv_email_activityDatos);
        String email_datos = tv_email_datos.getText().toString();

        TextView tv_descripcion_datos =(TextView)findViewById(R.id.tv_descripcion_activityDatos);
        String descripcion_datos = tv_descripcion_datos.getText().toString();


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_NOMBRE_DATOS, nombre_datos);
        intent.putExtra(EXTRA_FECHA_DATOS, fecha_datos);
        intent.putExtra(EXTRA_TELEFONO_DATOS, telefono_datos);
        intent.putExtra(EXTRA_EMAIL_DATOS, email_datos);
        intent.putExtra(EXTRA_DESCRIPCION_DATOS, descripcion_datos);

        startActivity(intent);
    }


}