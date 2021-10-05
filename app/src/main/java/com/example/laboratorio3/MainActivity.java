package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_paciente;
    Button btn_visita;
    ImageButton btn_enviar_correo;

    TextView nombres;
    TextView direccion;
    TextView dni;
    TextView peso;
    TextView temperatura;
    TextView presion;
    TextView nivel_de_saturacion;

    public static final int REQUEST_CODE_PACIENTE = 200;
    public static final int REQUEST_CODE_VISITA = 201;

    private Paciente paciente = new Paciente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = findViewById(R.id.nombres);
        direccion = findViewById(R.id.direccion);
        dni = findViewById(R.id.dni);
        peso = findViewById(R.id.peso);
        temperatura = findViewById(R.id.temperatura);
        presion = findViewById(R.id.presion);
        nivel_de_saturacion = findViewById(R.id.nivel_de_saturacion);

        btn_paciente = findViewById(R.id.ButtonPaciente);
        btn_paciente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PacienteActivity.class);
                startActivityForResult(intent, REQUEST_CODE_PACIENTE);
            }
        });

        btn_visita = findViewById(R.id.ButtonVisita);
        btn_visita.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VisitaActivity.class);
                intent.putExtra("DNI", paciente.getDni());
                startActivityForResult(intent, REQUEST_CODE_VISITA);
            }
        });

        btn_enviar_correo = findViewById(R.id.btnEnviarCorreo);
        btn_enviar_correo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                enviarCorreoPaciente();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PACIENTE) {
            // Recuperar parametros
            paciente.setNombres(data.getStringExtra("NOMBRES"));
            paciente.setDni(data.getStringExtra("DNI"));
            paciente.setDireccion(data.getStringExtra("DIRECCION"));

            // Autocompletar información:
            nombres.setText("Nombres: " + paciente.getNombres());
            dni.setText("Dni: " + paciente.getDni());
            direccion.setText("Dirección: " + paciente.getDireccion());

        } else if (requestCode == REQUEST_CODE_VISITA) {
            paciente.setPeso(Float.parseFloat(data.getStringExtra("PESO")));
            paciente.setTemperatura(Float.parseFloat(data.getStringExtra("TEMPERATURA")));
            paciente.setPresion(Integer.parseInt(data.getStringExtra("PRESION")));
            paciente.setNivel_de_saturacion(Integer.parseInt(data.getStringExtra("NIVEL_DE_SATURACION")));

            peso.setText("Peso: " + paciente.getPeso() + " kg");
            temperatura.setText("Temperatura: " + paciente.getTemperatura() + " °C");
            presion.setText("Presión: " + paciente.getPresion() + " mmHg");
            nivel_de_saturacion.setText("Nivel de saturación: " + paciente.getNivel_de_saturacion() + "%");

        }
    }

    private void enviarCorreoPaciente() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{paciente.getCorreo_electronico()});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Información del Paciente");
        intent.putExtra(Intent.EXTRA_TEXT, paciente.getInformacion());
        startActivity(intent);

    }
}