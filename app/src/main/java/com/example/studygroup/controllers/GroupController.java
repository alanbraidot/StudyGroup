package com.example.studygroup.controllers;

import com.example.studygroup.domain.Group;

import java.util.ArrayList;
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

    public List<Group> getGroupList() {
        return groupList;
    }
}
