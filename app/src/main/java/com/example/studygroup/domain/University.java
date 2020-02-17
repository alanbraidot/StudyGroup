package com.example.studygroup.domain;

import java.util.List;

public abstract class University {

    public enum UniversityEnum {
        UTN ("University Tecnológica Nacional"),
        UNL ("University Nacional del Litoral");

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

    public static List<Faculty> getFaculties(UniversityEnum universityEnum) {
        //TODO Buscar facultades para una universidad;
        return null;
    }
}
