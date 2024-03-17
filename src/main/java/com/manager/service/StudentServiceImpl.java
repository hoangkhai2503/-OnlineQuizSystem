package com.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manager.entities.Role;
import com.manager.entities.Student;
import com.manager.entities.Superadmin;
import com.manager.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Iterable<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student findId(int id_student) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id_student).get();
	}
	@Override
	public boolean save(Student student) {
		try {
			studentRepository.save(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Student loginStudent(String email_student, String password_student) {
		try {
			return studentRepository.loginStudent(email_student, password_student);
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	}
	@Override
	public Student findByEmailStudent(String email_student) {
		return studentRepository.findByEmailStudent(email_student);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email_student) throws UsernameNotFoundException {
	    Student student = studentRepository.findByEmailStudent(email_student);
	    if (student == null) {
	        throw new UsernameNotFoundException("Student Not Found");
	    }

	    List<GrantedAuthority> authorities = new ArrayList<>();
	    Role role = student.getRole();
	    if (role != null) {
	        authorities.add(new SimpleGrantedAuthority(role.getName_role()));
	    }

	    return new User(email_student, student.getPassword_student(), authorities);
	}

}