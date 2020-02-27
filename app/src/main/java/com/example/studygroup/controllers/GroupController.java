package com.example.studygroup.controllers;

import android.content.Context;
import android.view.View;

import com.example.studygroup.domain.Group;
import com.example.studygroup.persistence.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class GroupController {
    private static GroupController _INSTANCE = new GroupController();
    private List<Group> groupList = new ArrayList<>();

    public GroupController() {
        groupList = new ArrayList<>();
    }

    public static GroupController getInstance() {
        return _INSTANCE;
    }

    public static void save(Group group, Context context) {
        GroupRepository.getInstance(context).create(group);
    }

    public List<Group> getGroupList() {
        return groupList;
    }
}
