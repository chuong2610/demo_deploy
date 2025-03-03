<%-- 
    Document   : chamcong
    Created on : Feb 25, 2025, 10:56:41 PM
    Author     : ADMIN
--%>

<%@page import="dto.AttendenceDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chấm Công - Quán Cà Phê</title>
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

        .wrapper {
            display: flex;
            flex-grow: 1;
            margin-left: 280px; /* Đẩy nội dung sang phải cho vừa với thanh điều hướng */
        }
        .table-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
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
        <h4>Chấm Công</h4>
        <div class="profile">
            <a href="#">My Profile</a>
            <img src="https://via.placeholder.com/40" alt="Profile Picture">
        </div>
    </div>

    <div class="wrapper">
        <div class="content">
            <h2 class="mb-3">Danh Sách Nhân Viên</h2>
            <div class="table-container">
                <table class="table table-bordered text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Tên Nhân Viên</th>
                            <th>Vị Trí</th>
                            <th>Chấm Công</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                             List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) request.getAttribute("employeeDTOs");
                             for(EmployeeDTO edto : employeeDTOs){
                        %>
                        <tr>
                            <td><%= edto.getName() %></td>
                            <td><%= edto.getRoleDTO().getName()%></td>
                            <td><a href="chamcongchitiet?id=<%=edto.getId()%>" class="btn btn-primary">Chấm Công</a></td>
                        </tr>
                       
                        
                        <%}%>
                    </tbody>
                </table>
            </div>

            <div class="table-container">
                <h4 class="mt-4">Bảng Chấm Công</h4>
                <table class="table table-bordered text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Ngày</th>
                            <th>Tên Nhân Viên</th>
                            <th>Giờ Check-in</th>
                            <th>Giờ Check-out</th>
                            <th>Trạng Thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<AttendenceDTO> attendenceDTOs = (List<AttendenceDTO>) request.getAttribute("attendenceDTOs");
                            int lastDay = 0;
                            String date=null;
                            for(AttendenceDTO adto : attendenceDTOs){
                                if(lastDay!=adto.getTimeCheckIn().getDayOfMonth()){
                                    lastDay=adto.getTimeCheckIn().getDayOfMonth();
                                    date=adto.getTimeCheckIn().getDayOfMonth()+"/"+adto.getTimeCheckIn().getMonthValue()+"/"+adto.getTimeCheckIn().getYear();
                        %>            
                            <tr>
                                <td colspan="5" class="table-secondary text-center fw-bold"><%=date%></td>
                            </tr>
                        <%            
                                }    
                            
                        %>
                        
                            
                        
                        <tr>
                            <td><%=date%></td>
                            <td><%= adto.getEmployeeDTO().getName() %></td>
                            <td><%=adto.getTimeCheckIn().getHour()%>:<%=adto.getTimeCheckIn().getMinute()%></td>
                            <td><%=adto.getTimeCheckOut().getHour()%>:<%=adto.getTimeCheckOut().getMinute()%></td>
                            <td><%=adto.getStatus()%></td>
                        </tr>
                        
                        
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="footer">
        <p>&copy; 2025 Quán Cà Phê. All rights reserved.</p>
    </div>

</body>
</html>
