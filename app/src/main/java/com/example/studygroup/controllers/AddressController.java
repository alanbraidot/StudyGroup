package com.example.studygroup.controllers;

import com.example.studygroup.domain.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressController {
    private static AddressController _INSTANCE = new AddressController();
    private List<Address> addressList = new ArrayList<>();

    public AddressController() {
        _INSTANCE = new AddressController();
        addressList = new ArrayList<>();
    }

    public static AddressController getInstance() {
        return _INSTANCE;
    }

    public List<Address> getGroupList() {
        return addressList;
    }

}
