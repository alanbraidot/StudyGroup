package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Facultad;

import java.util.List;

@Dao
public interface FacultyDao {
    @Insert
    void create(Facultad f);
    @Update
    void update(Facultad f);
    @Delete
    void delete(Facultad f);
    @Query("SELECT * FROM faculties WHERE id_faculty=:id")
    Facultad findById(Integer id);
    @Query("SELECT * FROM faculties")
    List<Facultad> findAll();
}
