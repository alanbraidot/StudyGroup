package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Estudiante;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void create(Estudiante e);
    @Update
    void update(Estudiante e);
    @Delete
    void delete(Estudiante e);
    @Query("SELECT * FROM students WHERE id_student=:id")
    Estudiante findById(Integer id);
    @Query("SELECT * FROM students")
    List<Estudiante> findAll();
}
