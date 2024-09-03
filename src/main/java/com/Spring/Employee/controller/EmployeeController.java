package com.Spring.Employee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Spring.Employee.service.EmployeeService;
import com.Spring.Employee.model.Employee;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService empservice;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return empservice.getAllEmployees();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Optional <Employee> emp=empservice.getEmployeeById(id);
        if (emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee emp){
        if (emp != null){
            System.out.println("Got the details");
        }
        return empservice.createEmployee(emp);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee empdetails){
        Employee updatedemployee=empservice.updateEmployee(id,empdetails);
        return ResponseEntity.ok(updatedemployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        empservice.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}