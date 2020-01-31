package com.example.studygroup.domain;

import java.util.List;

public class Universidad {
    private Integer id;
    private List<Facultad> facultades;
    private String nombre;

    public Universidad(List<Facultad> facultades, String nombre) {
        this.facultades = facultades;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public String getNombre() {
        return nombre;
    }
}
