<%-- 
    Document   : danhsachEmpyee
    Created on : Feb 25, 2025, 10:06:30 PM
    Author     : ADMIN
--%>

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
    <div class="sidebar">
        <h3 class="text-center">☕ Nhà Meo Coffee</h3>
        <a href="#">📋 Quản Lý Nhân Viên</a>
        <a href="#">⏱ Chấm Công & Lịch Làm</a>
        <a href="#">💰 Tính Lương</a>
        <a href="#">📊 Báo Cáo</a>
        <a href="#">⚙️ Cài Đặt</a>
    </div>
    
    <div class="header">
        <h4>Danh Sách Nhân Viên</h4>
        <div class="profile">
            <a href="#">My Profile</a>
            <img src="https://via.placeholder.com/40" alt="Profile Picture">
        </div>
    </div>
    
    <div class="content">
        <h2 class="mb-3">Danh sách nhân viên</h2>
        
        <!-- Section danh sách nhân viên -->
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Tên</th>
                    <th>Vị trí</th>
                    <th>Email</th>
                    <th>Điện thoại</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% 
                     List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) request.getAttribute("employeeDTOs");
                     for(EmployeeDTO e : employeeDTOs){
                %>
                <tr>
                    <td><a href="chi-tiet-nhan-vien.html?id=1" style="text-decoration: none; color: black;"><%= e.getName() %></a></td>
                    <td><%= e.getRoleDTO().getName() %></td>
                    <td><%= e.getEmail() %></td>
                    <td><%= e.getPhone()%></td>
                    <td>
                        <a href="chi-tiet-nhan-vien.html?id=1" class="btn btn-info btn-sm">Chi tiết</a>
                        <a href="#" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="#" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
                
            </tbody>
        </table>
    </div>

    <div class="footer">
        <p>&copy; 2025 Quán Cà Phê. All rights reserved.</p>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
