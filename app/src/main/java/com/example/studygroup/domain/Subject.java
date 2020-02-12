package com.example.studygroup.domain;

public class Subject {

    public enum SubjectEnum {
        AMI("Análisis Matemático I"),
        AGA("Álgebra y Geometría Analítica"),
        AMII("Análisis Matemático II"),
        FISI("Física I"),
        FISII("Física II");

        private final String name;

        private SubjectEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }
}
