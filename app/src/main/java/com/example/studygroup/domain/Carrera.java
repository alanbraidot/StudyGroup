package com.example.studygroup.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Integer id;
    private List<Materia> materias;
    private String nombre;

    public Carrera(String nombre) {
        this.materias = new ArrayList<>();
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public String getNombre() {
        return nombre;
    }
}
