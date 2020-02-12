package com.example.studygroup.persistence.repositories;

import android.content.Context;

import com.example.studygroup.domain.Address;
import com.example.studygroup.persistence.DBClient;
import com.example.studygroup.persistence.daos.AddressDao;

import java.util.List;

public class AddressRepository {
    private static AddressRepository _INSTANCE;
    private AddressDao addressDao;

    private AddressRepository(Context context){
        addressDao = DBClient.getInstance(context).getMyDatabase().addressDao();
    }

    public static AddressRepository getInstance(Context context){
        if(_INSTANCE==null)
            _INSTANCE = new AddressRepository(context);
        return _INSTANCE;
    }

    public void create(Address a){
        addressDao.create(a);
    }

    public void update(Address a){
        addressDao.update(a);
    }

    public List<Address> findAll(){
        return addressDao.findAll();
    }

    public Address findById(Integer id){
        return addressDao.findById(id);
    }
}
