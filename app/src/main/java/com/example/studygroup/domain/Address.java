package com.example.studygroup.domain;

import android.content.Context;
import android.location.Geocoder;
import android.util.Log;

import androidx.room.Entity;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Locale;

@Entity(tableName = "addresses")
public class Address {

    public enum CityEnum {
        CSF("Ciudad de Santa Fe");

        private final String name;

        private CityEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public enum ProvinceEnum {
        SF("Santa Fe");

        private final String name;

        private ProvinceEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public enum CountryEnum {
        ARG("Argentina");

        private final String name;

        private CountryEnum(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return name.equals(otherName);
        }

        @Override public String toString() {
            return this.name;
        }
    }

    public static CityEnum getCityEnumKey(String city){
        for(CityEnum c : CityEnum.values()){
            if(c.toString().equals(city))
                return c;
        }
        return null;
    }

    public static ProvinceEnum getProvinceEnumKey(String province){
        for(ProvinceEnum p : ProvinceEnum.values()){
            if(p.toString().equals(province))
                return p;
        }
        return null;
    }

    public static CountryEnum getCountryEnumKey(String country){
        for(CountryEnum c : CountryEnum.values()){
            if(c.toString().equals(country))
                return c;
        }
        return null;
    }

    public static String getCompleteAddressString(LatLng latLng, Context context){
        String strAdd = "";
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<android.location.Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (addresses != null) {
                android.location.Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.w("My Current loction address", strReturnedAddress.toString());
            } else {
                Log.w("My Current loction address", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("My Current loction address", "Canont get Address!");
        }
        return strAdd;
    }
}
