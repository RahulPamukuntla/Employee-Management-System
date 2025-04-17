package com.rahul.ems.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.ems.Entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	   List<EmployeeEntity> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

}
