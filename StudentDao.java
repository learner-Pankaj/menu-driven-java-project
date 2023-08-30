package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTempelate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i = (Integer)this.hibernateTempelate.save(student);
		return i;
	}
	
	//getting single data
	public Student getStudent(int stuId) {
		Student student = this.hibernateTempelate.get(Student.class, stuId);
		return student;
	}
	
	//getting multiple data
	public List<Student> getAllStudent(){
		List<Student> student = this.hibernateTempelate.loadAll(Student.class);
		return student;
	}
	
	//delete data
	@Transactional
	public void deleteStudent(int stuId) {
		Student student = this.hibernateTempelate.get(Student.class, stuId);
		this.hibernateTempelate.delete(student);
	}
	
	//update student
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTempelate.update(student);
	}
	

	public HibernateTemplate getHibernateTempelate() {
		return hibernateTempelate;
	}

	public void setHibernateTempelate(HibernateTemplate hibernateTempelate) {
		this.hibernateTempelate = hibernateTempelate;
	}
	
	
	
	
}
