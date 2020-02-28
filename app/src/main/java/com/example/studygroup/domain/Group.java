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
    //TODO Convertir para almacenar
    @Ignore
    private List<Person> integrantes;
    @ColumnInfo(name = "id_teacher")
    private Person teacher;
    @ColumnInfo(name = "name")
    private String nombre;
    @ColumnInfo(name = "career")
    private Career.CareerEnum career;
    @ColumnInfo(name = "subject")
    private Subject.SubjectEnum subject;
    @ColumnInfo(name = "faculty")
    private Faculty.FacultyEnum faculty;
    @ColumnInfo(name = "university")
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

    public LatLng getLugarEncuentro() {
        return lugarEncuentro;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
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

    public void setCareer(Career.CareerEnum career) {
        this.career = career;
    }

    public void setSubject(Subject.SubjectEnum subject) {
        this.subject = subject;
    }

    public void setFaculty(Faculty.FacultyEnum faculty) {
        this.faculty = faculty;
    }

    public University.UniversityEnum getUniversity() {
        return university;
    }

    public void setUniversity(University.UniversityEnum university) {
        this.university = university;
    }
}
