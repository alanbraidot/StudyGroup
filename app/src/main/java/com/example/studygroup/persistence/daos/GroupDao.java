package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Grupo;

import java.util.List;

@Dao
public interface GroupDao {
    @Insert
    void create(Grupo g);
    @Update
    void update(Grupo g);
    @Delete
    void delete(Grupo g);
    @Query("SELECT * FROM groups WHERE id_group=:id")
    Grupo findById(Integer id);
    @Query("SELECT * FROM groups")
    List<Grupo> findAll();
}
