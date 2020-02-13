package com.example.studygroup.utils;

import android.graphics.Bitmap;

import androidx.room.TypeConverter;

import com.example.studygroup.controllers.AddressController;
import com.example.studygroup.domain.Address;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.University;

public class Converters {

    @TypeConverter
    public static Integer addressToInteger(Address address){
        return address.getId();
    }

    @TypeConverter
    public static Address integerToAddress(Integer id){
        return AddressController.getInstance().findById(id);
    }

    @TypeConverter
    public static String careerEnumToString(Career.CareerEnum careerEnum){
        return careerEnum.toString();
    }

    @TypeConverter
    public static Career.CareerEnum stringToCareerEnum(String career){
        return Career.CareerEnum.valueOf(career);
    }

    @TypeConverter
    public static String facultyEnumToString(Faculty.FacultyEnum facultyEnum){
        return facultyEnum.toString();
    }

    @TypeConverter
    public static Faculty.FacultyEnum stringToFacultyEnum(String faculty){
        return Faculty.FacultyEnum.valueOf(faculty);
    }

    @TypeConverter
    public static String universityEnumToString(University.UniversityEnum universityEnum){
        return universityEnum.toString();
    }

    @TypeConverter
    public static University.UniversityEnum stringToUniversityEnum(String university){
        return University.UniversityEnum.valueOf(university);
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



}
