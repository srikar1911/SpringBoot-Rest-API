package com.BootRestProj07.exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(){

    }

    public DoctorNotFoundException(String msg){

        super(msg);
    }

}
