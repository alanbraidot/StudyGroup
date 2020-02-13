package com.example.studygroup.utils;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combinations {

    private static Combinations _INSTANCE;

    private Map<University.UniversityEnum, Faculty.FacultyEnum> faculties = new HashMap<>();
    private Map<Faculty.FacultyEnum, Career.CareerEnum> careers = new HashMap<>();
    private Map<Career.CareerEnum, Subject.SubjectEnum> subjects = new HashMap<>();

    private Combinations(){
        _INSTANCE = new Combinations();
        loadFaculties();
        loadCareers();
        loadSubjects();
    }

    public void loadFaculties(){
        faculties.put(University.UniversityEnum.UTN, Faculty.FacultyEnum.FRSF);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FADU);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FBCB);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FCE);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FCJS);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FCM);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FHUC);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FICH);
        faculties.put(University.UniversityEnum.UNL, Faculty.FacultyEnum.FIQ);
    }

    public void loadCareers(){
        careers.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.ISIUTN);
        careers.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.IIUTN);
        careers.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.ICUTN);
        careers.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.IEUTN);
        careers.put(Faculty.FacultyEnum.FRSF, Career.CareerEnum.IMUTN);
        careers.put(Faculty.FacultyEnum.FADU, Career.CareerEnum.ARQ);
        careers.put(Faculty.FacultyEnum.FADU, Career.CareerEnum.LDI);
        careers.put(Faculty.FacultyEnum.FADU, Career.CareerEnum.LDCV);
        careers.put(Faculty.FacultyEnum.FBCB, Career.CareerEnum.BQ);
        careers.put(Faculty.FacultyEnum.FBCB, Career.CareerEnum.LN);
        careers.put(Faculty.FacultyEnum.FCE, Career.CareerEnum.CPN);
        careers.put(Faculty.FacultyEnum.FCE, Career.CareerEnum.LA);
        careers.put(Faculty.FacultyEnum.FCE, Career.CareerEnum.LE);
        careers.put(Faculty.FacultyEnum.FCJS, Career.CareerEnum.AB);
        careers.put(Faculty.FacultyEnum.FCM, Career.CareerEnum.MED);
        careers.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.BIO);
        careers.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.FIL);
        careers.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.GEO);
        careers.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.HIS);
        careers.put(Faculty.FacultyEnum.FHUC, Career.CareerEnum.MAT);
        careers.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IQUNL);
        careers.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IAUNL);
        careers.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IALUNL);
        careers.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IINFUNL);
        careers.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IIUNL);
        careers.put(Faculty.FacultyEnum.FICH, Career.CareerEnum.IMUNL);
    }

    public void loadSubjects(){

    }

}
