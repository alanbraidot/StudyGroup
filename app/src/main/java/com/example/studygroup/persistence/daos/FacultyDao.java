package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Faculty;

import java.util.List;

@Dao
public interface FacultyDao {
    @Insert
    void create(Faculty f);
    @Update
    void update(Faculty f);
    @Delete
    void delete(Faculty f);
    @Query("SELECT * FROM Faculty WHERE id_faculty=:id")
    Faculty findById(Integer id);
    @Query("SELECT * FROM Faculty")
    List<Faculty> findAll();
}
