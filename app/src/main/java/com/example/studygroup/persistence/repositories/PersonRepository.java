package com.example.studygroup.persistence.repositories;

import android.content.Context;

import com.example.studygroup.domain.Person;
import com.example.studygroup.persistence.DBClient;
import com.example.studygroup.persistence.daos.PersonDao;

import java.util.List;

public class PersonRepository {
    private static PersonRepository _INSTANCE;
    private PersonDao personDao;

    private PersonRepository(Context context){
        personDao = DBClient.getInstance(context).getMyDatabase().personDao();
    }

    public static PersonRepository getInstance(Context context){
        if(_INSTANCE==null)
            _INSTANCE = new PersonRepository(context);
        return _INSTANCE;
    }

    public void create(Person p){
        personDao.create(p);
    }

    public void update(Person p){
        personDao.update(p);
    }

    public List<Person> findAll(){
        return personDao.findAll();
    }

    public Person findById(Integer id){
        return personDao.findById(id);
    }

    public Person findByEmail(String email){ return personDao.findByEmail(email);}

    public List<Person> findByTeachers() {
        return personDao.findByTeachers();
    }

    public List<Person> findByStudents() {
        return personDao.findByStudents();
    }
}
