package com.example.laboratorio3;

import static com.example.laboratorio3.MainActivity.REQUEST_CODE_VISITA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VisitaActivity extends AppCompatActivity {

    EditText dni;
    EditText peso;
    EditText temperatura;
    EditText presion;
    EditText nivel_de_saturacion;

    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);

        /* Recuperando DNI del paciente */
        dni = (EditText) findViewById(R.id.editTextDniVisita);
        dni.setText(getIntent().getExtras().getString("DNI"));

        peso = (EditText) findViewById(R.id.editTextPeso);
        temperatura = (EditText) findViewById(R.id.editTextTemperatura);
        presion = (EditText) findViewById(R.id.editTextPresion);
        nivel_de_saturacion = (EditText) findViewById(R.id.editTextNivelDeSaturacion);

        guardar = (Button) findViewById(R.id.btnGuardarVisita);
        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String _peso = peso.getText().toString();
                String _temperatura = temperatura.getText().toString();
                String _presion = presion.getText().toString();
                String _nivel_de_saturacion = nivel_de_saturacion.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("PESO", _peso);
                intent.putExtra("TEMPERATURA", _temperatura);
                intent.putExtra("PRESION", _presion);
                intent.putExtra("NIVEL_DE_SATURACION", _nivel_de_saturacion);

                setResult(REQUEST_CODE_VISITA, intent);
                finish();
            }
        });
    }
}