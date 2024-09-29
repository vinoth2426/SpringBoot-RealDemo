package com.tek.dao.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tek.model.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
