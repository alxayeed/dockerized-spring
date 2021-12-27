package com.alxayeed.dockerized.controller;

import com.alxayeed.dockerized.DockerizedApplication;
import com.alxayeed.dockerized.exceptions.ResourceNotFoundException;
import com.alxayeed.dockerized.model.Employee;
import com.alxayeed.dockerized.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(DockerizedApplication.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        logger.info("Get all employees....");
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException{
        logger.info("Get employee by id");
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee with id "+ employeeId + "not found"));

        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("employees")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        logger.info("Adding new employee");
        return employeeRepository.save(employee);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId, @RequestBody Employee updatedEmployee) throws ResourceNotFoundException{
        logger.info("Updating employee...");
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee with id "+ employeeId + "not found"));

        employee.setName(updatedEmployee.getName());
        employee.setAge(updatedEmployee.getAge());

        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);

    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException{
        logger.info("Deleting employee...");
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee with id "+ employeeId + "not found"));

        employeeRepository.delete(employee);
    }


}
