package com.example.studygroup.domain;

public class Subject {

    public enum SubjectEnum {
        AMI("Análisis Matemático I"),
        FISI("Física I");

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

    public static SubjectEnum getEnumKey(String subject){
        for(SubjectEnum s : SubjectEnum.values()){
            if(s.toString().equals(subject))
                return s;
        }
        return null;
    }
}
