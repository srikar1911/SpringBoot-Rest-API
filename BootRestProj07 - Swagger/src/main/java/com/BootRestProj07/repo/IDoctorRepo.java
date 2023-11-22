package com.BootRestProj07.repo;

import com.BootRestProj07.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

    @Modifying
    @Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")
    public int deleteDoctorsByIncomeRange(Double start, Double end);
}
