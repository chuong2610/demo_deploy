/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
    
import dao.SalaryDAO;

/**
 *
 * @author ADMIN
 */
public class SalaryService {
    SalaryDAO salaryDAO = new SalaryDAO();
    
    public boolean deleteByEmployeeId(int id){
        return salaryDAO.delete(id);
    }
}
