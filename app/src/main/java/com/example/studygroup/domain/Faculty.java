package com.example.studygroup.domain;

import java.util.List;

public class Faculty {

    public enum FacultyEnum {
        FRSF("Faculty Regional Santa Fe"),
        FICH("Faculty de Ingeniería y Ciencias Hídricas"),
        FADU("Faculty de Arquitectura, Diseño y Urbanismo"),
        FIQ("Faculty de Ingeniería Química"),
        FCM("Faculty de Ciencias Médicas"),
        FBCB("Faculty de Bioquímica y Ciencias Biológicas"),
        FCE("Faculty de Ciencias Económicas"),
        FCJS("Faculty de Ciencias Jurídicas y Sociales"),
        FHUC("Faculty de Humanidades y Ciencias");

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

    public static List<Career> getCareers(FacultyEnum facultyEnum) {
        //TODO Buscar carreras para una facultad;
        return null;
    }
}
