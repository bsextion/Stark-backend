package com.example.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

public class DMVformdetail {
    @Entity
    @Table(name="dmvformdetail")
    @Getter
    @Setter
    @ToString

    public class Character implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name="id")
        private int id;

        @Column(name="first_name")
        private String firstName;

        @Column(name="last_name")
        private String lastName;

        @Column(name = "house")
        private String house;

        int EmployeeId
        String FirstName
        String MiddleName
        String LastName
        String Dob
        String Sex
        String Height
        int Weight
        String EyeColor
        String HairColor
        private char StateBgc
        private String CreateUserId
        private String CreateDateTime
        String Update UserId
        String UpdateDateTime


    }
}
