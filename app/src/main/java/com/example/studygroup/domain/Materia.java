package com.example.studygroup.domain;

public class Materia {

    public enum MateriaEnum {
        AMI("Análisis Matemático I"),
        AGA("Álgebra y Geometría Analítica"),
        AMII("Análisis Matemático II"),
        FISI("Física I"),
        FISII("Física II");

        private final String name;

        private MateriaEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }

        public String getName(){
            return name;
        }
    }

    private Integer id;
    private MateriaEnum materiaEnum;

    public Materia(MateriaEnum materiaEnum) {
        this.materiaEnum = materiaEnum;
    }

    public Integer getId() {
        return id;
    }

    public MateriaEnum getMateriaEnum() {
        return materiaEnum;
    }
}
