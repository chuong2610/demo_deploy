/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class EmployeeDTO {
    private String name;
    private String phone;
    private String email;
    private LocalDate Date;
    private RoleDTO roleDTO;
     
    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, String phone, String email, LocalDate Date,RoleDTO roleDTO) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.Date = Date;
        this.roleDTO=roleDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

   

   
    
    
    
}
