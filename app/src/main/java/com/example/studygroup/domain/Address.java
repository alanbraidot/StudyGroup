package com.example.studygroup.domain;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.studygroup.persistence.repositories.AddressRepository;

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

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id_address")
    private Integer id;
    @ColumnInfo(name = "city")
    private CityEnum cityEnum;
    @ColumnInfo(name = "province")
    private ProvinceEnum provinceEnum;
    @ColumnInfo(name = "country")
    private CountryEnum countryEnum;

    public Address(){}

    public Address(CityEnum cityEnum, ProvinceEnum provinceEnum, CountryEnum countryEnum) {
        this.cityEnum = cityEnum;
        this.provinceEnum = provinceEnum;
        this.countryEnum = countryEnum;
    }

    public Integer getId() {
        return id;
    }

    public CityEnum getCityEnum() {
        return cityEnum;
    }

    public ProvinceEnum getProvinceEnum() {
        return provinceEnum;
    }

    public CountryEnum getCountryEnum() {
        return countryEnum;
    }

    public static Address getAddress(Context context, Integer id){
        return AddressRepository.getInstance(context).findById(id);
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

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setCityEnum(CityEnum cityEnum) {
        this.cityEnum = cityEnum;
    }

    public void setProvinceEnum(ProvinceEnum provinceEnum) {
        this.provinceEnum = provinceEnum;
    }

    public void setCountryEnum(CountryEnum countryEnum) {
        this.countryEnum = countryEnum;
    }
}
