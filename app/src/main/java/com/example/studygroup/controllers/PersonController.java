package com.example.studygroup.controllers;
import com.example.studygroup.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private static PersonController _INSTANCE;
    private List<Person> studentList;
    private List<Person> teacherList;
    private List<Person> peopleList;

    public PersonController(){
        _INSTANCE = new PersonController();
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        peopleList = new ArrayList<>();
    }

    public static PersonController getInstance() {
        return _INSTANCE;
    }

    public List<Person> getStudentList() {
        return studentList;
    }
    public List<Person> getTeacherList() {
        return teacherList;
    }
    public List<Person> getPeopleList() { return peopleList; }
    public static Person findPeople(String email){
        Person p = new Person();
        //TODO buscar persona por email
        return p;
    }
}
