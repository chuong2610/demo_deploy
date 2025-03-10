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
    private int id;
    private String name;
    private String phone;
    private String email;
    private LocalDate Date;
    private RoleDTO roleDTO;
    private String img;
     
    public EmployeeDTO() {
    }

    public EmployeeDTO(int id,String name, String phone, String email, LocalDate Date,RoleDTO roleDTO, String img) {
        this.id=id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.Date = Date;
        this.roleDTO=roleDTO;
        this.img=img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   
    
   
    
    
    
}
