package com.example.studygroup.controllers;
import android.content.Context;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Person;
import com.example.studygroup.persistence.DBClient;
import com.example.studygroup.persistence.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonController {
    private static PersonController _INSTANCE;

    public PersonController(){
        _INSTANCE = new PersonController();
    }

    public static PersonController getInstance() {
        return _INSTANCE;
    }

    public static Person findPeople(String email, Context context){
        return PersonRepository.getInstance(context).findByEmail(email);
    }

    public ArrayList<Person> findMembers(Career.CareerEnum career, Faculty.FacultyEnum faculty, Context context){
        ArrayList<Person> p = new ArrayList<Person>();
        p= (ArrayList<Person>) PersonRepository.getInstance(context).findAll();
        int i=0;
        while(i<p.size()){
            if(!p.get(i).getCareerEnum().equals(career) && !p.get(i).getFacultyEnum.equals(faculty)){
                p.remove(i);
                i++;
            }
            else i++;
        }
        return p;
    }
}
