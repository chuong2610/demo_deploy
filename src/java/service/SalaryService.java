/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
    
import dao.SalaryDAO;
import dto.AttendenceDTO;
import dto.SalaryDTO;
import java.time.YearMonth;
import model.Salary;

/**
 *
 * @author ADMIN
 */
public class SalaryService {
    SalaryDAO salaryDAO = new SalaryDAO();
    
    public SalaryDTO findByMonthAndEmployeeId(YearMonth month, int id){
        if(salaryDAO.findByMonthAndEmployeeId(month, id)==null)
            return null;
        Salary salary=  salaryDAO.findByMonthAndEmployeeId(month, id);
        SalaryDTO sdto = new SalaryDTO();
        sdto.setTotalSalary(salary.getTotalSalary());
        sdto.setMonth(salary.getMonth());
        sdto.setYear(salary.getYear());
        sdto.setEmployeeId(salary.getEmployeeId());
        return sdto;
    }
    
    public boolean deleteByEmployeeId(int id){
        return salaryDAO.deleteByEmployeeId(id);
    }
}
