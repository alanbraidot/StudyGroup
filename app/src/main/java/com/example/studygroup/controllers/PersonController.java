package com.example.studygroup.controllers;
import com.example.studygroup.domain.Student;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private static PersonController _INSTANCE;
    private List<Student> studentList;
    private List<Teacher> teacherList;
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

    public List<Student> getStudentList() {
        return studentList;
    }
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    public List<Person> getPeopleList() { return peopleList; }
    public static Person findPeople(String email){
        Person p = new Person();
        //TODO buscar persona por email
        return p;
    }
}
