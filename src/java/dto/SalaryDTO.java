/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ADMIN
 */
public class SalaryDTO {
    private int totalSalary;
    private int month;
    private int year;
    private int employeeId;

    public SalaryDTO() {
    }

    public SalaryDTO(int totalSalary, int month, int year, int employeeId) {
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
        this.employeeId = employeeId;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
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
