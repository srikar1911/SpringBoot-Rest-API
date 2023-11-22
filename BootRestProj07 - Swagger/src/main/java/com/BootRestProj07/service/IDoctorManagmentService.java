package com.BootRestProj07.service;

import com.BootRestProj07.entity.Doctor;
import com.BootRestProj07.exception.DoctorNotFoundException;

import java.util.List;

public interface IDoctorManagmentService {
    public  String registerDoctor(Doctor doctor);
    public List<Doctor> getAllDoctors();
    public Doctor getDoctorBYId(int id) throws DoctorNotFoundException;
    public String updateDoctor(Doctor doctor) throws  DoctorNotFoundException;
    public String deleteByID(int id) throws DoctorNotFoundException;
    public String deleteDoctorsByIncomeRange(Double start, Double end);
    public String hikeDoctorIncomebyPercentage(int docId, double percentage);
}
