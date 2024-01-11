package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int postData(EmployeePojo employeePojo) {
		int id= employeePojo.getId();
		String name=employeePojo.getName();
		String dept=employeePojo.getDept();
		int sal=employeePojo.getSal();
		String string=("insert into employee values(?,?,?,?)");
		return jdbcTemplate.update(string,id,name,dept,sal);
	}

	public List getData(EmployeePojo employeePojo) {
		int id=employeePojo.getId();
        List data = jdbcTemplate.queryForList("select * from employee where id=?",id);
		return data;
	}

	public int editData(EmployeePojo employeePojo) {
        int id = employeePojo.getId();
        String name = employeePojo.getName();
        String query = ("update employee set name=? where id=?");
        
		return jdbcTemplate.update(query,name,id);
	}

	public int removeData(EmployeePojo employeePojo) {
       int id = employeePojo.getId();
       String query =("delete from employee where id=?");
       
		return jdbcTemplate.update(query,id);
	}

	
}
