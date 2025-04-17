package com.rahul.ems.Entity;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class EmployeeEntity {
//SELECT * FROM emps.employees; this will be the query for the database as we always used to run direct queries on tables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	@NotBlank(message = "Email is required")
	private String name;
	
	@Column(nullable=false, unique=true)
	@Email(message="Please provide a valid email address")
	@NotBlank(message = "Email is required")
	private String email;

	@Column(nullable=false)
	private LocalDate dob ;

	@Transient
	private Integer  age ;
	
	@Column(nullable=false)
	private Double  salary ;
	
	@Column(nullable=false)
	private Boolean  status;
	
	
	public EmployeeEntity() {
		super();
	}
    
    public EmployeeEntity(Long id, String name, @Email(message = "Invalid Email Format") String email, LocalDate dob,
			Integer age, Double salary, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	//Age Calculations from Dob to Age
	public int getAge() {
		LocalDate today = LocalDate.now();         
		return Period.between(this.dob, today).getYears();   
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age
				+ ", salary=" + salary + ", status=" + status + "]";
	}	
}