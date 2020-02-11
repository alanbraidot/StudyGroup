package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void create(Student e);
    @Update
    void update(Student e);
    @Delete
    void delete(Student e);
    @Query("SELECT * FROM Person WHERE id_person=:id")
    Student findById(Integer id);
    @Query("SELECT * FROM Person")
    List<Student> findAll();
}
