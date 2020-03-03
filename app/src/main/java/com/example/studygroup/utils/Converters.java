package com.example.studygroup.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.Ignore;
import androidx.room.TypeConverter;

import com.example.studygroup.controllers.PersonController;
import com.example.studygroup.domain.Address;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Group;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converters {

    private static Gson gson = new Gson();

    @TypeConverter
    public static LatLng stringToLatLng(String location){
        Type type = new TypeToken<LatLng>(){}.getType();
        return new Gson().fromJson(location, type);
    }

    @TypeConverter
    public static String latLngToString(LatLng latLng){
        return gson.toJson(latLng);
    }

    @TypeConverter
    public static List<Person> stringToPersonList(String list){
        Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
        return new Gson().fromJson(list, listType);
    }

    @TypeConverter
    public static Group stringToGroup(String group){
        Type listType = new TypeToken<Group>() {}.getType();
        return new Gson().fromJson(group, listType);
    }

    @TypeConverter
    public static String personListToString(List<Person> list){
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<Group> stringToGroupList(String list){
        Type listType = new TypeToken<ArrayList<Group>>() {}.getType();
        return new Gson().fromJson(list, listType);
    }

    @TypeConverter
    public static String groupListToString(List<Group> list){
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<Subject.SubjectEnum> stringToSubjectEnumList(String list){
        Type listType = new TypeToken<ArrayList<Subject.SubjectEnum>>() {}.getType();
        return new Gson().fromJson(list, listType);
    }

    @TypeConverter
    public static String subejctEnumListToString(List<Subject.SubjectEnum> list){
        return gson.toJson(list);
    }

    @TypeConverter
    public static String subjectToString(Subject.SubjectEnum subjectEnum){
        if(subjectEnum==null)
            return null;
        else
            return subjectEnum.toString();
    }

    @TypeConverter
    public static Subject.SubjectEnum stringToSubjectEnum(String subject){
        if(subject==null)
            return null;
        else
            return Subject.getEnumKey(subject);
    }

    @TypeConverter
    public static String careerEnumToString(Career.CareerEnum careerEnum){
        if(careerEnum==null)
            return null;
        else
            return careerEnum.toString();
    }

    @TypeConverter
    public static Career.CareerEnum stringToCareerEnum(String career){
        if(career==null)
            return null;
        else
            return Career.getEnumKey(career);
    }

    @TypeConverter
    public static String facultyEnumToString(Faculty.FacultyEnum facultyEnum){
        if(facultyEnum==null)
            return null;
        else
            return facultyEnum.toString();
    }

    @TypeConverter
    public static Faculty.FacultyEnum stringToFacultyEnum(String faculty){
        if(faculty==null)
            return null;
        else
            return Faculty.getEnumKey(faculty);
    }

    @TypeConverter
    public static String universityEnumToString(University.UniversityEnum universityEnum){
        if(universityEnum==null)
            return null;
        else
            return universityEnum.toString();
    }

    @TypeConverter
    public static University.UniversityEnum stringToUniversityEnum(String university){
        if(university==null)
            return null;
        else
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
    public static String personToString(Person person){
        return gson.toJson(person);
    }

    @TypeConverter
    public static Person stringToPerson(String person){
        Type type = new TypeToken<Person>(){}.getType();
        return new Gson().fromJson(person, type);
    }
}
