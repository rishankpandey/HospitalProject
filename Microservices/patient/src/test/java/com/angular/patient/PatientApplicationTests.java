package com.angular.patient;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.angular.patient.controller.patientController;
import com.angular.patient.entity.patient;
import com.angular.patient.service.patientservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan(basePackages= "com.angular.patient")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
class PatientApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	private patientservice ps;
	
	@InjectMocks
	private patientController pc;
	
	@BeforeEach
	public void setUp()
	{
		mockMvc=MockMvcBuilders.standaloneSetup(pc).build();
	}
	@Test
	public void getdoctorTest() throws Exception {
		List<patient> mockpatient=new ArrayList<patient>();
		patient temp1=new patient(1,"Ajay","Gaurav Sharma","2022-08-22T18:30:00.000Z","Not prescribed");
		mockpatient.add(temp1);
		temp1=new patient(1,"Satish","Anjali Mathur","2022-08-22T18:30:00.000Z","Not prescribed");
		mockpatient.add(temp1);
		
		Mockito.when(ps.getpatient()).thenReturn(mockpatient);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.get("http://localhost:8082/patient").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
	    System.out.println(outputinjson);
		String expected= this.mapToJson(mockpatient);
		
		JSONAssert.assertEquals(expected, outputinjson, false);	
		
	}	
	
	@Test
	public void adddoctorTest() throws Exception{
		patient pat=new patient(1,"Ajay","Gaurav Sharma","2022-08-22T18:30:00.000Z","Not prescribed");
		String expected= this.mapToJson(pat);
		Mockito.when(ps.addpatient(pat)).thenReturn(pat);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.post("http://localhost:8082/patient").content(expected).contentType(
	            MediaType.APPLICATION_JSON).accept(
	    				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
		System.out.println(expected);
		System.out.println(outputinjson);		
		
	}
	
	@Test
	public void getdoctorbyidTest() throws Exception {
		patient pat=new patient(1,"Ajay","Gaurav Sharma","2022-08-22T18:30:00.000Z","Not prescribed");
		Mockito.when(ps.getpatientbyid(1)).thenReturn(pat);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.get("http://localhost:8082/patient/{id}",1).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
	    System.out.println(outputinjson);
		String expected= this.mapToJson(pat);	
		JSONAssert.assertEquals(expected, outputinjson, false);	
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException
	{
		ObjectMapper objectmapper= new ObjectMapper();
		return objectmapper.writeValueAsString(object);
	}
		
	}
