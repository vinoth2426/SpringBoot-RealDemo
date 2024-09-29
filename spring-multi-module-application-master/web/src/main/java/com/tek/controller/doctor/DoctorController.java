package com.tek.controller.doctor;

import com.tek.model.doctor.Doctor;
import com.tek.service.doctor.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return service.getDoctors();
    }


}
