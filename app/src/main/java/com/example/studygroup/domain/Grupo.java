package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

@Entity(tableName = "groups")
public class Grupo {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_group")
    private Integer id;
    @Ignore
    private List<Estudiante> integrantes;
    //TODO Convertir para almacenar
    @Ignore
    private Tutor tutor;
    @ColumnInfo(name = "name")
    private String nombre;
    //TODO Convertir para almacenar
    @Ignore
    private Carrera carrera;
    //TODO Convertir para almacenar
    @Ignore
    private Materia materia;
    //TODO Convertir para almacenar
    @Ignore
    private Facultad facultad;
    //TODO Convertir para almacenar
    @Ignore
    private LatLng lugarEncuentro;

    public Grupo(List<Estudiante> integrantes, Tutor tutor, String nombre, Carrera carrera, Materia materia, Facultad facultad, LatLng lugarEncuentro) {
        this.integrantes = integrantes;
        this.tutor = tutor;
        this.nombre = nombre;
        this.carrera = carrera;
        this.materia = materia;
        this.facultad = facultad;
        this.lugarEncuentro = lugarEncuentro;
    }

    public Grupo(){}

    public Integer getId() {
        return id;
    }

    public List<Estudiante> getIntegrantes() {
        return integrantes;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String getNombre() {
        return nombre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public LatLng getLugarEncuentro() {
        return lugarEncuentro;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
