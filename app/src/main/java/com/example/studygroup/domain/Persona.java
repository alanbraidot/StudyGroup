package com.example.studygroup.domain;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private Bitmap foto;
    private Domicilio domicilio;
    private List<Grupo> grupos;

    public Persona(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.domicilio = domicilio;
        this.foto = foto;
    }

    public Persona (){}

    public Integer getId() { return id; }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public List<Grupo> getGrupos() {return grupos;}
}
