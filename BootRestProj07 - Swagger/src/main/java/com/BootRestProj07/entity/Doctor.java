package com.BootRestProj07.entity;


import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="DOCTOR_INFO")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOC_ID")
    private Integer docId;
    @Column(length = 20, name = "DOC_NAME")
    private String docName;
    @Column(length = 20, name = "SPECIALIZATION")
    private String specialisation;
    @Column(name = "INCOME")
    private Double income;

}