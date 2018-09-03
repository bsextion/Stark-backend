package com.example.controllers;

import com.example.beans.Employee;
import com.example.repos.EmployeeRepo;
import com.example.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/got")
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeRepo employeeRepo;

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity <Employee> getEmployee ( HttpServletRequest httpServletRequest, @PathVariable("id") int id) {


        if (!employeeService.getEmployeeById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        } else {
            return new ResponseEntity<>(employeeService.getEmployeeById(id).get(), HttpStatus.OK);
        }

    }




    @PostMapping(value = "/employee/new")
    public ResponseEntity<String> addEmployee(HttpServletRequest httpServletRequest, @RequestBody Employee employee)
    {
        try {
            if (!employeeService.saveEmployee(employee)) {

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(HttpStatus.OK);
            }

        }
        catch (IOException e) {
//            log.debug(e.getMessage())
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }



}