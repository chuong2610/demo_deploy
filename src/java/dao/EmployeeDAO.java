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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Role;
import ultils.DBUltils;

/**
 *
 * @author ADMIN
 */
public class EmployeeDAO implements IDAO<Employee,Integer> {
    
    public int numberEmployeeAttendencing(){
        String sql="SELECT COUNT(DISTINCT e.id) AS number "+
                    "FROM EMPLOYEE e "+
                    "JOIN ATTENDENCE a ON e.id = a.employeeId "+ 
                    "WHERE a.timeCheckIn IS NOT NULL "+ 
                    "AND a.timeCheckOut IS NULL;" ;
        try{
            Connection c = DBUltils.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("number");
               
            }
        }catch (Exception e){
            System.out.println("Eror get number employee arendencing");
        }
        return 0;
    }
    
    public Employee IsValidEmployee(String username, String password){
        String sql= "SELECT e.*,r.roleName as roleName FROM EMPLOYEE e "+
                    "join ROLE r on e.roleId=r.id "+
                    " WHERE e.userName=? and e.password = ? ";
                    
        try{
            Connection c = DBUltils.getConnection();
          
            PreparedStatement ps = c.prepareStatement(sql);
           
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
            
                Role role = new Role();
                role.setName(rs.getString("roleName"));
                Employee emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("userName"),
                        rs.getString("password"),
                        role);
                        
                return emp;
            }
        }catch (Exception e){
            System.out.println("Eror get eployee login");
        }
       return null;
    }

    @Override
    public Employee insert(Employee entity) {
          String sql = "INSERT INTO [quanlinhansu] (id, name, phoneNumber, email, Date, userName,password, roleId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getPhone());
            ps.setString(4, entity.getEmail());
            ps.setDate(5, Date.valueOf(entity.getDate()));
            ps.setString(6, entity.getUserName());
            ps.setString(7, entity.getPassword());
            ps.setInt(8, entity.getRole().getId());
            ps.executeUpdate();
            return entity;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }

    @Override
     public List<Employee> findAll() {
        List<Employee> employee = new ArrayList<>();
        String sql = "SELECT e.*,r.roleName FROM EMPLOYEE e "+
                    "join ROLE r on e.roleId=r.id";
         try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setName(rs.getString("roleName"));
               
                Employee emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("userName"),
                        rs.getString("password"),
                        role);
                employee.add(emp);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return employee;
    }
    

    @Override
    public Employee findByID(Integer id) {
        String sql = "SELECT e.*,r.roleName FROM EMPLOYEE e "+
                    "join ROLE r on e.roleId=r.id "+
                    " WHERE e.id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                Role role = new Role();
                role.setName(rs.getString("roleName"));
                Employee emp = new Employee(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("userName"),
                        rs.getString("password"),
                        role);
                        
                return emp;              
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Employee entity) {
         String sql = "UPDATE EMPLOYEE SET "
                + "name = ?, "
                + "phoneNumber = ?, "
                + "email = ?,"
                + "birthday = ?,"
                + "userName= ?,"
                + "password=?,"
                + "roleId= ?,"
                + "WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPhone());
            ps.setString(3, entity.getEmail());
            ps.setDate(4, Date.valueOf(entity.getDate()));
            ps.setString(5, entity.getUserName());
            ps.setString(6, entity.getPassword());
            ps.setInt(7, entity.getRole().getId());
            ps.setString(8, entity.getId());
            int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM EMPLOYEE WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}

   
    

