package com.example.studygroup.controllers;

import com.example.studygroup.domain.Grupo;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    private static GroupController _INSTANCE = new GroupController();
    private List<Grupo> grupoList = new ArrayList<>();

    public GroupController() {
        _INSTANCE = new GroupController();
        grupoList = new ArrayList<>();
    }

    public static GroupController getInstance() {
        return _INSTANCE;
    }

    public List<Grupo> getGrupoList() {
        return grupoList;
    }
}
