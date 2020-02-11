package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "subjects")
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
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_subject")
    private Integer id;
    @ColumnInfo(name = "subject_enum")
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
