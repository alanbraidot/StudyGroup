package com.example.studygroup.persistence.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.studygroup.domain.Address;
import com.example.studygroup.domain.Group;
import com.example.studygroup.domain.Person;
import com.example.studygroup.persistence.daos.GroupDao;
import com.example.studygroup.persistence.daos.PersonDao;
import com.example.studygroup.utils.Converters;

@Database(entities = {Person.class, Group.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})

public abstract class MyDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
    public abstract GroupDao groupDao();
}