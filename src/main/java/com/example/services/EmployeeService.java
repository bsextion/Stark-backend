package com.example.services;

import com.example.beans.Employee;
import com.example.repos.EmployeeRepo;


import java.io.IOException;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepo employeeRepo;

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);

    }

    public boolean saveEmployee (Employee employee) throws IOException {

        if(!employeeRepo.existsById(employee.getId()))
        {
            return false;
        }

        employeeRepo.save(employee);
        return true;
    }


}
