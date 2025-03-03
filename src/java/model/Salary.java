/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Salary {
    private int id;
    private int totalSalary;
    private int month;
    private int year;
    private int employeeId;

    public Salary() {
    }

    public Salary(int id, int totalSalary, int month, int year, int employeeId) {
        this.id = id;
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totaltime) {
        this.totalSalary = totaltime;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    
    
}
