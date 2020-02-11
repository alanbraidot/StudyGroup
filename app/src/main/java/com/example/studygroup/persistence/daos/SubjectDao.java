package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Subject;

import java.util.List;

@Dao
public interface SubjectDao {
    @Insert
    void create(Subject m);
    @Update
    void update(Subject m);
    @Delete
    void delete(Subject m);
    @Query("SELECT * FROM Subject WHERE id_subject=:id")
    Subject findById(Integer id);
    @Query("SELECT * FROM Subject")
    List<Subject> findAll();
}
