package com.angular.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.angular.patient.dao.patientDao;
import com.angular.patient.entity.patient;


@Service
public class patientserviceImpl implements patientservice{
	
	@Autowired
	private patientDao pd;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<patient> getpatient() {
		// TODO Auto-generated method stub
		return pd.findAll();
	}

	@Override
	public patient getpatientbyid(int id) {
		// TODO Auto-generated method stub
		return pd.findById(id).get();
	}

	@Override
	public patient addpatient(patient pat) {
		// TODO Auto-generated method stub
		ResponseEntity<String> e=restTemplate.getForEntity("http://DOCTOR-SERVICE/doctor/addpatient/"+ pat.getVisiteddoctor(), String.class);
		String visitedd=e.getBody();
		pat.setVisiteddoctor(visitedd);
		return pd.save(pat);
	}

}
