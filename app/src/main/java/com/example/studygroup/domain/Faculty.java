package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "faculties")
public class Faculty {

    public enum FacultadEnum {
        FRSF("Faculty Regional Santa Fe"),
        FICH("Faculty de Ingeniería y Ciencias Hídricas"),
        FADU("Faculty de Arquitectura, Diseño y Urbanismo"),
        FIQ("Faculty de Ingeniería Química"),
        FCM("Faculty de Ciencias Médicas"),
        FBCB("Faculty de Bioquímica y Ciencias Biológicas"),
        FCE("Faculty de Ciencias Económicas"),
        FCJS("Faculty de Ciencias Jurídicas y Sociales"),
        FHUC("Faculty de Humanidades y Ciencias");

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
    //TODO Convertir para almacenar
    @Ignore
    private FacultadEnum facultadEnum;
    @Ignore
    private List<Career> careers;
    @Ignore
    private University university;

    public Faculty(FacultadEnum facultadEnum, List<Career> careers, University university) {
        this.facultadEnum = facultadEnum;
        this.careers = new ArrayList<>();
        this.university = university;
    }

    public Faculty(){}

    public Integer getId() {
        return id;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public FacultadEnum getFacultadEnum() {
        return facultadEnum;
    }

    public University getUniversity() {
        return university;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }
}
