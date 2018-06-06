package com.advjava.first.studentapplication;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.advjava.first.studentapplication.model.Student;
import com.advjava.first.studentapplication.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentapplicationApplicationTests {

	@Autowired
	StudentRepository studentRepo;
	
	@Test
	public void createStudent()
	{
		Student student1= new Student();
		student1.setStudentId(4);
		student1.setStudentName("testStudent1");
		student1.setAddress("hyd");
		student1.setCourse("angularJS");
		student1.setFee(10000);
		student1.setDob("12-11-1999");
		studentRepo.save(student1);
		
		System.out.println("student creaated successfully...!");
	}

	@Test
	public void showStudentss()
	{
		List<Student> studentList= (List<Student>) studentRepo.findAll();
		for(Student stu:studentList)
		{
			System.out.println(stu);
		}
		
		System.out.println("Done...!");
	}
	
	@Test
	public void updateStudent()
	{
		Optional<Student> stu=studentRepo.findById(4);
		System.out.println(stu);
		stu.get().setStudentName("gopi");
		studentRepo.save(stu.get());
		System.out.println("updated..!!");
	}
	
	@Test
	public void deleteStudent() {
		Student stu=new Student();
		stu.setStudentId(1);
		studentRepo.delete(stu);
		System.out.println("Deleted successfully");
	}
}
