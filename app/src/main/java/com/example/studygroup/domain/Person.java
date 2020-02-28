package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "people", indices = {@Index(value = "email", unique = true)})
public class Person {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_person")
    private Integer id;
    @ColumnInfo(name = "name")
    private String nombre;
    @ColumnInfo(name = "surname")
    private String apellido;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "isTeacher")
    private Boolean isTeacher =false;
    @ColumnInfo(name = "career")
    private Career.CareerEnum careerEnum;
    @ColumnInfo(name = "faculty")
    private Faculty.FacultyEnum facultyEnum;
    @ColumnInfo(name = "university")
    private University.UniversityEnum universityEnum;
    @ColumnInfo(name = "photo_location")
    private Bitmap photo;
    @ColumnInfo(name = "country")
    private Address.CountryEnum countryEnum;
    @ColumnInfo(name = "province")
    private Address.ProvinceEnum provinceEnum;
    @ColumnInfo(name = "city")
    private Address.CityEnum cityEnum;
    //TODO Convertir para almacenar
    @Ignore
    private List<Group> groups;
    //TODO Convertir para almacenar
    @Ignore
    private List<Subject.SubjectEnum> materiasHabilitadas;

    public Person(String nombre, String apellido, String email, Boolean isTeacher, Bitmap photo, Address.CountryEnum countryEnum, Address.ProvinceEnum provinceEnum, Address.CityEnum cityEnum, University.UniversityEnum universityEnum, Faculty.FacultyEnum facultyEnum, Career.CareerEnum careerEnum, List<Subject.SubjectEnum> materiasHabilitadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.isTeacher = isTeacher;
        this.photo = photo;
        this.countryEnum = countryEnum;
        this.provinceEnum = provinceEnum;
        this.cityEnum=cityEnum;
        if(isTeacher){
            this.materiasHabilitadas = materiasHabilitadas;
            this.universityEnum=null;
            this.facultyEnum=null;
            this.careerEnum=null;
        }
        else {
            this.materiasHabilitadas =null;
            this.universityEnum=universityEnum;
            this.facultyEnum=facultyEnum;
            this.careerEnum = careerEnum;
        }
        this.groups = new ArrayList<>();
    }

    public Person(){}

    public Address.CountryEnum getCountryEnum() {
        return countryEnum;
    }

    public void setCountryEnum(Address.CountryEnum countryEnum) {
        this.countryEnum = countryEnum;
    }

    public Address.ProvinceEnum getProvinceEnum() {
        return provinceEnum;
    }

    public void setProvinceEnum(Address.ProvinceEnum provinceEnum) {
        this.provinceEnum = provinceEnum;
    }

    public Address.CityEnum getCityEnum() {
        return cityEnum;
    }

    public void setCityEnum(Address.CityEnum cityEnum) {
        this.cityEnum = cityEnum;
    }

    public Integer getId() { return id; }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public List<Group> getGroups() {return groups;}

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Boolean isTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Boolean isTeacher){
        this.isTeacher =isTeacher;
    }

    public Career.CareerEnum getCareerEnum() {
        return careerEnum;
    }

    public List<Subject.SubjectEnum> getMateriasHabilitadas() {
        return materiasHabilitadas;
    }

    public Faculty.FacultyEnum getFacultyEnum() {
        return facultyEnum;
    }

    public University.UniversityEnum getUniversityEnum() {
        return universityEnum;
    }

    public void setCareerEnum(Career.CareerEnum careerEnum) {
        this.careerEnum = careerEnum;
    }

    public void setFacultyEnum(Faculty.FacultyEnum facultyEnum) {
        this.facultyEnum = facultyEnum;
    }

    public void setUniversityEnum(University.UniversityEnum universityEnum) {
        this.universityEnum = universityEnum;
    }
}
