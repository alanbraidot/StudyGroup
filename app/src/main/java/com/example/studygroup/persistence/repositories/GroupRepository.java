package com.example.studygroup.persistence.repositories;

import android.content.Context;

import com.example.studygroup.domain.Group;
import com.example.studygroup.persistence.DBClient;
import com.example.studygroup.persistence.daos.GroupDao;

import java.util.List;

public class GroupRepository {
    private static GroupRepository _INSTANCE;
    private GroupDao groupDao;

    private GroupRepository(Context context){
        groupDao = DBClient.getInstance(context).getMyDatabase().groupDao();
    }

    public static GroupRepository getInstance(Context context){
        if(_INSTANCE==null)
            _INSTANCE = new GroupRepository(context);
        return _INSTANCE;
    }

    public void create(Group g){
        groupDao.create(g);
    }

    public void update(Group g){
        groupDao.update(g);
    }

    public List<Group> findAll(){
        return groupDao.findAll();
    }

    public Group findById(Integer id){
        return groupDao.findById(id);
    }
}
