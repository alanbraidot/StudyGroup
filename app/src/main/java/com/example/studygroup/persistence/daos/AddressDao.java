package com.example.studygroup.persistence.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studygroup.domain.Address;

import java.util.List;

@Dao
public interface AddressDao {
    @Insert
    void create(Address d);
    @Update
    void update(Address d);
    @Delete
    void delete(Address d);
    @Query("SELECT * FROM Address WHERE id_address=:id")
    Address findById(Integer id);
    @Query("SELECT * FROM Address")
    List<Address> findAll();
}
