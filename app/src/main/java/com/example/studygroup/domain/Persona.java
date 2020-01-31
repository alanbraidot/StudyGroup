package com.example.studygroup.domain;

import android.graphics.Bitmap;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private Bitmap foto;

    public Persona(String nombre, String apellido, String email, Bitmap foto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Bitmap getFoto() {
        return foto;
    }
}
