package com.example.studygroup.domain;

import java.util.List;

public class Faculty {

    public enum FacultyEnum {
        FRSF("Facultad Regional Santa Fe"),
        FICH("Facultad de Ingeniería y Ciencias Hídricas"),
        FADU("Facultad de Arquitectura, Diseño y Urbanismo"),
        FIQ("Facultad de Ingeniería Química"),
        FCM("Facultad de Ciencias Médicas"),
        FBCB("Facultad de Bioquímica y Ciencias Biológicas"),
        FCE("Facultad de Ciencias Económicas"),
        FCJS("Facultad de Ciencias Jurídicas y Sociales"),
        FHUC("Facultad de Humanidades y Ciencias");

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
