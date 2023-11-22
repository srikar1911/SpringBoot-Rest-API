package com.BootRestProj07.service;

import com.BootRestProj07.entity.Doctor;
import com.BootRestProj07.exception.DoctorNotFoundException;
import com.BootRestProj07.repo.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorManagmentServiceImpl implements IDoctorManagmentService {
    @Autowired
    private IDoctorRepo doctorRepo;
    @Override
    public String registerDoctor(Doctor doctor) {
        int idVal = doctorRepo.save(doctor).getDocId();
        return "doctor is saved with Id value"+ idVal;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = doctorRepo.findAll();
        list.sort((d1,d2)->d1.getDocName().compareTo(d2.getDocName()));
        return list;
    }

    @Override
    public Doctor getDoctorBYId(int id) throws DoctorNotFoundException {
        Doctor doc = doctorRepo.findById(id).orElseThrow(()-> new DoctorNotFoundException("Doctor with "+id +" is not found")) ;
        return doc;
    }

    @Override
    public String updateDoctor(Doctor doctor) throws DoctorNotFoundException {
        Optional<Doctor>opt = doctorRepo.findById(doctor.getDocId());
        if(opt.isPresent()){
            doctorRepo.save(doctor);
            return "Doctor's details with ID "+doctor.getDocId()+ " are Updated";
        }
        else {
            throw new DoctorNotFoundException("Doctor with "+doctor.getDocId()+" is not found, Please create a record first");
        }

    }

    @Override
    public String deleteByID(int id) throws DoctorNotFoundException {
        Optional<Doctor>opt = doctorRepo.findById(id);
        if (opt.isPresent()){
            doctorRepo.deleteById(id);
            return "Doctor with ID "+ id+ " is deleted";
        }
        else {
            throw new DoctorNotFoundException("Doctor with ID "+id+" is not found");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String deleteDoctorsByIncomeRange(Double start, Double end) {
        int count = doctorRepo.deleteDoctorsByIncomeRange(start, end);
        return count +" no of doctors are deleted";
    }

    @Override
    public String hikeDoctorIncomebyPercentage(int docId, double percentage) {
        Optional<Doctor>opt=doctorRepo.findById(docId);
        if(opt.isPresent()){
            Doctor doc = opt.get();
            doc.setIncome(doc.getIncome()+ (doc.getIncome()*(percentage/100)));
            doctorRepo.save(doc);
            return "Doctor income is hiked";
        }

        else {
            throw new DoctorNotFoundException("Doctor with ID " +docId + " is not found");
        }
    }



}
