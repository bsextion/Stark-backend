package com.example.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="dmvformdetail")
@Getter @Setter @ToString
public class DMVformdetail implements Serializable   {

        private int emId;
        private String licNbr;
        private String FirstName;
        private String MiddleName;
        private String LastName;
        private String Dob;
        private String Sex;
        private String Height;
        private int Weight;
        private String EyeColor;
        private String HairColor;
        private char StateBgc;
        private String CreateUserId;
        private String CreateDateTime;
        private String UpdateUserId;
        private String UpdateDateTime;
        private Date CRET_DTTM;
        private Date UPDT_DTTM;

        @Id
        @Column(name="EMPL_ID")
        public int getEmId() {
            return emId;
        }
        public void setEmId(int emId) {
            this.emId = emId;
        }

        @Id
        @Column(name = "DMV_LIC_NBR")
        public String getLicNbr() {
            return licNbr;
        }
        public void setLicNbr(String licNbr) {
            this.licNbr = licNbr;
        }

        @Column(name = "EMPL_FIRST_NAME")
        public String getFirstName() {
            return FirstName;
        }
        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        @Column(name = "EMPL_MDL_NAME")
        public String getMiddleName() {
            return MiddleName;
        }
        public void setMiddleName(String middleName) {
            MiddleName = middleName;
        }

        @Column(name = "EMPL_LST_NAME")
        public String getLastName() {
            return LastName;
        }
        public void setLastName(String lastName) {
            LastName = lastName;
        }

        @Column(name = "EMPL_BRTH_DT")
        public String getDob() {
            return Dob;
        }
        public void setDob(String dob) {
            Dob = dob;
        }

        @Column(name = "EMPL_SEX_CD")
        public String getSex() {
            return Sex;
        }
        public void setSex(String sex) {
            Sex = sex;
        }

        @Column(name = "EMPL_HEIGHT")
        public String getHeight() {
            return Height;
        }
        public void setHeight(String height) {
            Height = height;
        }

        @Column(name = "EMPL_WEIGHT")
        public int getWeight() {
            return Weight;
        }
        public void setWeight(int weight) {
            Weight = weight;
        }

        @Column(name = "EMPL_EYE_COLOR")
        public String getEyeColor() {
            return EyeColor;
        }
        public void setEyeColor(String eyeColor) {
            EyeColor = eyeColor;
        }

        @Column(name = "EMPL_HAIR_COLOR")
        public String getHairColor() {
            return HairColor;
        }
        public void setHairColor(String hairColor) {
            HairColor = hairColor;
        }

        @Column(name = "ST_CODE")
        public char getStateBgc() {
            return StateBgc;
        }
        public void setStateBgc(char stateBgc) {
            StateBgc = stateBgc;
        }

        @Column(name = "CR_USERID")
        public String getCreateUserId() {
            return CreateUserId;
        }
        public void setCreateUserId(String createUserId) {
            CreateUserId = createUserId;
        }

        @Transient
        public String getCreateDateTime() {
            return CreateDateTime;
        }
        public void setCreateDateTime(String createDateTime) {
            CreateDateTime = createDateTime;
        }

        @Column(name = "UPD_USERID")
        public String getUpdateUserId() {
            return UpdateUserId;
        }
        public void setUpdateUserId(String updateUserId) {
            UpdateUserId = updateUserId;
        }

        @Transient
        public String getUpdateDateTime() {
            return UpdateDateTime;
        }
        public void setUpdateDateTime(String updateDateTime) {
            UpdateDateTime = updateDateTime;
        }

        @Column(name = "CR_DATETIME")
        public Date getCRET_DTTM() {
            return CRET_DTTM;
        }
        public void setCRET_DTTM(Date CRET_DTTM) {
            this.CRET_DTTM = CRET_DTTM;
        }

        @Column(name = "UPD_DATETIME")
        public Date getUPDT_DTTM() {
            return UPDT_DTTM;
        }
        public void setUPDT_DTTM(Date UPDT_DTTM) {
            this.UPDT_DTTM = UPDT_DTTM;
        }





}
