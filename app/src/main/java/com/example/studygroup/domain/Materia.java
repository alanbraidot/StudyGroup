package com.example.studygroup.domain;

public class Materia {
    private Integer id;
    private String nombre;

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
