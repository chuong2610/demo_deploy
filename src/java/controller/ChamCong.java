/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.AttendenceDTO;
import dto.EmployeeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AttendenceService;
import service.EmployeeService;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ChamCong", urlPatterns = {"/chamcong", "/chamcongchitiet"})
public class ChamCong extends HttpServlet {

    AttendenceService attendeceService = new AttendenceService();
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
                case "/chamcong":
                    if (!employeeDTO.getRoleDTO().getName().equals("Quản lý")) {
                        PrintWriter out = response.getWriter();
                        out.println("<script>alert('Bạn không có quyền truy cập!'); window.location.href='index';</script>");
                    } else {
                        List<AttendenceDTO> attendenceDTOs = attendeceService.findTop10();
                        request.setAttribute("attendenceDTOs", attendenceDTOs);
                        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
                        employeeDTOs = employeeService.findAll();
                        request.setAttribute("employeeDTOs", employeeDTOs);
                        request.getRequestDispatcher("chamcong.jsp").forward(request, response);

                    }
                    break;
                case "/chamcongchitiet":
                    String action = request.getParameter("action");
                    if (action == null) {
                        if (!employeeDTO.getRoleDTO().getName().equals("Quản lý")) {
                            PrintWriter out = response.getWriter();
                            out.println("<script>alert('Bạn không có quyền truy cập!'); window.location.href='index';</script>");
                        } else {
                            int employeeId = Integer.parseInt(request.getParameter("id"));
                            EmployeeDTO edto = employeeService.findById(employeeId);
                            request.setAttribute("employeeDTO", edto);
                            request.getRequestDispatcher("chamcongChitiet.jsp").forward(request, response);
                        }
                    } else if (action.equals("chamcong")) {
                        EmployeeDTO edto = new EmployeeDTO();
                        int id = Integer.parseInt(request.getParameter("id"));
                        edto.setId(id);

                        String dateStr = request.getParameter("date");
                        String timCheckInStr = request.getParameter("timeCheckIn");
                        String timeCheckOutStr = request.getParameter("timeCheckOut");
                        
                        LocalDate localDate = LocalDate.parse(dateStr);
                        LocalTime localTimeCheckIn = timCheckInStr != null && !timCheckInStr.isEmpty() ? LocalTime.parse(timCheckInStr) : null;
                        LocalTime localTimeCheckOut = timeCheckOutStr != null && !timeCheckOutStr.isEmpty() ? LocalTime.parse(timeCheckOutStr) : null;

                        LocalDateTime timeCheckIn =localTimeCheckIn!=null? LocalDateTime.of(localDate, localTimeCheckIn):null;
                        LocalDateTime timeCheckOut =localTimeCheckOut!=null? LocalDateTime.of(localDate, localTimeCheckOut):null;
                        
                        
                        AttendenceDTO adto = new AttendenceDTO();
                        adto.setTimeCheckIn(timeCheckIn);
                        adto.setTimeCheckOut(timeCheckOut);
                        adto.setEmployeeDTO(edto);

                        if (attendeceService.findByDateAndIdEmployee(localDate, id) != null) {
                            

                            boolean i = attendeceService.update(adto);
                            if (i) {
                                PrintWriter out = response.getWriter();
                                out.println("<script>alert('Cập nhật chấm công thành công!'); window.location.href='index';</script>");
                            } else {
                                PrintWriter out = response.getWriter();
                                out.println("<script>alert('Cập nhật chấm công thất bại!'); window.location.href='index';</script>");
                            }
                        } else {
                            if (localTimeCheckOut != null) {               
                                if (timeCheckIn == null) {
                                    PrintWriter out = response.getWriter();
                                    out.println("<script>alert('Bạn chưa check in, không thể check out!'); window.location.href='index';</script>");
                                    return;
                                }                               
                            }
                            if(localTimeCheckOut!=null)
                                adto.setTotalTime(Duration.between(localTimeCheckIn, localTimeCheckOut).toMinutes()/60);
                            int i = attendeceService.insert(adto);
                            if (i != 0) {
                                PrintWriter out = response.getWriter();
                                out.println("<script>alert('Chấm công thành công!'); window.location.href='index';</script>");
                            } else {
                                PrintWriter out = response.getWriter();
                                out.println("<script>alert('Chấm công thất bại!'); window.location.href='index';</script>");
                            }
                        }

                    }

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
