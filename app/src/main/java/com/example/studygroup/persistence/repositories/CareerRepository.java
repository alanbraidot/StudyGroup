package com.example.studygroup.persistence.repositories;

import android.content.Context;

import androidx.room.Room;

import com.example.studygroup.domain.Career;
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

    public void CreateCareer(Career c){
        careerDao.create(c);
    }

    public void UpdateCareer(Career c){
        careerDao.update(c);
    }

    public Career FindById(Integer id){
        return careerDao.findById(id);
    }

    public List<Career> FindAll(){
        return careerDao.findAll();
    }
}
