package com.example.addressservice.service;


import com.example.addressservice.model.Address;
import com.example.addressservice.repository.AddressRepo;
import com.example.addressservice.response.AddressResponse;
import feign.Param;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(@Param("employeeId")int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findById(employeeId);
        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }

}
