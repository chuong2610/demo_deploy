/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Salary;
import ultils.DBUltils;

/**
 *
 * @author ADMIN
 */
public class SalaryDAO implements IDAO<Salary, Integer>{
    
    
    
    public Salary findByMonthAndEmployeeId(YearMonth month, int id){
        String sql = "SELECT * FROM SALARY WHERE month=? and year = ? and employeeId=?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, month.getMonthValue());
            ps.setInt(2, month.getYear());
            ps.setInt(3, id);
            ResultSet rs = ps.executeQuery();
            Salary s= new Salary();
            while(rs.next()){
                 Employee e = new Employee();
                e.setId(rs.getInt("employeeId"));
                e.setName(rs.getString("employeeName"));
                Salary sl = new Salary(
                        rs.getInt("id"),
                        rs.getInt("totalSalary"),
                        rs.getInt("month"),
                        rs.getInt("year"),
                        e
                );
            }
            return s;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int insert(Salary entity) {
        String sql = "INSERT INTO SALARY ( totalSalary, month, year, employeeId)" + "VALUES ( ?, ?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getTotalSalary());
            ps.setInt(2, entity.getMonth());
            ps.setInt(3, entity.getYear());
            ps.setInt(4, entity.getEmployee().getId());
            int rs=ps.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return 0;
    }

    @Override
    public List<Salary> findAll() {
      List<Salary> salarys = new ArrayList<>();
      String sql = "SELECT  s.*, e.id as employeeId, e.name as employeeName FROM SALARY s "
                + "join EMPLOYEE e on e.id=s.employeeId "
                + "ORDER BY year DESC, month DESC";
            
      try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("employeeId"));
                e.setName(rs.getString("employeeName"));
                Salary sl = new Salary(
                        rs.getInt("id"),
                        rs.getInt("totalSalary"),
                        rs.getInt("month"),
                        rs.getInt("year"),
                        e
                );
                salarys.add(sl);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return salarys;
    }

    @Override
    public Salary findByID(Integer id) {
        String sql = "SELECT * FROM SALARY WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 rs.getInt("id");
                 rs.getInt("totalSalary");
                 rs.getInt("month");
                 rs.getInt("year");
                 rs.getInt("employeeId");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Salary entity) {
      String sql = "UPDATE SALARY SET"
                + "totalSalary = ?, "
                + "month = ?, "
                + "year = ?,"
                + "employeeId = ?,"
                + "WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getTotalSalary());
            ps.setInt(2, entity.getMonth());
            ps.setInt(3, entity.getYear());
            ps.setInt(4, entity.getEmployee().getId());
            ps.setInt(5, entity.getId());
             int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM SALARY WHERE id = ?";
         try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
     public boolean deleteByEmployeeId(Integer id) {
        String sql = "DELETE FROM SALARY WHERE employeeId = ?";
         try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
}
