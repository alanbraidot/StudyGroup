package com.example.studygroup.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    public enum CarreraEnum {
        ISIUTN("Ingeniería en Sistemas de Información"),
        ICUTN("Ingeniería Civíl"),
        IMUTN("Ingeniería Mecánica"),
        IEUTN("Ingeniería Eléctrica"),
        IIUTN("Ingeniería Industrial"),
        ARQ("Arquitectura y Urbanismo"),
        LDI("Licenciatura en Diseño Industrial"),
        LDCV("Licenciatura en Diseño de la Comunicación Visual"),
        BQ("Bioquímica"),
        LN("Licenciatura en Nutrición"),
        CPN("Contador Público Nacional"),
        LA("Licenciatura en Administración"),
        LE("Licenciatura en Economía"),
        AB("Abogacía"),
        MED("Medicina"),
        BIO("Profesorado en Biología"),
        FIL("Profesorado en Filosofía"),
        GEO("Profesorado en Geografía"),
        HIS("Profesorado en Historia"),
        MAT("Profesorado en Matemática"),
        IAUNL("Ingeniería Ambiental"),
        IALUNL("Ingeniería en Alimentos"),
        IMUNL("Ingeniería en Materiales"),
        IIUNL("Ingeniería Industrial"),
        IQUNL("Ingeniería Química"),
        IINFUNL("Ingeniería en Informática");

        private String name;

        private CarreraEnum(String s) {
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
    private List<Materia> materias;
    private CarreraEnum carreraEnum;
    private Facultad facultad;

    public Carrera(CarreraEnum carreraEnum, Facultad facultad) {
        this.materias = new ArrayList<>();
        this.carreraEnum = carreraEnum;
        this.facultad = facultad;
    }

    public Integer getId() {
        return id;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public CarreraEnum getCarreraEnum() {
        return carreraEnum;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
