package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Carrera;

import java.util.List;

@Dao
public interface CareerDao {
    @Insert
    void create(Carrera c);
    @Update
    void update(Carrera c);
    @Delete
    void delete(Carrera c);
    @Query("SELECT * FROM careers WHERE id_career=:id")
    Carrera findById(Integer id);
    @Query("SELECT * FROM careers")
    List<Carrera> findAll();
}
