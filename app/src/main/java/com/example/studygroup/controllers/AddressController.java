package com.example.studygroup.controllers;

import com.example.studygroup.domain.Address;
import com.example.studygroup.persistence.repositories.AddressRepository;

import java.util.ArrayList;
import java.util.List;

public class AddressController {
    private static AddressController _INSTANCE = new AddressController();
    private List<Address> addressList = new ArrayList<>();

    public AddressController() {
        addressList = new ArrayList<>();
    }

    public static AddressController getInstance() {
        return _INSTANCE;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public Address findById(Integer id){
        return AddressRepository.getInstance(null).findById(id);
    }

}
