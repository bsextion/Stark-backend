package com.example.controllers;

import com.example.beans.DMVformdetail;
import com.example.services.DmvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dmv")
public class DMVController {

    @Autowired
    private DmvService dmvService;

    @GetMapping("dmvFormDetail/{employeeId}")
    public ResponseEntity <List<DMVformdetail>> getDmvForm(@PathVariable("employeeid")int employeeId, @RequestParam(value = "licenseNumber", required = false)String licenseNumber)
     {
        List <DMVformdetail> list = null;
        if(licenseNumber.isEmpty())
        {
            list = dmvService.getEmployeeById(employeeId);

        }
        else if(!licenseNumber.isEmpty()){
            list = (List<DMVformdetail>) dmvService.getEmployeeByIdLicense(employeeId, licenseNumber);

        }
        return new ResponseEntity<List<DMVformdetail>>(list, HttpStatus.OK);
    }

    @GetMapping("dmvFormDetail/forms")
    public ResponseEntity <List<DMVformdetail>> getDmvForm() {
        List<DMVformdetail> list = dmvService.getAllEmployees();
        return new ResponseEntity<List<DMVformdetail>>(list, HttpStatus.OK);

    }

    @PostMapping(value = "dmvFormSubmit")
    public ResponseEntity<DMVformdetail> createUser(@RequestBody DMVformdetail dmVformdetail){

        dmvService.addEmployee(dmVformdetail);
        return new ResponseEntity<DMVformdetail>(dmVformdetail, HttpStatus.OK);
    }





}
