package com.angular.patient.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class patient {
	@Id
	private int id;
	private String name;
	private String visiteddoctor;
	private String dateofvisit;
	private String prescription;
	public patient(int id, String name, String visiteddoctor, String dateofvisit, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.visiteddoctor = visiteddoctor;
		this.dateofvisit = dateofvisit;
		this.prescription = prescription;
	}
	public patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVisiteddoctor() {
		return visiteddoctor;
	}
	public void setVisiteddoctor(String visiteddoctor) {
		this.visiteddoctor = visiteddoctor;
	}
	public String getDateofvisit() {
		return dateofvisit;
	}
	public void setDateofvisit(String dateofvisit) {
		this.dateofvisit = dateofvisit;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "patient [id=" + id + ", name=" + name + ", visiteddoctor=" + visiteddoctor + ", dateofvisit="
				+ dateofvisit + ", prescription=" + prescription + "]";
	}
	
	

}
