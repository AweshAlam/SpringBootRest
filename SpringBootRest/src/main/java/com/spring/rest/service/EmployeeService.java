package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.rest.model.Employee;
import com.spring.rest.repository.EmployeeRepository;
@Service
@Component
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

	 public List<Employee> getAllEmployeeList() {
	        return employeeRepository.findAll();
	}
	 
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
   
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee, long id) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }
}
