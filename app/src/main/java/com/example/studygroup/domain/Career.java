package com.example.studygroup.domain;

import java.util.List;

public class Career {

    public enum CareerEnum {
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

    public static List<Subject> getSubjects(Career career) {
        //TODO Buscar materias para una carrera;
        return null;
    }

}
