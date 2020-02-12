package com.example.studygroup.utils;

import androidx.room.TypeConverter;

import com.example.studygroup.domain.Address;

public class Converters {

    @TypeConverter
    public static Integer addressToInteger(Address address){
        return address.getId();
    }


}
