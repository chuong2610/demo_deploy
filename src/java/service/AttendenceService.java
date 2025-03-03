/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AttendenceDAO;
import dto.AttendenceDTO;
import dto.EmployeeDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Attendence;
import model.Employee;

/**
 *
 * @author ADMIN
 */
public class AttendenceService {

    AttendenceDAO attendenceDAO = new AttendenceDAO();
    
    public boolean deleteByEmployeeId(int id){
        return attendenceDAO.deleteByEmployeeId(id);
    }
    
    public boolean update(AttendenceDTO adto){
        Attendence a = new Attendence();
        Employee e = new Employee();
        e.setId(adto.getEmployeeDTO().getId());
        a.setTotalTime(0);
        a.setTimeCheckIn(adto.getTimeCheckIn()!= null ? adto.getTimeCheckIn():null);
        a.setTimeCheckOut(adto.getTimeCheckOut()!= null ? adto.getTimeCheckOut():null);
        a.setTotalTime(adto.getTotalTime());
        a.setEmployee(e);
        return attendenceDAO.update(a);
    }  
    
    public AttendenceDTO findByDateAndIdEmployee(LocalDate date, int id) {
        Attendence a = attendenceDAO.findByDateAndIdEmployee(date, id);

        if (a != null) {
            AttendenceDTO adto = new AttendenceDTO();
            EmployeeDTO edto = new EmployeeDTO();
            edto.setId(a.getEmployee().getId());
            edto.setName(a.getEmployee().getName());

            adto.setTimeCheckIn(a.getTimeCheckIn());
            adto.setTimeCheckOut(a.getTimeCheckOut());
            adto.setTotalTime(a.getTotalTime());
            adto.setEmployeeDTO(edto);
            if (adto.getTimeCheckIn().getHour() < 7) {
                adto.setStatus("Đúng giờ");
            } else {
                adto.setStatus("Muộn giờ");
            }
            return adto;
        }
        return null;
    }

    public int insert(AttendenceDTO adto) {
        Attendence a = new Attendence();
        Employee e = new Employee();
        e.setId(adto.getEmployeeDTO().getId());
         a.setTimeCheckIn(adto.getTimeCheckIn()!= null ? adto.getTimeCheckIn():null);
        a.setTimeCheckOut(adto.getTimeCheckOut()!= null ? adto.getTimeCheckOut():null);
        a.setTotalTime(adto.getTotalTime());
        a.setEmployee(e);
        return attendenceDAO.insert(a);
    }

    public List<AttendenceDTO> findTop10() {
        List<Attendence> attendences = attendenceDAO.findTop10();
        List<AttendenceDTO> attendenceDTOs = new ArrayList<>();
        for (Attendence a : attendences) {
            AttendenceDTO adto = new AttendenceDTO();

            EmployeeDTO edto = new EmployeeDTO();
            edto.setId(a.getEmployee().getId());
            edto.setName(a.getEmployee().getName());

            adto.setTimeCheckIn(a.getTimeCheckIn());
            adto.setTimeCheckOut(a.getTimeCheckOut());
            adto.setTotalTime(a.getTotalTime());
            adto.setEmployeeDTO(edto);
            if (adto.getTimeCheckIn().getHour() < 7) {
                adto.setStatus("Đúng giờ");
            } else {
                adto.setStatus("Muộn giờ");
            }
            attendenceDTOs.add(adto);
        }
        return attendenceDTOs;
    }
    
    public List<AttendenceDTO> findTop5ByEmployeeId(int id){
        List<Attendence> attendences = attendenceDAO.findTop5ByEmployeeId(id);
        List<AttendenceDTO> attendenceDTOs = new ArrayList<>();
        for (Attendence a : attendences) {
            AttendenceDTO adto = new AttendenceDTO();

            EmployeeDTO edto = new EmployeeDTO();
            edto.setId(a.getEmployee().getId());
            edto.setName(a.getEmployee().getName());

            adto.setTimeCheckIn(a.getTimeCheckIn());
            adto.setTimeCheckOut(a.getTimeCheckOut());
            adto.setTotalTime(a.getTotalTime());
            adto.setEmployeeDTO(edto);
            if (adto.getTimeCheckIn().getHour() < 7) {
                adto.setStatus("Đúng giờ");
            } else {
                adto.setStatus("Muộn giờ");
            }
            attendenceDTOs.add(adto);
        }
        return attendenceDTOs;
    }

}
