package com.example.studygroup.domain;

import android.content.Context;

import androidx.room.Entity;

@Entity(tableName = "addresses")
public class Address {

    public enum CityEnum {
        CSF("Ciudad de Santa Fe");

        private final String name;

        private CityEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public enum ProvinceEnum {
        SF("Santa Fe");

        private final String name;

        private ProvinceEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public enum CountryEnum {
        ARG("Argentina");

        private final String name;

        private CountryEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public static CityEnum getCityEnumKey(String city){
        for(CityEnum c : CityEnum.values()){
            if(c.toString().equals(city))
                return c;
        }
        return null;
    }

    public static ProvinceEnum getProvinceEnumKey(String province){
        for(ProvinceEnum p : ProvinceEnum.values()){
            if(p.toString().equals(province))
                return p;
        }
        return null;
    }

    public static CountryEnum getCountryEnumKey(String country){
        for(CountryEnum c : CountryEnum.values()){
            if(c.toString().equals(country))
                return c;
        }
        return null;
    }
}
