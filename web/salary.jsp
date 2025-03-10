<%-- 
    Document   : danhsachEmpyee
    Created on : Feb 25, 2025, 10:06:30 PM
    Author     : ADMIN
--%>

<%@page import="dto.SalaryDTO"%>
<%@page import="dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Danh Sách Nhân Viên - Quán Cà Phê</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            * {
                box-sizing: border-box;
            }
            body {
                font-family: 'Poppins', sans-serif;
                background: #eceff1;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                margin: 0;
            }
            .sidebar {
                width: 280px;
                height: 100vh;
                background: #37474f;
                color: white;
                position: fixed;
                padding: 30px 20px;
            }
            .sidebar h3 {
                text-align: center;
                font-weight: bold;
                margin-bottom: 20px;
            }
            .sidebar a {
                color: white;
                text-decoration: none;
                display: block;
                padding: 12px 20px;
                font-size: 16px;
                border-radius: 8px;
                margin: 8px 0;
                transition: 0.3s;
            }
            .sidebar a:hover {
                background: #546e7a;
            }
            .header {
                position: fixed;
                width: calc(100% - 280px);
                height: 70px;
                left: 280px;
                background: #263238;
                color: white;
                display: flex;
                align-items: center;
                justify-content: space-between;
                padding: 0 20px;
            }
            .profile {
                display: flex;
                align-items: center;
            }

            .profile a {
                color: white;
                text-decoration: none;
                margin-right: 10px;
            }

            .profile img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
            }
            .content {
                margin-left: 280px;
                padding: 90px 30px;
            }
            .footer {
                margin-left: 280px;
                background: #37474f;
                color: white;
                text-align: center;
                padding: 15px 0;
                margin-top: auto;
            }



        </style>
    </head>
    <body>
        <jsp:include page="sidebar.jsp"/>

        <jsp:include page="header.jsp"/>



        <div class="content">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h2>Lương nhân viên</h2>
            </div>

            <!-- Section danh sách nhân viên -->
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Tên</th>
                        <th>Vị trí</th>
                        <th>Email</th>
                        <th>Điện thoại</th>
                        <th>Tổng lương</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<SalaryDTO> sdtos = (List<SalaryDTO>) request.getAttribute("salaryDTOs");
                        int lastMonth = 0;
                        String date = null;

                        for (SalaryDTO s : sdtos) {
                            if (lastMonth != s.getMonth()) {
                                lastMonth = s.getMonth();
                                date = s.getMonth() + "/" + s.getYear();

                    %>
                    <tr>
                        <td colspan="5" class="table-secondary text-center fw-bold"><%=date%></td>
                    </tr>
                    <%
                        }

                    %>
                    <tr>
                        <td><a href="profile?id=<%=s.getEmployeeDTO().getId()%>" style="text-decoration: none; color: black;"><%= s.getEmployeeDTO().getName()%></a></td>
                        <td><%= s.getEmployeeDTO().getRoleDTO().getName()%></td>
                        <td><%= s.getEmployeeDTO().getEmail()%></td>
                        <td><%= s.getEmployeeDTO().getPhone()%></td>
                        <td><%= s.getTotalSalary()%></td>
                    </tr>
                    <%
                        }%>

                </tbody>
            </table>
        </div>

        <%@ include file="footer.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
