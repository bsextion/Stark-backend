package com.example.services;



import com.example.beans.Character;
import com.example.beans.DMVformdetail;
import com.example.repos.DMVformdetailRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DmvService {

    @Autowired
    private DMVformdetailRepo dmVformdetailRepo;

    public List<DMVformdetail> getAllEmployees() {
        List<DMVformdetail> list = new ArrayList<>();

        dmVformdetailRepo.findAll().forEach(e -> list.add(e) );
        return list;
    }

    public List <DMVformdetail> getEmployeeById(int id)
    {
        List<DMVformdetail> list = new ArrayList<>();
        dmVformdetailRepo.findById(id).forEach(e -> list.add(e));
        return list;

    }

    public DMVformdetail getEmployeeByIdLicense(int id, String license) {
        DMVformdetail employee = dmVformdetailRepo.findByIdAndLicense(id, license);


            return employee;
    }

    public void addEmployee(DMVformdetail dmVformdetail){
     dmVformdetailRepo.save(dmVformdetail);
    }





}
