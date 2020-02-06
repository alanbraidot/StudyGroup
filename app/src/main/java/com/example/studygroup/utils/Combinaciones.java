package com.example.studygroup.utils;

import com.example.studygroup.domain.Carrera;
import com.example.studygroup.domain.Facultad;
import com.example.studygroup.domain.Materia;
import com.example.studygroup.domain.Universidad;

import java.util.HashMap;
import java.util.Map;

public class Combinaciones {

    private static Combinaciones _INSTANCE;

    private Map<Universidad.UniversidadEnum, Facultad.FacultadEnum> facultades = new HashMap<>();
    private Map<Facultad.FacultadEnum, Carrera.CarreraEnum> carreras = new HashMap<>();
    private Map<Carrera.CarreraEnum, Materia.MateriaEnum> materias = new HashMap<>();

    private Combinaciones(){
        _INSTANCE = new Combinaciones();
        loadFacultades();
        loadCarreras();
        loadMaterias();
    }

    public void loadFacultades(){
        facultades.put(Universidad.UniversidadEnum.UTN, Facultad.FacultadEnum.FRSF);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FADU);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FBCB);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FCE);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FCJS);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FCM);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FHUC);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FICH);
        facultades.put(Universidad.UniversidadEnum.UNL, Facultad.FacultadEnum.FIQ);
    }

    public void loadCarreras(){
        carreras.put(Facultad.FacultadEnum.FRSF, Carrera.CarreraEnum.ISIUTN);
        carreras.put(Facultad.FacultadEnum.FRSF, Carrera.CarreraEnum.IIUTN);
        carreras.put(Facultad.FacultadEnum.FRSF, Carrera.CarreraEnum.ICUTN);
        carreras.put(Facultad.FacultadEnum.FRSF, Carrera.CarreraEnum.IEUTN);
        carreras.put(Facultad.FacultadEnum.FRSF, Carrera.CarreraEnum.IMUTN);
        carreras.put(Facultad.FacultadEnum.FADU, Carrera.CarreraEnum.ARQ);
        carreras.put(Facultad.FacultadEnum.FADU, Carrera.CarreraEnum.LDI);
        carreras.put(Facultad.FacultadEnum.FADU, Carrera.CarreraEnum.LDCV);
        carreras.put(Facultad.FacultadEnum.FBCB, Carrera.CarreraEnum.BQ);
        carreras.put(Facultad.FacultadEnum.FBCB, Carrera.CarreraEnum.LN);
        carreras.put(Facultad.FacultadEnum.FCE, Carrera.CarreraEnum.CPN);
        carreras.put(Facultad.FacultadEnum.FCE, Carrera.CarreraEnum.LA);
        carreras.put(Facultad.FacultadEnum.FCE, Carrera.CarreraEnum.LE);
        carreras.put(Facultad.FacultadEnum.FCJS, Carrera.CarreraEnum.AB);
        carreras.put(Facultad.FacultadEnum.FCM, Carrera.CarreraEnum.MED);
        carreras.put(Facultad.FacultadEnum.FHUC, Carrera.CarreraEnum.BIO);
        carreras.put(Facultad.FacultadEnum.FHUC, Carrera.CarreraEnum.FIL);
        carreras.put(Facultad.FacultadEnum.FHUC, Carrera.CarreraEnum.GEO);
        carreras.put(Facultad.FacultadEnum.FHUC, Carrera.CarreraEnum.HIS);
        carreras.put(Facultad.FacultadEnum.FHUC, Carrera.CarreraEnum.MAT);
        carreras.put(Facultad.FacultadEnum.FICH, Carrera.CarreraEnum.IQUNL);
        carreras.put(Facultad.FacultadEnum.FICH, Carrera.CarreraEnum.IAUNL);
        carreras.put(Facultad.FacultadEnum.FICH, Carrera.CarreraEnum.IALUNL);
        carreras.put(Facultad.FacultadEnum.FICH, Carrera.CarreraEnum.IINFUNL);
        carreras.put(Facultad.FacultadEnum.FICH, Carrera.CarreraEnum.IIUNL);
        carreras.put(Facultad.FacultadEnum.FICH, Carrera.CarreraEnum.IMUNL);
    }

    public void loadMaterias(){

    }

}
