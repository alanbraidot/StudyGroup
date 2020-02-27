package com.example.studygroup.controllers;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.University;

import java.util.ArrayList;
import java.util.List;

public class GeneralController {
    private static GeneralController _INSTANCE = new GeneralController();
    private List<University> universityList;
    private List<Faculty> facultyList;
    private List<Career> careerList;

    public GeneralController() {
        this.universityList = new ArrayList<>();
        this.facultyList = new ArrayList<>();
        this.careerList = new ArrayList<>();
    }

    public static GeneralController getInstance() {
        return _INSTANCE;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public List<Career> getCareerList() {
        return careerList;
    }

    public University getUniversity(University.UniversityEnum universityEnum) {
        for(University u : universityList){
            if(u.getUniversityEnum().equals(universityEnum)) return u;
        }
        return null;
    }

    public Faculty getFaculty(Faculty.FacultyEnum facultyEnum) {
        for(Faculty f : facultyList){
            if(f.getFacultyEnum().equals(facultyEnum)) return f;
        }
        return null;
    }

    public Career getCareer(Career.CareerEnum careerEnum) {
        for(Career c : careerList){
            if(c.getCareerEnum().equals(careerEnum)) return c;
        }
        return null;
    }
}
