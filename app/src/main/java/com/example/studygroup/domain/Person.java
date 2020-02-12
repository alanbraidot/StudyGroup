package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.studygroup.utils.Converters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "people")
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
    //TODO Convertir para almacenar
    @Ignore
    private Bitmap photo;
    @ColumnInfo(name = "id_address")
    //TODO Convertir para almacenar
    @Ignore
    private Address address;
    //TODO Convertir para almacenar
    @Ignore
    private List<Group> groups;
    @ColumnInfo(name = "id_career")
    //TODO Convertir para almacenar
    @Ignore
    private Career.CareerEnum careerEnum;
    //TODO Convertir para almacenar
    @Ignore
    private List<Subject> materiasHabilitadas;

    public Person(String nombre, String apellido, String email, Boolean isTeacher, Bitmap photo, Address address, Career.CareerEnum careerEnum, List<Subject> materiasHabilitadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.isTeacher = isTeacher;
        this.photo = photo;
        this.address = address;
        if(isTeacher){
            this.materiasHabilitadas = materiasHabilitadas;
            this.careerEnum=null;
        }
        else {
            this.materiasHabilitadas =null;
            this.careerEnum = careerEnum;
        }
        this.groups = new ArrayList<>();
    }

    public Person(){}

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

    public Address getAddress() {
        return address;
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

    public void setAddress(Address address) {
        this.address = address;
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

    public List<Subject> getMateriasHabilitadas() {
        return materiasHabilitadas;
    }
}
