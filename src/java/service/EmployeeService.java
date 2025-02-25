/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EmployeeDAO;
import dto.EmployeeDTO;
import dto.RoleDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author ADMIN
 */
public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    
    public int nuberEmployeeAttendencing(){
        return employeeDAO.numberEmployeeAttendencing();
    }
    
    public EmployeeDTO IsValidEmployee(String username,String password){
        Employee e = employeeDAO.IsValidEmployee(username, password);
        RoleDTO roleDTO= new RoleDTO();
        roleDTO.setName(e.getRole().getName());
        EmployeeDTO edto = new EmployeeDTO(e.getId(),e.getName(),e.getPhone(), e.getEmail(), e.getDate(), roleDTO);
        return edto;
    }
    public List<EmployeeDTO> findAll(){
        List<EmployeeDTO> employeeDTOs= new ArrayList<>();
        for(Employee e : employeeDAO.findAll()){
            EmployeeDTO eDto = new EmployeeDTO();
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setName(e.getRole().getName());
            eDto.setId(e.getId());
            eDto.setName(e.getName());
            eDto.setEmail(e.getEmail());
            eDto.setPhone(e.getPhone());
            eDto.setDate(e.getDate());
            eDto.setRoleDTO(roleDTO);
            employeeDTOs.add(eDto);
        }
        return employeeDTOs;
    }
}
