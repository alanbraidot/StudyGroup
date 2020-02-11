package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.University;

import java.util.List;

@Dao
public interface UniversityDao {
    @Insert void create(University u);
    @Update void update(University u);
    @Delete void delete(University u);
    @Query("SELECT * FROM University WHERE id_university=:id")
    University findById(Integer id);
    @Query("SELECT * FROM University")
    List<University> findAll();
}
