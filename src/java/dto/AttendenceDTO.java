/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class AttendenceDTO {
    private LocalDateTime timeCheckIn;
    private LocalDateTime timeCheckOut;
    private EmployeeDTO employeeDTO;
    private float totalTime;
    private String status;

    public AttendenceDTO() {
    }

    public AttendenceDTO(LocalDateTime timeCheckIn, LocalDateTime timeCheckOut,float totalTime, EmployeeDTO employeeDTO,String status) {
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
        this.totalTime=totalTime;
        this.employeeDTO = employeeDTO;
        this.status=status;
    }

    public LocalDateTime getTimeCheckIn() {
        return timeCheckIn;
    }

    public void setTimeCheckIn(LocalDateTime timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }

    public LocalDateTime getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setTimeCheckOut(LocalDateTime timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

   
    
    
}
