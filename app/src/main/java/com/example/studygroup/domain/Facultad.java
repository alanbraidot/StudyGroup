package com.example.studygroup.domain;

import java.util.List;

public class Facultad {
    private Integer id;
    private List<Carrera> carreras;
    private String nombre;

    public Facultad(List<Carrera> carreras, String nombre) {
        this.carreras = carreras;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public String getNombre() {
        return nombre;
    }
}
