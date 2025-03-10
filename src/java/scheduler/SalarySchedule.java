/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;


import dao.EmployeeDAO;
import dao.SalaryDAO;
import dto.EmployeeDTO;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import model.Attendence;
import model.Salary;
import service.AttendenceService;
import service.EmployeeService;
import service.SalaryService;

/**
 *
 * @author ADMIN
 */
public class SalarySchedule {
    
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        SalaryDAO salaryDAO = new SalaryDAO();
        EmployeeDAO employeeDAO= new EmployeeDAO();
        SalaryService salaryService = new SalaryService();
       
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        Runnable payrollTask = () -> {
            
            LocalDate today = LocalDate.now();
            if (today.getDayOfMonth() == 1) {
                for(EmployeeDTO e : employeeService.findAll()){
                     Salary salary = new Salary();
                    salary.setEmployee(employeeDAO.findByID(e.getId()));
                    salary.setMonth(today.getMonthValue());
                    salary.setYear(today.getYear());
                    salary.setTotalSalary(salaryService.tinhLuong(e.getId(), today));
                    int i=salaryDAO.insert(salary);
                    if (i > 0) {
                        System.out.println("Tính lương thành công cho nhân viên ID: " + e.getId());
                    } else {
                        System.err.println("Lỗi khi lưu lương cho nhân viên ID: " + e.getId());
                    }
                }
            }
        };
        
        

        schedule.scheduleAtFixedRate(payrollTask, 0, 1, TimeUnit.DAYS);
    }
}
