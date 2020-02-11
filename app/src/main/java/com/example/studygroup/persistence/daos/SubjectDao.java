package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Materia;

import java.util.List;

@Dao
public interface SubjectDao {
    @Insert
    void create(Materia m);
    @Update
    void update(Materia m);
    @Delete
    void delete(Materia m);
    @Query("SELECT * FROM subjects WHERE id_subject=:id")
    Materia findById(Integer id);
    @Query("SELECT * FROM subjects")
    List<Materia> findAll();
}
