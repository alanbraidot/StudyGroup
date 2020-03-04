package com.example.studygroup.persistence;

import android.content.Context;

import androidx.room.Room;

import com.example.studygroup.persistence.databases.MyDatabase;

public class DBClient {
    private static DBClient _INSTANCE=null;
    private MyDatabase myDatabase;

    public DBClient(Context context){
        myDatabase = Room.databaseBuilder(context, MyDatabase.class, "study_group_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public static DBClient getInstance(Context context){
        if (_INSTANCE==null)
            _INSTANCE=new DBClient(context);
        return _INSTANCE;
    }

    public MyDatabase getMyDatabase(){
        return myDatabase;
    }
}
