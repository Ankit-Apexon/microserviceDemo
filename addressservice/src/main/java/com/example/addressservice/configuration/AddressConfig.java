package com.example.addressservice.configuration;


import com.example.addressservice.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}

