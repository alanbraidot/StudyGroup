package com.example.studygroup.controllers;
import com.example.studygroup.domain.Estudiante;
import com.example.studygroup.domain.Persona;
import com.example.studygroup.domain.Tutor;

import java.util.ArrayList;
import java.util.List;

public class PeopleController {
    private static PeopleController _INSTANCE;
    private List<Estudiante> studentList;
    private List<Tutor> teacherList;
    private List<Persona> peopleList;

    public PeopleController(){
        _INSTANCE = new PeopleController();
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        peopleList = new ArrayList<>();
    }

    public static PeopleController getInstance() {
        return _INSTANCE;
    }

    public List<Estudiante> getStudentList() {
        return studentList;
    }
    public List<Tutor> getTeacherList() {
        return teacherList;
    }
    public List<Persona> getPeopleList() { return peopleList; }
    public static Persona findPeople(String email){
        Persona p = new Persona();
        //TODO buscar persona por email
        return p;
    }
}
