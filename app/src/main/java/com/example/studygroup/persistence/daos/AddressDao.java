package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Domicilio;

import java.util.List;

@Dao
public interface AddressDao {
    @Insert
    void create(Domicilio d);
    @Update
    void update(Domicilio d);
    @Delete
    void delete(Domicilio d);
    @Query("SELECT * FROM addresses WHERE id_address=:id")
    Domicilio findById(Integer id);
    @Query("SELECT * FROM addresses")
    List<Domicilio> findAll();
}
