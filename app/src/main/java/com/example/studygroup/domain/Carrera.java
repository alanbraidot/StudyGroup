package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "careers")
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
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_career")
    private Integer id;
    @Ignore
    private List<Materia> materias;
    //TODO Convertir para almacenar
    @Ignore
    private CarreraEnum carreraEnum;
    @Ignore
    private Facultad facultad;

    @ColumnInfo(name = "id_faculty")
    private Integer id_faculty;

    public Carrera(){}

    public Carrera(CarreraEnum carreraEnum, Facultad facultad) {
        this.materias = new ArrayList<>();
        this.carreraEnum = carreraEnum;
        this.facultad = facultad;
        this.id_faculty = facultad.getId();
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

    public Integer getId_faculty() {
        return id_faculty;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setId_faculty(Integer id_faculty) {
        this.id_faculty = id_faculty;
    }
}
