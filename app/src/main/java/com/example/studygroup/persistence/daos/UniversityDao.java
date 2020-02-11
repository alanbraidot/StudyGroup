package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Universidad;

import java.util.List;

@Dao
public interface UniversityDao {
    @Insert void create(Universidad u);
    @Update void update(Universidad u);
    @Delete void delete(Universidad u);
    @Query("SELECT * FROM universities WHERE id_university=:id")
    Universidad findById(Integer id);
    @Query("SELECT * FROM universities")
    List<Universidad> findAll();
}
