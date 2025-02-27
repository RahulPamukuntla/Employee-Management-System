package com.rahul.EmployeeManagementSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	@GetMapping
	public String getAllEmployees(Model model) {
		List<Employee>employees = employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		return "employee-list";
	}

	@GetMapping("/add")
	public String showAddEmployeeForm(Model model) {
		model.addAttribute(model);
		return "employee-form";
	}

	@GetMapping("/edit/{id}")
	public String showEditEmployeeForm(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		if(employee.isPresent()) {
			model.addAttribute("employee",employee.get());
	     	return "employee-form";
		}else {
			return "redirect:/employees";
		}
	}
@PostMapping("/save")
public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	employeeService.saveEmployee(employee);
	return "redirect:/";
}
@GetMapping("/delete/{id}")
public String deleteEmployee(@PathVariable Long id) {
	employeeService.deleteEmployee(id);
	return "redirect:/";
}
	
	
	
	
	
	
	
}