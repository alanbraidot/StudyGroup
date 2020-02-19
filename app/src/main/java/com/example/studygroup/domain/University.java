package com.example.studygroup.domain;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Faculty.FacultyEnum> facultyEnumList;
    private UniversityEnum universityEnum;

    public enum UniversityEnum {
        UTN ("Universidad Tecnológica Nacional"),
        UNL ("Universidad Nacional del Litoral");

        private final String name;

        private UniversityEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public University(UniversityEnum universityEnum) {
        this.facultyEnumList = new ArrayList<>();
        this.universityEnum = universityEnum;
    }

    public List<Faculty.FacultyEnum> getFacultyEnumList() {
        return facultyEnumList;
    }

    public UniversityEnum getUniversityEnum() {
        return universityEnum;
    }

    public static List<Faculty> getFaculties(UniversityEnum universityEnum) {
        //TODO Buscar facultades para una universidad;
        return null;
    }
}
