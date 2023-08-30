package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@Column(name="student_id")
	private int stuId;
	@Column(name="student_name")
	private String stuName;
	@Column(name="student_city")
	private String stuCity;
	
	
	public Student(int stuId, String stuName, String stuCity) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuCity = stuCity;
	}
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getStuId() {
		return stuId;
	}


	public void setStuId(int stuId) {
		this.stuId = stuId;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getStuCity() {
		return stuCity;
	}


	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}

	
}
