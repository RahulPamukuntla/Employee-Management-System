package com.rahul.EmployeeManagementSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
 @Autowired
 private EmployeeRepository employeeRepository;
 
 
 public List<Employee> getAllEmployees(){
	 return employeeRepository.findAll();
 }
  public Optional<Employee> getEmployeeById(Long id){
	  return employeeRepository.findById(id);
  }
 public void saveEmployee(Employee employee) {
	 employeeRepository.save(employee);
 }
 public void deleteEmployee(Long id) {
	 employeeRepository.deleteById(id);
 }
 
 
 
 
 
 
 
 
 
 
}
