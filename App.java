package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started ORM" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
        
//        insert student details
//        Student student = new Student(123, "Pankaj Yadav", "Bengaluru");
//        int r = studentDao.insert(student);
//        System.out.println("data inserted : "+r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        
        System.out.println("PRESS 1 for add new student");
        System.out.println("PRESS 2 for displaying all student");
        System.out.println("PRESS 3 for get details of single student");
        System.out.println("PRESS 4 for delete student");
        System.out.println("PRESS 5 for update student");
        System.out.println("PRESS 6 for EXIT");
        
        while(flag) {
	        
	        try {
	        	int input = Integer.parseInt(br.readLine());
	        	switch(input) {
	        	case 1 : //add a new student
	        		System.out.println("Enter user id : ");
	        		int uId = Integer.parseInt(br.readLine());
	        		
	        		System.out.println("Enter user name : ");
	        		String uName = br.readLine();
	        		
	        		System.out.println("Enter city");
	        		String uCity = br.readLine();
	        		
	        		Student stu = new Student();
	        		stu.setStuId(uId);
	        		stu.setStuName(uName);
	        		stu.setStuCity(uCity);
	        		int r = studentDao.insert(stu);
	        		System.out.println("data inserted : "+r);
	        		break;
	        		
	        	case 2 : //Display all student
	        		System.out.println("*******************************************");
	        		List<Student> allStudent = studentDao.getAllStudent();
	        		for(Student s : allStudent) {
	        			System.out.println("Id : "+s.getStuId());
	        			System.out.println("Name : "+s.getStuName());
	        			System.out.println("City : "+s.getStuCity());
	        			System.out.println("_________________________________________");
	        		}
	        		System.out.println("*******************************************");
	        		break;
	        		
	        	case 3 : //Detail of one student
	        		System.out.println("Enter user id : ");
	        		int userId = Integer.parseInt(br.readLine());
	        		Student st = studentDao.getStudent(userId);
	        		System.out.println("Id : "+st.getStuId());
        			System.out.println("Name : "+st.getStuName());
        			System.out.println("City : "+st.getStuCity());
        			System.out.println("_________________________________________");
	        		break;
	        	case 4 : //delete a student;
	        		System.out.println("Enter user id : ");
	        		int Id = Integer.parseInt(br.readLine());
	        		studentDao.deleteStudent(Id);
	        		System.out.println("Student Deleted !!");
	        		break;
	        	case 5 : // update
	        		System.out.println("Enter Student id to update existing data : ");
	        		int stuId = Integer.parseInt(br.readLine());
	        		Student updateStu = studentDao.getStudent(stuId);
	        		String name  = br.readLine();
	        		String city  = br.readLine();
	        		updateStu.setStuName(name);
	        		updateStu.setStuCity(city);
	        		studentDao.updateStudent(updateStu);
	        		System.out.println("Student updated !!");
	        		break;
	        	case 6 : //Exit
	        		flag = false;
	        		break;
	        		
	        	}
	        }catch(Exception ex) {
	        	System.out.println("Invalid input try input between 1 to 6");
	        	System.out.println(ex.getMessage());
	        }
        }
        System.out.println("See you next time");
    }
}
