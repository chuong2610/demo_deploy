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
public class RoleDTO {
    private int id;
    private String name;
    private int roleSalary;

    public RoleDTO() {
    }

    public RoleDTO(int id,String name, int roleSalary) {
        this.id=id;
        this.name = name;
        this.roleSalary = roleSalary;
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

    public int getRoleSalary() {
        return roleSalary;
    }

    public void setRoleSalary(int roleSalary) {
        this.roleSalary = roleSalary;
    }
    
    
    
    
}
