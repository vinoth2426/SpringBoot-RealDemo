package com.tek.service.doctor;

import com.tek.dao.doctor.DoctorRepository;
import com.tek.mailservice.EmailService;
import com.tek.model.doctor.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;
    @Autowired
    private EmailService service;

    @PostConstruct
    public void initDoctor(){
        repository.saveAll(Stream.of
                (new Doctor(101,"John","Cardiac"),
                        new Doctor(102,"peter","eye"))
                .collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
        service.sendEMail();
        return repository.findAll();
    }
}
