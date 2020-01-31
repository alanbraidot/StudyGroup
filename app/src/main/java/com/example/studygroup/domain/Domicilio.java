package com.example.studygroup.domain;

public class Domicilio {

    private Integer id;
    private String ciudad;
    private String provincia;
    private String pais;

    public Domicilio(String ciudad, String provincia, String pais) {
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    }
}
