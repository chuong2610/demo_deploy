/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import dto.AttendenceDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AttendenceService;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AttendeceDetailApi", urlPatterns = {"/attendencedetailapi"})
public class AttendenceDetailApi extends HttpServlet {
    AttendenceService attendeceService = new AttendenceService();
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
         LocalDate workDate = LocalDate.parse(request.getParameter("workDate")) ;
        int id = Integer.parseInt(request.getParameter("id")); 
        AttendenceDTO adto = attendeceService.findByDateAndIdEmployee(workDate,id);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if (adto != null) {
            String checkIn = String.format("%02d:%02d", adto.getTimeCheckIn().getHour(), adto.getTimeCheckIn().getMinute());
            String checkOut = String.format("%02d:%02d", adto.getTimeCheckOut().getHour(), adto.getTimeCheckOut().getMinute());

            out.print("{ \"exists\": true, \"checkIn\": \"" + checkIn + "\", \"checkOut\": \"" + checkOut + "\" }");
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
