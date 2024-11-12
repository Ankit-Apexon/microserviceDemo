package com.example.employeeservice.service;


import com.example.employeeservice.feignclient.AddressClient;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepo;
import com.example.employeeservice.response.AddressResponse;
import com.example.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    // Spring will create the implementation
    // for this class
    // and will inject the bean here (proxy)
    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {

        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }

}
