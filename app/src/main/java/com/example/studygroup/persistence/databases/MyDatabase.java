package com.example.studygroup.persistence.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.studygroup.domain.Carrera;
import com.example.studygroup.domain.Domicilio;
import com.example.studygroup.domain.Estudiante;
import com.example.studygroup.domain.Facultad;
import com.example.studygroup.domain.Grupo;
import com.example.studygroup.domain.Materia;
import com.example.studygroup.domain.Persona;
import com.example.studygroup.domain.Universidad;
import com.example.studygroup.persistence.daos.AddressDao;
import com.example.studygroup.persistence.daos.CareerDao;
import com.example.studygroup.persistence.daos.FacultyDao;
import com.example.studygroup.persistence.daos.GroupDao;
import com.example.studygroup.persistence.daos.StudentDao;
import com.example.studygroup.persistence.daos.SubjectDao;
import com.example.studygroup.persistence.daos.TeacherDao;
import com.example.studygroup.domain.Tutor;
import com.example.studygroup.persistence.daos.UniversityDao;

@Database(entities = {Carrera.class, Domicilio.class, Estudiante.class, Facultad.class, Grupo.class, Materia.class, Persona.class, Tutor.class, Universidad.class},
        version = 3, exportSchema = false)

public abstract class MyDatabase extends RoomDatabase {

    public abstract TeacherDao teacherDao();
    public abstract AddressDao addressDao();
    public abstract CareerDao careerDao();
    public abstract FacultyDao facultyDao();
    public abstract GroupDao groupDao();
    public abstract StudentDao studentDao();
    public abstract SubjectDao subjectDao();
    public abstract UniversityDao universityDao();

}