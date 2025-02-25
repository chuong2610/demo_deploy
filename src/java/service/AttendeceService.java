/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import dao.AttendenceDAO;
import dto.AttendenceDTO;
import dto.EmployeeDTO;
import java.util.ArrayList;
import java.util.List;
import model.Attendence;

/**
 *
 * @author ADMIN
 */
public class AttendeceService {
    AttendenceDAO attendenceDAO = new AttendenceDAO();
    
    public List<AttendenceDTO> findTop10(){
        List<Attendence> attendences= attendenceDAO.findTop10();       
        List<AttendenceDTO> attendenceDTOs = new ArrayList<>();
        for(Attendence a: attendences){
            AttendenceDTO adto = new AttendenceDTO();
            
            EmployeeDTO edto = new EmployeeDTO();
            edto.setId(a.getEmployee().getId());
            edto.setName(a.getEmployee().getName());
            
            adto.setTimeCheckIn(a.getTimeCheckIn());
            adto.setTimeCheckOut(a.getTimeCheckOut());
            adto.setEmployeeDTO(edto);
            if(adto.getTimeCheckIn().getHour()<7)
                adto.setStatus("Đúng giờ");
            else
                adto.setStatus("Muộn giờ");
            attendenceDTOs.add(adto);
        }
        return attendenceDTOs;
    }
    
}
