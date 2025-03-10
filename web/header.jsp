<%-- 
    Document   : header
    Created on : Mar 2, 2025, 9:42:05 PM
    Author     : ADMIN
--%>

<%@page import="dto.EmployeeDTO"%>
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



            </style>
        </head>
        <body>
            <%

                EmployeeDTO e = (EmployeeDTO) request.getSession().getAttribute("employeeDTO");
            %>
            <header class="header">
                <h4>Danh Sách Nhân Viên</h4>
                <div class="profile">
                    <a href="profile?id=<%=e.getId()%>">My Profile</a>
                    <img src="uploads/<%=e.getImg()%>" alt="Profile Picture">
                    <form action="logout" method="get" class="ms-3">
                        <button type="submit" class="btn btn-danger btn-sm">Logout</button>
                    </form>
                </div>
            </header>


        </body>
    </html>
