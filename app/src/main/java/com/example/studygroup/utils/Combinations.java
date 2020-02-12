package com.example.studygroup.utils;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;

import java.util.HashMap;
import java.util.Map;

public class Combinations {

    private static Combinations _INSTANCE;

    private Map<University.UniversityEnum, Faculty.FacultyEnum> facultades = new HashMap<>();
    private Map<Faculty.FacultyEnum, Career.CareerEnum> carreras = new HashMap<>();
    private Map<Career.CareerEnum, Subject.SubjectEnum> materias = new HashMap<>();

    private Combinations(){
        _INSTANCE = new Combinations();
        loadFacultades();
        loadCarreras();
        loadMaterias();
    }

    public void loadFacultades(){
        facultades.put(University.UniversityEnum.UTN, Faculty.FacultyEnum.FRSF);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FADU);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FBCB);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FCE);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FCJS);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FCM);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FHUC);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FICH);
        facultades.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FIQ);
    }

    public void loadCarreras(){
        carreras.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.ISIUTN);
        carreras.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.IIUTN);
        carreras.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.ICUTN);
        carreras.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.IEUTN);
        carreras.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.IMUTN);
        carreras.put(Faculty.FacultyEnum.FADU, Career.CareerEnum.ARQ);
        carreras.put(Faculty.FacultyEnum.FADU, Career.CareerEnum.LDI);
        carreras.put(Faculty.FacultyEnum.FADU, Career.CareerEnum.LDCV);
        carreras.put(Faculty.FacultyEnum.FBCB, Career.CareerEnum.BQ);
        carreras.put(Faculty.FacultyEnum.FBCB, Career.CareerEnum.LN);
        carreras.put(Faculty.FacultyEnum.FCE, Career.CareerEnum.CPN);
        carreras.put(Faculty.FacultyEnum.FCE, Career.CareerEnum.LA);
        carreras.put(Faculty.FacultyEnum.FCE, Career.CareerEnum.LE);
        carreras.put(Faculty.FacultyEnum.FCJS, Career.CareerEnum.AB);
        carreras.put(Faculty.FacultyEnum.FCM, Career.CareerEnum.MED);
        carreras.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.BIO);
        carreras.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.FIL);
        carreras.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.GEO);
        carreras.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.HIS);
        carreras.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.MAT);
        carreras.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IQUNL);
        carreras.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IAUNL);
        carreras.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IALUNL);
        carreras.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IINFUNL);
        carreras.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IIUNL);
        carreras.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IMUNL);
    }

    public void loadMaterias(){

    }

}
