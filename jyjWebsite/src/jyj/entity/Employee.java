//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jyj.entity;

import java.util.Date;

public class Employee {
    private int empNo;
    private Date birthDay = new Date();
    private String name;
    private String gender;
    private Date hireDate = new Date();

    public Employee() {
    }

    public Employee(int empNo, String name, String gender, Date birthDay, Date hireDate) {
        this.empNo = empNo;
        this.birthDay = birthDay;
        this.name = name;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String toString() {
        return "Employee [empNo=" + this.empNo + ", birthDay=" + this.birthDay + ", name=" + this.name + ", gender=" + this.gender + ", hireDate=" + this.hireDate + "]";
    }
}
