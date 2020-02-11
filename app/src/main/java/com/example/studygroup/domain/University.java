package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "universities")
public class University {

    public enum UniversidadEnum {
        UTN ("University Tecnológica Nacional"),
        UNL ("University Nacional del Litoral");

        private final String name;

        private UniversidadEnum(String s) {
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
    @ColumnInfo(name = "id_university")
    private Integer id;
    //TODO Convertir para almacenar
    @Ignore
    private List<Faculty> facultades;
    //TODO Convertir para almacenar
    @Ignore
    private UniversidadEnum universidadEnum;

    public University(List<Faculty> facultades, UniversidadEnum universidadEnum) {
        this.facultades = facultades;
        this.universidadEnum = universidadEnum;
    }

    public University(){}

    public Integer getId() {
        return id;
    }

    public List<Faculty> getFacultades() {
        return facultades;
    }

    public UniversidadEnum getUniversidadEnum() {
        return universidadEnum;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }
}
