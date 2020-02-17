package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    void create(Person p);
    @Update
    void update(Person p);
    @Delete
    void delete(Person p);
    @Query("SELECT * FROM people WHERE id_person=:id")
    Person findById(Integer id);
    @Query("SELECT * FROM people WHERE email=:email")
    Person findByEmail(String email);
    @Query("SELECT * FROM people")
    List<Person> findAll();
}
