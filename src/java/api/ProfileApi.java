/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import dto.SalaryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.YearMonth;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalaryService;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ProfileApi", urlPatterns = {"/profileapi"})
public class ProfileApi extends HttpServlet {

    SalaryService salaryService = new SalaryService();

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
        YearMonth month = (YearMonth) request.getAttribute("month");
        int id = Integer.parseInt(request.getParameter("id"));
        SalaryDTO salaryDTO = salaryService.findByMonthAndEmployeeId(month, id);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if (salaryDTO != null) {
            int totalSalary = salaryDTO.getTotalSalary();
            out.print("{ \"exists\": true, \"totalSalary\": \"" + totalSalary + "\" }");
        } else {
            out.print("{ \"exists\": false }");
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
