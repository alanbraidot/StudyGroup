package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Tutor;

import java.util.List;

@Dao
public interface TeacherDao {
    @Insert void create(Tutor t);
    @Update void update(Tutor t);
    @Delete void delete(Tutor t);

    @Query("SELECT * FROM teachers WHERE id_teacher=:id")
    Tutor findById(Integer id);

    @Query("SELECT * FROM teachers")
    List<Tutor> findAll();
}
