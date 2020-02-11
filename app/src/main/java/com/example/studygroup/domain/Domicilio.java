package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses")
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
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id_address")
    private Integer id;
    //TODO Convertir para almacenar
    @Ignore
    private CiudadEnum ciudadEnum;
    //TODO Convertir para almacenar
    @Ignore
    private ProvinciaEnum provinciaEnum;
    //TODO Convertir para almacenar
    @Ignore
    private PaisEnum paisEnum;

    public Domicilio(){}

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

    public void setId(@NonNull Integer id) {
        this.id = id;
    }
}
