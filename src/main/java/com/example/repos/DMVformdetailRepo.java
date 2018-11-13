package com.example.repos;

import com.example.beans.DMVformdetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DMVformdetailRepo extends CrudRepository<DMVformdetail,Integer> {

    DMVformdetail findByIdAndLicense(int EmployeeId,String License);

    List<DMVformdetail> findById(int id);

}
