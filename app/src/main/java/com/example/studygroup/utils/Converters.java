package com.example.studygroup.utils;

import android.graphics.Bitmap;

import androidx.room.TypeConverter;

import com.example.studygroup.controllers.PersonController;
import com.example.studygroup.domain.Address;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;

public class Converters {

    @TypeConverter
    public static String subjectToString(Subject.SubjectEnum subjectEnum){
        return subjectEnum.toString();
    }

    @TypeConverter
    public static Subject.SubjectEnum stringToSubjectEnum(String subject){
        return Subject.getEnumKey(subject);
    }

    @TypeConverter
    public static String careerEnumToString(Career.CareerEnum careerEnum){
        return careerEnum.toString();
    }

    @TypeConverter
    public static Career.CareerEnum stringToCareerEnum(String career){
        return Career.getEnumKey(career);
    }

    @TypeConverter
    public static String facultyEnumToString(Faculty.FacultyEnum facultyEnum){
        return facultyEnum.toString();
    }

    @TypeConverter
    public static Faculty.FacultyEnum stringToFacultyEnum(String faculty){
        return Faculty.getEnumKey(faculty);
    }

    @TypeConverter
    public static String universityEnumToString(University.UniversityEnum universityEnum){
        return universityEnum.toString();
    }

    @TypeConverter
    public static University.UniversityEnum stringToUniversityEnum(String university){
        return University.getEnumKey(university);
    }

    @TypeConverter
    public static String countryEnumToString(Address.CountryEnum countryEnum){
        return countryEnum.toString();
    }

    @TypeConverter
    public static Address.CountryEnum stringToCountryEnum(String country){
        return Address.getCountryEnumKey(country);
    }

    @TypeConverter
    public static String provinceEnumToString(Address.ProvinceEnum provinceEnum){
        return provinceEnum.toString();
    }

    @TypeConverter
    public static Address.ProvinceEnum stringToProvinceEnum(String province){
        return Address.getProvinceEnumKey(province);
    }

    @TypeConverter
    public static String cityEnumToString(Address.CityEnum cityEnum){
        return cityEnum.toString();
    }

    @TypeConverter
    public static Address.CityEnum stringToCityEnum(String city){
        return Address.getCityEnumKey(city);
    }

    @TypeConverter
    public static String photoToString(Bitmap photo){
        //TODO Convertir foto a un formato almacenable.
        return null;
    }

    @TypeConverter
    public static Bitmap stringToPhoto(String location){
        //TODO Convertir direccion a Bitmap
        return null;
    }

    @TypeConverter
    public static Integer personToString(Person person){
        return person.getId();
    }

    @TypeConverter
    //TODO Corregir este metodo(no se puede pasar null).
    public static Person stringToPerson(Integer id){
        return PersonController.getInstance().findPersonById(id,null);
    }
}
