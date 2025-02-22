package com.BootRestProj07.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DOCTOR_INFO_TABLE_NEWER")
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