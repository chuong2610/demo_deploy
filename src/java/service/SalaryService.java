/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
    
import dao.AttendenceDAO;
import dao.EmployeeDAO;
import dao.SalaryDAO;
import dto.AttendenceDTO;
import dto.SalaryDTO;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import model.Attendence;
import model.Salary;

/**
 *
 * @author ADMIN
 */
public class SalaryService {
    SalaryDAO salaryDAO = new SalaryDAO();
    AttendenceDAO attendenceDAO = new AttendenceDAO();
    EmployeeService employeeService = new EmployeeService();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    
    public List<SalaryDTO> findAll(){
        List<SalaryDTO> salaryDTOs = new ArrayList<>();
        for(Salary s : salaryDAO.findAll()){
            SalaryDTO sDto = new SalaryDTO(s.getTotalSalary(),s.getMonth(),s.getYear(),employeeService.findById(s.getEmployee().getId()));
            salaryDTOs.add(sDto);
        }
        return salaryDTOs;
    }
    
    public int tinhLuong(int id, LocalDate date ){
        int total =0;
        for(Attendence a : attendenceDAO.findByMonhAndYear(id,date)){
            total +=a.getTotalTime()*a.getEmployee().getRole().getRoleSalary();
        } 
        return total;
    }
    
    public SalaryDTO findByMonthAndEmployeeId(YearMonth month, int id){
        if(salaryDAO.findByMonthAndEmployeeId(month, id)==null)
            return null;
        Salary salary=  salaryDAO.findByMonthAndEmployeeId(month, id);
        SalaryDTO sdto = new SalaryDTO();
        sdto.setTotalSalary(salary.getTotalSalary());
        sdto.setMonth(salary.getMonth());
        sdto.setYear(salary.getYear());
        sdto.setEmployeeDTO(employeeService.findById(id));
        return sdto;
    }
    
    public boolean deleteByEmployeeId(int id){
        return salaryDAO.deleteByEmployeeId(id);
    }
}
