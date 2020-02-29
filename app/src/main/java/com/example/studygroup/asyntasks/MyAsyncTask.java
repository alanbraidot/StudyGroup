package com.example.studygroup.asyntasks;

import android.os.AsyncTask;

import com.example.studygroup.controllers.PersonController;
import com.example.studygroup.domain.Person;

import java.net.URL;

public class MyAsyncTask extends AsyncTask<URL, Integer, Long> {

    @Override
    protected Long doInBackground(URL... urls) {
        //TODO Completar
        /*if(urls[0].getClass().equals(Person.class))
            PersonController.save(urls[0],urls[1]);*/
        return Long.valueOf(0);
    }
}
