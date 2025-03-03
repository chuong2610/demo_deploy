/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RoleDAO;
import dto.RoleDTO;
import java.util.ArrayList;
import java.util.List;
import model.Role;

/**
 *
 * @author ADMIN
 */
public class RoleService {
    RoleDAO roleDAO = new RoleDAO();
    public List<RoleDTO> findAll(){
        List<RoleDTO> roleDTOs= new ArrayList<>();
        for(Role role : roleDAO.findAll() ){
            roleDTOs.add(new RoleDTO(role.getId(), role.getName(), role.getRoleSalary()));
        }
        return roleDTOs;
    }
    
}
