package com.rahul.ems.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.rahul.ems.Entity.*;

import com.rahul.ems.Repository.EmployeeRepository;
import com.rahul.ems.ServiceInterface.EmployeeServiceInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
	
	@Override
	public void saveEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee); // Handles both INSERT and UPDATE
    }
    
    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null); // Returns null if not found
    }
	
    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id); // Deletes the employee with the given ID
    }
	
    @Override
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeEntity> searchEmployees(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return employeeRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
        } else {
            return employeeRepository.findAll();
        }
    }
	
}
