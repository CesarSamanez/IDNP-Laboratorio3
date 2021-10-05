package com.example.laboratorio3;

public class Paciente {

    private String dni;
    private String nombres;
    private String direccion;
    private float peso;
    private float temperatura;
    private int presion;
    private int nivel_de_saturacion;
    private String correo_electronico = "paciente_prueba@gmail.com";

    Paciente() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public int getNivel_de_saturacion() {
        return nivel_de_saturacion;
    }

    public void setNivel_de_saturacion(int nivel_de_saturacion) {
        this.nivel_de_saturacion = nivel_de_saturacion;
    }

    public String getCorreo_electronico(){
        return correo_electronico;
    }

    public String getInformacion() {
        return "Nombres: " + nombres + "\n" +
                "Dni: " + dni + "\n" +
                "Dirección: " + direccion + "\n" +
                "Peso: " + peso + " kg\n" +
                "Temperatura: " + temperatura + " °C\n" +
                "Presión: " + presion + " mmHg\n" +
                "Nivel de Saturación: " + nivel_de_saturacion + " %";
    }
}
