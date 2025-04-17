package com.rahul.ems.ServiceInterface;
import java.util.*;
import com.rahul.ems.Entity.*;
public interface EmployeeServiceInterface {

	List<EmployeeEntity> getAllEmployees();
	void saveEmployee(EmployeeEntity employee);
    EmployeeEntity getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    List<EmployeeEntity> getEmployees();
    List<EmployeeEntity> searchEmployees(String keyword);
}
