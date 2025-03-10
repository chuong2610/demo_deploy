/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmployeeDAO;
import dao.RoleDAO;
import dto.EmployeeDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Employee;
import service.EmployeeService;
import service.RoleService;

/**
 *
 * @author ADMIN
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    RoleService roleService = new RoleService();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    RoleDAO roleDAO = new RoleDAO();

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
            if (!employeeDTO.getRoleDTO().getName().equals("Quản lý")) {

                PrintWriter out = response.getWriter();
                out.println("<script>alert('Bạn không có quyền truy cập!'); window.location.href='index';</script>");
            } else {
                String action = request.getParameter("action");
                request.setAttribute("roleDTOs", roleService.findAll());
                String idParam = request.getParameter("id");
                int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;
                System.out.println(id);
                if (action == null) {

                    if (id != 0) {
                        Employee e = employeeDAO.findByID(id);
                        request.setAttribute("employee", e);
                    }
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    String name = request.getParameter("name");
                    LocalDate date = LocalDate.parse(request.getParameter("birthday"));
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String gender = request.getParameter("gender");
                    String userName = request.getParameter("userName");
                    String password = request.getParameter("password");
                    String confirmPassword = request.getParameter("confirm-password");
                    int roleId = Integer.parseInt(request.getParameter("role"));

                    Part filePart = request.getPart("avatar"); // Lấy file từ form
                    long fileSize = filePart.getSize();
                    String fileName = "";
                    if (fileSize == 0) {
                        fileName = "default.jpg";
                    } else {
                        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Lấy tên file
                        String uploadPath = getServletContext().getRealPath("/") + "uploads"; // Thư mục lưu file
                        File uploadDir = new File(uploadPath);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdir(); // Tạo thư mục nếu chưa có
                        }
                        String filePath = uploadPath + File.separator + fileName;
                        filePart.write(filePath); // Lưu file vào thư mục
                    }

                    Employee e = new Employee(id, name, phone, email, date, userName, password, roleDAO.findByID(roleId), fileName);

                    if (id == 0) {
                        int i = employeeDAO.insert(e);
                        if (i != 0) {
                            PrintWriter out = response.getWriter();
                            out.println("<script>alert('đăng ký thành công!'); window.location.href='index';</script>");
                        } else {
                            PrintWriter out = response.getWriter();
                            out.println("<script>alert('đăng ký thất bại!'); window.location.href='index';</script>");
                        }
                    } else {
                        boolean i = employeeDAO.update(e);
                        if (i) {
                            PrintWriter out = response.getWriter();
                            out.println("<script>alert('cập nhật thành công!'); window.location.href='index';</script>");
                        } else {
                            PrintWriter out = response.getWriter();
                            out.println("<script>alert('cập nhật thất bại!'); window.location.href='index';</script>");
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
