package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

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
    @Ignore
    private Bitmap foto;
    //TODO Convertir para almacenar
    @Ignore
    private Address address;
    //TODO Convertir para almacenar
    @Ignore
    private List<Group> groups;

    public Person(String nombre, String apellido, String email, Address address, Bitmap foto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.address = address;
        this.foto = foto;
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

    public Bitmap getFoto() {
        return foto;
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

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
