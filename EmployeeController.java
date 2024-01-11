package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/insert")
	public String insertData(@RequestBody EmployeePojo employeePojo)
	{
		int i=employeeService.postData(employeePojo);
		if(i>0)
			return "inserted";
		else
			return "not inserted";
	}	
	
	@GetMapping("/select")
	public List selectData(@RequestBody EmployeePojo employeePojo)
	{
		List data = employeeService.getData(employeePojo);
		return data;
	}

	@PutMapping("/edit")
	public String updateData(@RequestBody EmployeePojo employeePojo)
	{
		int i = employeeService.editData(employeePojo);
		if(i>0)
			return "edited";
		else 
			return "not edited";
	}
	
	@DeleteMapping("/delete")
	public String deleteData(@RequestBody EmployeePojo employeePojo)
	{
		int i = employeeService.removeData(employeePojo);
		if(i>0)
			return "deleted";
		else 
			return "not deleted";
	}
	
}
