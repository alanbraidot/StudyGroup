package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "universities")
public class Universidad {

    public enum UniversidadEnum {
        UTN ("Universidad Tecnológica Nacional"),
        UNL ("Universidad Nacional del Litoral");

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

    private List<Facultad> facultades;
    @ColumnInfo(name = "university_enum")
    private UniversidadEnum universidadEnum;

    public Universidad(List<Facultad> facultades, UniversidadEnum universidadEnum) {
        this.facultades = facultades;
        this.universidadEnum = universidadEnum;
    }

    public Integer getId() {
        return id;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public UniversidadEnum getUniversidadEnum() {
        return universidadEnum;
    }
}
