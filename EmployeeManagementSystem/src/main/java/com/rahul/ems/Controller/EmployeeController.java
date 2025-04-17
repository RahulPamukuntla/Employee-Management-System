package com.rahul.ems.Controller;

import javax.validation.Valid;
import org.slf4j.Logger;//For logging the correct files
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.ems.Service.EmployeeService;
import com.rahul.ems.Entity.EmployeeEntity;
import java.util.List;

@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
    private EmployeeService employeeService;
	
	
//--------Landing Page----->
	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
	
	// Shows Add Form for Employee----->
    @GetMapping("/showNewEmployeeForm")
    public String showEmployeeForm(Model model) {
        EmployeeEntity employee = new EmployeeEntity();
        model.addAttribute("employee", employee);
        return "addemployee";
    }
    
    // Saves the Data From Add and Edit Pages---->
    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeEntity employee, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            // Determine which page to return based on whether it's an Add or Edit operation
            if (employee.getId() == null) {
                logger.debug("Validation failed for adding employee: {}", result.getAllErrors());
                return "addemployee"; // Return to Add page
            } else {
                logger.debug("Validation failed for editing employee: {}", result.getAllErrors());
                return "editemployee"; // Return to Edit page
            }
        }
    	logger.info("Employee Saved:{}"+employee.getEmail());
    	employeeService.saveEmployee(employee);
        return "redirect:/"; 
    }
    
    // Shows Edit form to Update---->
    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        EmployeeEntity employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return "redirect:/"; 
        }
        model.addAttribute("employee", employee);
        return "editemployee";
    }
	
	//----Deletes the Employee Entity By ID----->
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/"; 
    }	
    
    
    @GetMapping("/searchEmployee")
    public String searchEmployee(@RequestParam("keyword") String keyword, Model model) {
        List<EmployeeEntity> result = employeeService.searchEmployees(keyword);
        model.addAttribute("listEmployees", result);
        return "index"; // your JSP page name
    }
}
