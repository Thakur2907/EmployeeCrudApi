package com.Spring.Employee.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Spring.Employee.repository.EmployeeRepository;
import com.Spring.Employee.model.Employee;

import java.util.*;

@Service

public class EmployeeService {
    @Autowired
    private  EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(long id){
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }
    public Employee updateEmployee(Long id,Employee emp_details){
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setEmp_name(emp_details.getEmp_name());
        employee.setEmp_salary(emp_details.getEmp_salary());
        employee.setEmp_designation(emp_details.getEmp_designation());

        return employeeRepository.save(emp_details);
    }
    public void deleteEmployee(long id){
        Employee emp= employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(emp);
    }
}