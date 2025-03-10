/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AttendenceDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import model.Attendence;
import model.Employee;
import ultils.DBUltils;

/**
 *
 * @author tranm
 */
public class AttendenceDAO implements IDAO<Attendence, Integer> {

    public List<Attendence> findByMonhAndYear(int id,LocalDate date) {
        List<Attendence> attendence = new ArrayList<>();
        String sql = "SELECT a.*, e.id as employeeId, e.name as employeeName \n"
                + "FROM ATTENDENCE a \n"
                + "JOIN EMPLOYEE e ON e.id = a.employeeId \n"
                + "WHERE  e.id = ? and MONTH(a.timeCheckIn) = ? AND YEAR(a.timeCheckIn) = ?; ";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, date.getMonthValue());
            ps.setInt(3, date.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employeeId"));
                employee.setName(rs.getString("employeeName"));
                Timestamp timestamp = rs.getTimestamp("timeCheckIn");
                LocalDateTime timeCheckIn = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                timestamp = rs.getTimestamp("timeCheckOut");
                LocalDateTime timeCheckOut = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                Attendence att = new Attendence(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        timeCheckIn,
                        timeCheckOut,
                        employee
                );
                attendence.add(att);
            }
        } catch (Exception e) {
            System.out.println("Error in attendence find by month and year");
        }
        return attendence;
    }

    public Attendence findByDateAndIdEmployee(LocalDate date, int id) {
        String sql = "SELECT a.*, e.id as employeeId, e.name as employeeName\n"
                + "FROM ATTENDENCE a\n"
                + "join EMPLOYEE e on e.id=a.employeeId \n"
                + "WHERE CONVERT(DATE, timeCheckIn) = ?\n"
                + "AND employeeId = ?;";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, date.toString());
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employeeId"));
                employee.setName(rs.getString("employeeName"));
                Timestamp timestamp = rs.getTimestamp("timeCheckIn");
                LocalDateTime timeCheckIn = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                timestamp = rs.getTimestamp("timeCheckOut");
                LocalDateTime timeCheckOut = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                return new Attendence(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        timeCheckIn,
                        timeCheckOut,
                        employee
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Attendence> findTop5ByEmployeeId(int id) {
        List<Attendence> attendence = new ArrayList<>();
        String sql = "SELECT TOP 5 a.*, e.id as employeeId, e.name as employeeName FROM ATTENDENCE a "
                + "join EMPLOYEE e on e.id=a.employeeId "
                + "where e.id=? "
                + "order by a.timeCheckIn desc";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employeeId"));
                employee.setName(rs.getString("employeeName"));
                Timestamp timestamp = rs.getTimestamp("timeCheckIn");
                LocalDateTime timeCheckIn = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                timestamp = rs.getTimestamp("timeCheckOut");
                LocalDateTime timeCheckOut = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                Attendence att = new Attendence(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        timeCheckIn,
                        timeCheckOut,
                        employee
                );
                attendence.add(att);
            }
        } catch (Exception e) {
            System.out.println("Error in attendence find top 5");
        }
        return attendence;
    }

    public List<Attendence> findTop10() {
        List<Attendence> attendence = new ArrayList<>();
        String sql = "SELECT TOP 10 a.*, e.id as employeeId, e.name as employeeName FROM ATTENDENCE a "
                + "join EMPLOYEE e on e.id=a.employeeId "
                + "order by a.timeCheckIn desc";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employeeId"));
                employee.setName(rs.getString("employeeName"));
                Timestamp timestamp = rs.getTimestamp("timeCheckIn");
                LocalDateTime timeCheckIn = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                timestamp = rs.getTimestamp("timeCheckOut");
                LocalDateTime timeCheckOut = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                Attendence att = new Attendence(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        timeCheckIn,
                        timeCheckOut,
                        employee
                );
                attendence.add(att);
            }
        } catch (Exception e) {
            System.out.println("Error in attendence find top 10");
        }
        return attendence;
    }

    @Override
    public int insert(Attendence entity) {
        String sql = "INSERT INTO ATTENDENCE( totalTime, timeCheckIn, timeCheckOut, employeeId )"
                + "VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (int) entity.getTotalTime());
            ps.setObject(2, entity.getTimeCheckIn() != null ? Timestamp.valueOf(entity.getTimeCheckIn()) : null);
            ps.setObject(3, entity.getTimeCheckOut() != null ? Timestamp.valueOf(entity.getTimeCheckOut()) : null);
            ps.setInt(4, entity.getEmployee().getId());
            int rs = ps.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return 0;
    }

    @Override
    public List<Attendence> findAll() {
        List<Attendence> attendence = new ArrayList<>();
        String sql = "SELECT a.*, e.id as employeeId, e.name as employeeName FROM ATTENDENCE a "
                + "join EMPLOYEE e on e.id=a.employeeId";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employeeId"));
                employee.setName(rs.getString("employeeName"));
                Timestamp timestamp = rs.getTimestamp("timeCheckIn");
                LocalDateTime timeCheckIn = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                timestamp = rs.getTimestamp("timeCheckOut");
                LocalDateTime timeCheckOut = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                Attendence att = new Attendence(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        timeCheckIn,
                        timeCheckOut,
                        employee
                );
                attendence.add(att);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attendence;
    }

    @Override
    public Attendence findByID(Integer id) {
        String sql = "SELECT a.*, e.id as employeeId, e.name as employeeName FROM ATTENDENCE "
                + "join EMPLOYEE e on e.id=a.employeeId"
                + "WHERE id = ? ";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("employeeId"));
                employee.setName(rs.getString("employeeName"));
                return new Attendence(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        rs.getObject("timeCheckIn", LocalDateTime.class),
                        rs.getObject("timeCheckOut", LocalDateTime.class),
                        employee
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Attendence entity) {
        String sql = "UPDATE ATTENDENCE SET "
                + "totalTime = ?, "
                + "timeCheckIn = ?, "
                + "timeCheckOut = ?,"
                + "employeeId = ? "
                + "WHERE CONVERT(DATE, timeCheckIn) = ?\n"
                + "AND employeeId = ?;";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (int) entity.getTotalTime());
            ps.setObject(2, entity.getTimeCheckIn() != null ? Timestamp.valueOf(entity.getTimeCheckIn()) : null);
            ps.setObject(3, entity.getTimeCheckOut() != null ? Timestamp.valueOf(entity.getTimeCheckOut()) : null);
            ps.setInt(4, entity.getEmployee().getId());
            ps.setString(5, entity.getTimeCheckIn().toLocalDate().toString());
            ps.setInt(6, entity.getEmployee().getId());
            int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM ATTENDENCE WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean deleteByEmployeeId(Integer id) {
        String sql = "DELETE FROM ATTENDENCE WHERE employeeId = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
