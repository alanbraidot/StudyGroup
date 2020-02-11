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
public class Persona {
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
    private Domicilio domicilio;
    //TODO Convertir para almacenar
    @Ignore
    private List<Grupo> grupos;

    public Persona(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.domicilio = domicilio;
        this.foto = foto;
        this.grupos = new ArrayList<>();
    }

    public Persona (){}

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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public List<Grupo> getGrupos() {return grupos;}

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

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
