package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Group;

import java.util.List;

@Dao
public interface GroupDao {
    @Insert
    void create(Group g);
    @Update
    void update(Group g);
    @Delete
    void delete(Group g);
    @Query("SELECT * FROM groups WHERE id_group=:id")
    Group findById(Integer id);
    @Query("SELECT * FROM groups")
    List<Group> findAll();
}
