package com.example.studygroup.persistence.repositories;

import android.content.Context;

import androidx.room.Room;

import com.example.studygroup.domain.Tutor;
import com.example.studygroup.persistence.daos.TeacherDao;
import com.example.studygroup.persistence.databases.MyDatabase;

import java.util.List;

public class TeacherRepository {
    private static TeacherRepository _INSTANCE;
    private TeacherDao teacherDao;

    private TeacherRepository(Context context){
        MyDatabase database = Room.databaseBuilder(context, MyDatabase.class, "study_group_db").fallbackToDestructiveMigration().build();
        teacherDao = database.teacherDao();
    }

    public static TeacherRepository getInstance(Context context){
        if(_INSTANCE==null)
            _INSTANCE = new TeacherRepository(context);
        return _INSTANCE;
    }

    public void CreateTeacher(Tutor t){
        teacherDao.create(t);
    }

    public void UpdateTeacher(Tutor t){
        teacherDao.update(t);
    }

    public List<Tutor> FindAll(){
        return teacherDao.findAll();
    }

    public Tutor FindById(Integer id){
        return teacherDao.findById(id);
    }
}
