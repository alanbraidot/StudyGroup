package com.example.studygroup.domain;

import java.util.ArrayList;
import java.util.List;

public class Career {

    private CareerEnum careerEnum;
    private List<Subject.SubjectEnum> subjectEnumList;

    public enum CareerEnum {
        ISIUTN("Ingeniería en Sistemas de Información"),
        IMUTN("Ingeniería Mecánica"),

        IQUNL("Ingeniería Química"),
        IINFUNL("Ingeniería en Informática");

        private String name;

        private CareerEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public Career(CareerEnum careerEnum) {
        this.careerEnum = careerEnum;
        this.subjectEnumList = new ArrayList<>();
    }

    public CareerEnum getCareerEnum() {
        return careerEnum;
    }

    public List<Subject.SubjectEnum> getSubjectEnumList() {
        return subjectEnumList;
    }

    public static List<Subject> getSubjects(Career career) {
        //TODO Buscar materias para una carrera;
        return null;
    }

}
