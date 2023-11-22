package com.BootRestProj07.rest;

import com.BootRestProj07.entity.Doctor;
import com.BootRestProj07.service.IDoctorManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorOperationsController {
    @Autowired
    private IDoctorManagmentService doctorService;

    @PostMapping("/save")
    public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor) throws  Exception{
            String resultmsg = doctorService.registerDoctor(doctor);
            return new ResponseEntity<String>(resultmsg, HttpStatus.CREATED);

    }

    @GetMapping("/report")
    public ResponseEntity<?> getAllDoctors() throws  Exception{
            List<Doctor> list = doctorService.getAllDoctors();
            return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> fetchDocByID(@PathVariable int id)throws  Exception {
            Doctor doc = doctorService.getDoctorBYId(id);
            return new ResponseEntity<Doctor>(doc,HttpStatus.OK);
        }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyDoctorInfo(@RequestBody Doctor doctor)throws  Exception{
            String resultMsg = doctorService.updateDoctor(doctor);
            return new ResponseEntity<String>(resultMsg, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeDocByID(@PathVariable int id)throws  Exception {
            String resMsg = doctorService.deleteByID(id);
            return new ResponseEntity<String>(resMsg, HttpStatus.OK);


    }

    @DeleteMapping("/delete/{start}/{end}")
    public ResponseEntity<String> removeDocbyIncomeRange(@PathVariable double start, @PathVariable double end) throws  Exception{
            String resMsg = doctorService.deleteDoctorsByIncomeRange(start, end);
            return new ResponseEntity<String>(resMsg, HttpStatus.OK);

    }

    @PatchMapping("/update/{id}/{percentage}")
    public ResponseEntity<String> hikeDocSalary(@PathVariable int id, @PathVariable double percentage)throws  Exception{
            String resMsg = doctorService.hikeDoctorIncomebyPercentage(id,percentage);
            return new ResponseEntity<String>(resMsg,HttpStatus.OK);

    }

}
