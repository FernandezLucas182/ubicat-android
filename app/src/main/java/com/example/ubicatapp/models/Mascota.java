package com.example.ubicatapp.models;

public class Mascota {

    private int idMascota;
    private String nombre;
    private String especie;
    private int edad;
    private String estado;
    private String fotoUrl;

    public int getIdMascota() { return idMascota; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }
    public String getEstado() { return estado; }
    public String getFotoUrl() { return fotoUrl; }

    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

}