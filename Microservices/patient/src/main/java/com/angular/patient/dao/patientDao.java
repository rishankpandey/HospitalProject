package com.angular.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.patient.entity.patient;

@Repository
public interface patientDao extends JpaRepository<patient,Integer>{

}
