/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EmployeeDAO;
import model.Employee;

/**
 *
 * @author ADMIN
 */
public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    public Employee IsValidEmployee(String username,String password){
        Employee e = employeeDAO.IsValidEmployee(username, password);
        return e;
    }
}
