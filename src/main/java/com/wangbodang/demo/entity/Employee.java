package com.wangbodang.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private Double salary;

    private Date hiredate;

    private String hiredatePeriod;

    private String remark;

    private String summary;

    private BigDecimal decimalNumber;

    private String idcard;

    private String birthday;

    private String gendercn;

    private String officedate;

    private String testdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getHiredatePeriod() {
        return hiredatePeriod;
    }

    public void setHiredatePeriod(String hiredatePeriod) {
        this.hiredatePeriod = hiredatePeriod == null ? null : hiredatePeriod.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public BigDecimal getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(BigDecimal decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getGendercn() {
        return gendercn;
    }

    public void setGendercn(String gendercn) {
        this.gendercn = gendercn == null ? null : gendercn.trim();
    }

    public String getOfficedate() {
        return officedate;
    }

    public void setOfficedate(String officedate) {
        this.officedate = officedate == null ? null : officedate.trim();
    }

    /*public String getTestdate() {
        return testdate;
    }

    public void setTestdate(String testdate) {
        this.testdate = testdate == null ? null : testdate.trim();
    }*/
}