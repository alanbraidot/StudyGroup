package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Career;

import java.util.List;

@Dao
public interface CareerDao {
    @Insert
    void create(Career c);
    @Update
    void update(Career c);
    @Delete
    void delete(Career c);
    @Query("SELECT * FROM Career WHERE id_career=:id")
    Career findById(Integer id);
    @Query("SELECT * FROM Career")
    List<Career> findAll();
}
