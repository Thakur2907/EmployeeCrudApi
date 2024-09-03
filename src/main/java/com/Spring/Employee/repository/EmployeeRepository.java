package com.Spring.Employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Spring.Employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
