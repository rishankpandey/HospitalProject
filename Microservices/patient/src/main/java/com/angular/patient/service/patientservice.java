package com.angular.patient.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.angular.patient.entity.patient;

@Repository
public interface patientservice {
 public List<patient> getpatient();
 public patient getpatientbyid(int id);
 public patient addpatient(patient pat);
}
