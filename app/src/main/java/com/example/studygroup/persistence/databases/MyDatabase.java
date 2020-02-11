package com.example.studygroup.persistence.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Address;
import com.example.studygroup.domain.Group;
import com.example.studygroup.domain.Student;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Teacher;
import com.example.studygroup.domain.University;
import com.example.studygroup.persistence.daos.AddressDao;
import com.example.studygroup.persistence.daos.CareerDao;
import com.example.studygroup.persistence.daos.FacultyDao;
import com.example.studygroup.persistence.daos.GroupDao;
import com.example.studygroup.persistence.daos.StudentDao;
import com.example.studygroup.persistence.daos.SubjectDao;
import com.example.studygroup.persistence.daos.TeacherDao;
import com.example.studygroup.persistence.daos.UniversityDao;

@Database(entities = {Career.class, Address.class, Student.class, Faculty.class, Group.class, Subject.class, Person.class, Teacher.class, University.class},
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