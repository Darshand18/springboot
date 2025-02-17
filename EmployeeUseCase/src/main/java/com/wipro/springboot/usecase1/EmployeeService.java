package com.wipro.springboot.usecase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Assign default role
    public Employee addEmployee(Employee employee) {
        // Default role assignment based on logic (if a developer is joining)
        if ("Developer".equalsIgnoreCase(employee.getRole())) {
            employee.setRole("Developer");
        } else if ("Manager".equalsIgnoreCase(employee.getRole())) {
            employee.setRole("Manager");
        } else if ("Tester".equalsIgnoreCase(employee.getRole())) {
            employee.setRole("Tester");
        } else {
            employee.setRole("Developer"); // Default role if no valid role provided
        }

        return employeeRepository.save(employee);
    }

    // Update existing employee's role
    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    // Get employees by role
    public List<Employee> getEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
