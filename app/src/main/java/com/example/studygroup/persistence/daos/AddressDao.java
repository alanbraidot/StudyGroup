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
    void create(Address a);
    @Update
    void update(Address a);
    @Delete
    void delete(Address a);
    @Query("SELECT * FROM addresses WHERE id_address=:id")
    Address findById(Integer id);
    @Query("SELECT * FROM addresses")
    List<Address> findAll();
}
