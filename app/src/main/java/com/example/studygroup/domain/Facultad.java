package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(tableName = "faculties")
public class Facultad {

    public enum FacultadEnum {
        FRSF("Facultad Regional Santa Fe"),
        FICH("Facultad de Ingeniería y Ciencias Hídricas"),
        FADU("Facultad de Arquitectura, Diseño y Urbanismo"),
        FIQ("Facultad de Ingeniería Química"),
        FCM("Facultad de Ciencias Médicas"),
        FBCB("Facultad de Bioquímica y Ciencias Biológicas"),
        FCE("Facultad de Ciencias Económicas"),
        FCJS("Facultad de Ciencias Jurídicas y Sociales"),
        FHUC("Facultad de Humanidades y Ciencias");

        private String name;

        FacultadEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id_faculty")
    private Integer id;
    @ColumnInfo(name="faculty_enum")
    private FacultadEnum facultadEnum;
    @Ignore
    private List<Carrera> carreras;
    @Ignore
    private Universidad universidad;

    public Facultad(FacultadEnum facultadEnum, List<Carrera> carreras, Universidad universidad) {
        this.facultadEnum = facultadEnum;
        this.carreras = new ArrayList<>();
        this.universidad = universidad;
    }

    public Integer getId() {
        return id;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public FacultadEnum getFacultadEnum() {
        return facultadEnum;
    }

    public Universidad getUniversidad() {
        return universidad;
    }
}
