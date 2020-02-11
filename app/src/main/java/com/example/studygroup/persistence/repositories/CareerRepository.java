package com.example.studygroup.persistence.repositories;

import android.content.Context;

import androidx.room.Room;

import com.example.studygroup.domain.Carrera;
import com.example.studygroup.persistence.daos.CareerDao;
import com.example.studygroup.persistence.databases.MyDatabase;

import java.util.List;

public class CareerRepository {
    private static CareerRepository _INSTANCE;
    private CareerDao careerDao;

    private CareerRepository(Context context) {
        MyDatabase database = Room.databaseBuilder(context, MyDatabase.class, "study_group_db").fallbackToDestructiveMigration().build();
        this.careerDao = careerDao;
    }

    public static CareerRepository getInstance(Context context){
        if(_INSTANCE==null)
            _INSTANCE = new CareerRepository(context);
        return _INSTANCE;
    }

    public void CreateCareer(Carrera c){
        careerDao.create(c);
    }

    public void UpdateCareer(Carrera c){
        careerDao.update(c);
    }

    public Carrera FindById(Integer id){
        return careerDao.findById(id);
    }

    public List<Carrera> FindAll(){
        return careerDao.findAll();
    }
}
