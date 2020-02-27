package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

@Entity(tableName = "groups")
public class Group {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_group")
    private Integer id;
    @Ignore
    private List<Person> integrantes;
    //TODO Convertir para almacenar
    @Ignore
    private Person teacher;
    @ColumnInfo(name = "name")
    private String nombre;
    //TODO Convertir para almacenar
    @Ignore
    private Career.CareerEnum career;
    //TODO Convertir para almacenar
    @Ignore
    private Subject.SubjectEnum subject;
    //TODO Convertir para almacenar
    @Ignore
    private Faculty.FacultyEnum faculty;
    //TODO Convertir para almacenar
    @Ignore
    private University.UniversityEnum university;
    @Ignore
    private LatLng lugarEncuentro;



    public Group(String nombre, University.UniversityEnum university, Faculty.FacultyEnum faculty, Career.CareerEnum career, Subject.SubjectEnum subject,LatLng lugarEncuentro, List<Person> integrantes, Person teacher  ) {
        this.integrantes = integrantes;
        this.teacher = teacher;
        this.nombre = nombre;
        this.career = career;
        this.subject = subject;
        this.faculty = faculty;
        this.lugarEncuentro = lugarEncuentro;
        this.university= university;
    }

    public Group(){}

    public Integer getId() {
        return id;
    }

    public List<Person> getIntegrantes() {
        return integrantes;
    }

    public Person getTeacher() {
        return teacher;
    }

    public String getNombre() {
        return nombre;
    }

    public Career.CareerEnum getCareer() {
        return career;
    }

    public Subject.SubjectEnum getSubject() {
        return subject;
    }

    public Faculty.FacultyEnum getFaculty() {
        return faculty;
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
