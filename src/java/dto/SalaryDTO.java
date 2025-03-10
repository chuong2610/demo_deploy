/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.Employee;

/**
 *
 * @author ADMIN
 */
public class SalaryDTO {
    private int totalSalary;
    private int month;
    private int year;
    private EmployeeDTO employeeDTO;

    public SalaryDTO() {
    }

    public SalaryDTO(int totalSalary, int month, int year, EmployeeDTO employeeDTO) {
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
        this.employeeDTO = employeeDTO;
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

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }
    
    
}
