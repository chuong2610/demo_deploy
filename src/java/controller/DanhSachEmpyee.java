/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.EmployeeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.EmployeeService;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "danhSachEmpyee", urlPatterns = {"/employees","/employees_delete"})
public class DanhSachEmpyee extends HttpServlet {

    EmployeeService employeeService = new EmployeeService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        EmployeeDTO employeeDTO = (EmployeeDTO) session.getAttribute("employeeDTO");
        if (employeeDTO == null) {
            response.sendRedirect("login");
            return;
        } else {
            String path = request.getServletPath();
            switch (path) {
                case "/employees":
                    if (!employeeDTO.getRoleDTO().getName().equals("Quản lý")) {
                       
                        PrintWriter out = response.getWriter();
                        out.println("<script>alert('Bạn không có quyền truy cập!'); window.location.href='index';</script>");
                        
                    } else {
                        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
                        employeeDTOs = employeeService.findAll();
                        request.setAttribute("employeeDTOs", employeeDTOs);
                        request.getRequestDispatcher("danhsachEmployee.jsp").forward(request, response);
                    }
                    break;
                    
                case "/employees_edit":
                    
                    
                    break;
                case "/employees_delete":
                    int id =Integer.parseInt(request.getParameter("id")) ;
                    employeeService.delete(id);
                    response.sendRedirect("employees");
                    break;
                    
                    
                    
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
