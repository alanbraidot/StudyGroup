package com.example.studygroup.domain;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private FacultyEnum facultyEnum;
    private List<Career.CareerEnum> careerEnumList;

    public enum FacultyEnum {
        FRSF("Facultad Regional Santa Fe"),
        FICH("Facultad de Ingeniería y Ciencias Hídricas");

        private String name;

        FacultyEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public Faculty(FacultyEnum facultyEnum) {
        this.facultyEnum = facultyEnum;
        this.careerEnumList = new ArrayList<>();
    }

    public FacultyEnum getFacultyEnum() {
        return facultyEnum;
    }

    public List<Career.CareerEnum> getCareerEnumList() {
        return careerEnumList;
    }

    public static List<Career> getCareers(FacultyEnum facultyEnum) {
        //TODO Buscar carreras para una facultad;
        return null;
    }
}
