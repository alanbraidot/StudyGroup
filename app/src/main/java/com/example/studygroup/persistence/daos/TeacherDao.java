package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Teacher;

import java.util.List;

@Dao
public interface TeacherDao {
    @Insert void create(Teacher t);
    @Update void update(Teacher t);
    @Delete void delete(Teacher t);

    @Query("SELECT * FROM Person WHERE id_person=:id")
    Teacher findById(Integer id);

    @Query("SELECT * FROM Person")
    List<Teacher> findAll();
}
