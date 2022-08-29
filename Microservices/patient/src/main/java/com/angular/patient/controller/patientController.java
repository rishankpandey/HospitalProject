package com.angular.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.patient.entity.patient;
import com.angular.patient.service.patientservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/patient")
public class patientController {
	
	@Autowired
	private patientservice ps;
	
	@GetMapping("")
	public List<patient> getpatient(){
		return ps.getpatient();
	}
	
	@GetMapping("/{id}")
	public patient getpatientbyid(@PathVariable(value= "id") int id)
	{
		return ps.getpatientbyid(id);
	}
	
	@PostMapping(path=""  , consumes="application/json")
	public patient addpatient(@RequestBody patient pat) {
		return ps.addpatient(pat);
	}

}
