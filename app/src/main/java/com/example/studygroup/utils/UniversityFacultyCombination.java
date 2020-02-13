package com.example.studygroup.utils;

import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.University;

public class UniversityFacultyCombination {
    private University.UniversityEnum universityEnum;
    private Faculty.FacultyEnum facultyEnum;

    public UniversityFacultyCombination(){}

    public UniversityFacultyCombination(University.UniversityEnum universityEnum, Faculty.FacultyEnum facultyEnum){
        this.universityEnum=universityEnum;
        this.facultyEnum=facultyEnum;
    }

    public University.UniversityEnum getUniversityEnum() {
        return universityEnum;
    }

    public void setUniversityEnum(University.UniversityEnum universityEnum) {
        this.universityEnum = universityEnum;
    }

    public Faculty.FacultyEnum getFacultyEnum() {
        return facultyEnum;
    }

    public void setFacultyEnum(Faculty.FacultyEnum facultyEnum) {
        this.facultyEnum = facultyEnum;
    }
}
