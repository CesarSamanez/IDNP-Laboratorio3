package com.example.laboratorio3;

import static com.example.laboratorio3.MainActivity.REQUEST_CODE_PACIENTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PacienteActivity extends AppCompatActivity {

    EditText nombres;
    EditText dni;
    EditText direccion;

    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        nombres = (EditText) findViewById(R.id.editTextNombres);
        dni = (EditText) findViewById(R.id.editTextDni);
        direccion = (EditText) findViewById(R.id.editTextDireccion);

        guardar = (Button) findViewById(R.id.btnGuardarPaciente);
        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String _nombres = nombres.getText().toString();
                String _dni = dni.getText().toString();
                String _direccion = direccion.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("NOMBRES", _nombres);
                intent.putExtra("DNI", _dni);
                intent.putExtra("DIRECCION", _direccion);

                setResult(REQUEST_CODE_PACIENTE, intent);
                finish();
            }
        });
    }
}