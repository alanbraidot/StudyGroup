package com.example.studygroup.domain;

public class Domicilio {

    public enum CiudadEnum {
        CSF("Ciudad de Santa Fe");

        private final String name;

        private CiudadEnum(String s) {
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

    public enum ProvinciaEnum {
        SF("Santa Fe");

        private final String name;

        private ProvinciaEnum(String s) {
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

    public enum PaisEnum {
        ARG("Argentina");

        private final String name;

        private PaisEnum(String s) {
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
    private CiudadEnum ciudadEnum;
    private ProvinciaEnum provinciaEnum;
    private PaisEnum paisEnum;

    public Domicilio(CiudadEnum ciudadEnum, ProvinciaEnum provinciaEnum, PaisEnum paisEnum) {
        this.ciudadEnum = ciudadEnum;
        this.provinciaEnum = provinciaEnum;
        this.paisEnum = paisEnum;
    }

    public Integer getId() {
        return id;
    }

    public CiudadEnum getCiudadEnum() {
        return ciudadEnum;
    }

    public ProvinciaEnum getProvinciaEnum() {
        return provinciaEnum;
    }

    public PaisEnum getPaisEnum() {
        return paisEnum;
    }
}
