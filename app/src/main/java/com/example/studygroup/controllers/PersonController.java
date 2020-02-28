package com.example.studygroup.controllers;
import android.content.Context;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.persistence.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private static PersonController _INSTANCE = new PersonController();

    public PersonController(){}

    public static PersonController getInstance() {
        return _INSTANCE;
    }

    public static Person findPerson(String email, Context context){
        return PersonRepository.getInstance(context).findByEmail(email);
    }

    public static Person findPersonById(Integer id, Context context){
        return PersonRepository.getInstance(context).findById(id);
    }

    public ArrayList<Person> findMembers(Career.CareerEnum career, Faculty.FacultyEnum faculty, Context context){
        ArrayList<Person> p = (ArrayList<Person>) PersonRepository.getInstance(context).findAll();
        int i=0;
        while(i<p.size()){
            if(!p.get(i).getCareerEnum().equals(career) && !p.get(i).getFacultyEnum().equals(faculty)){
                p.remove(i);
                i++;
            }
            else i++;
        }
        return p;
    }

    public static void save(Person person, Context context){
        PersonRepository.getInstance(context).create(person);
    }

    public static List<Person> findTeachers(Context context){
        return PersonRepository.getInstance(context).findByTeachers();
    }

    public static List<Person> findStudents(Context context){
        return PersonRepository.getInstance(context).findByStudents();
    }

    public static List<Person> findTeachersBySubject(Subject.SubjectEnum subjectEnum, Context context){
        List<Person> teachers = PersonRepository.getInstance(context).findByTeachers();
        List<Person> qualifiedTeachers = new ArrayList<>();
        for (Person p : teachers){
            if(p.getMateriasHabilitadas().contains(subjectEnum))
                qualifiedTeachers.add(p);
        }
        return qualifiedTeachers;
    }
}
