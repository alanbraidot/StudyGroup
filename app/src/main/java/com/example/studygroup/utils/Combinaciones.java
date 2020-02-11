package com.example.studygroup.utils;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;

import java.util.HashMap;
import java.util.Map;

public class Combinaciones {

    private static Combinaciones _INSTANCE;

    private Map<University.UniversidadEnum, Faculty.FacultadEnum> facultades = new HashMap<>();
    private Map<Faculty.FacultadEnum, Career.CarreraEnum> carreras = new HashMap<>();
    private Map<Career.CarreraEnum, Subject.MateriaEnum> materias = new HashMap<>();

    private Combinaciones(){
        _INSTANCE = new Combinaciones();
        loadFacultades();
        loadCarreras();
        loadMaterias();
    }

    public void loadFacultades(){
        facultades.put(University.UniversidadEnum.UTN, Faculty.FacultadEnum.FRSF);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FADU);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FBCB);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FCE);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FCJS);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FCM);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FHUC);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FICH);
        facultades.put(University.UniversidadEnum.UNL, Faculty.FacultadEnum.FIQ);
    }

    public void loadCarreras(){
        carreras.put(Faculty.FacultadEnum.FRSF, Career.CarreraEnum.ISIUTN);
        carreras.put(Faculty.FacultadEnum.FRSF, Career.CarreraEnum.IIUTN);
        carreras.put(Faculty.FacultadEnum.FRSF, Career.CarreraEnum.ICUTN);
        carreras.put(Faculty.FacultadEnum.FRSF, Career.CarreraEnum.IEUTN);
        carreras.put(Faculty.FacultadEnum.FRSF, Career.CarreraEnum.IMUTN);
        carreras.put(Faculty.FacultadEnum.FADU, Career.CarreraEnum.ARQ);
        carreras.put(Faculty.FacultadEnum.FADU, Career.CarreraEnum.LDI);
        carreras.put(Faculty.FacultadEnum.FADU, Career.CarreraEnum.LDCV);
        carreras.put(Faculty.FacultadEnum.FBCB, Career.CarreraEnum.BQ);
        carreras.put(Faculty.FacultadEnum.FBCB, Career.CarreraEnum.LN);
        carreras.put(Faculty.FacultadEnum.FCE, Career.CarreraEnum.CPN);
        carreras.put(Faculty.FacultadEnum.FCE, Career.CarreraEnum.LA);
        carreras.put(Faculty.FacultadEnum.FCE, Career.CarreraEnum.LE);
        carreras.put(Faculty.FacultadEnum.FCJS, Career.CarreraEnum.AB);
        carreras.put(Faculty.FacultadEnum.FCM, Career.CarreraEnum.MED);
        carreras.put(Faculty.FacultadEnum.FHUC, Career.CarreraEnum.BIO);
        carreras.put(Faculty.FacultadEnum.FHUC, Career.CarreraEnum.FIL);
        carreras.put(Faculty.FacultadEnum.FHUC, Career.CarreraEnum.GEO);
        carreras.put(Faculty.FacultadEnum.FHUC, Career.CarreraEnum.HIS);
        carreras.put(Faculty.FacultadEnum.FHUC, Career.CarreraEnum.MAT);
        carreras.put(Faculty.FacultadEnum.FICH, Career.CarreraEnum.IQUNL);
        carreras.put(Faculty.FacultadEnum.FICH, Career.CarreraEnum.IAUNL);
        carreras.put(Faculty.FacultadEnum.FICH, Career.CarreraEnum.IALUNL);
        carreras.put(Faculty.FacultadEnum.FICH, Career.CarreraEnum.IINFUNL);
        carreras.put(Faculty.FacultadEnum.FICH, Career.CarreraEnum.IIUNL);
        carreras.put(Faculty.FacultadEnum.FICH, Career.CarreraEnum.IMUNL);
    }

    public void loadMaterias(){

    }

}
