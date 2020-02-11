package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
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
    @ColumnInfo(name="city_enum")
    private CiudadEnum ciudadEnum;
    @ColumnInfo(name="province_enum")
    private ProvinciaEnum provinciaEnum;
    @ColumnInfo(name="country_enum")
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
