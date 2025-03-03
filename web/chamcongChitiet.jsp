<%-- 
    Document   : chamcongChitiet
    Created on : Feb 25, 2025, 10:59:54 PM
    Author     : ADMIN
--%>

<%@page import="dto.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chấm Công Chi Tiết - Quán Cà Phê</title>
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
        <h2>Thông Tin Nhân Viên</h2>
        <div class="form-container">
            <h4>Nhập Thông Tin Chấm Công</h4>
            
            <%
                EmployeeDTO employeeDTO=(EmployeeDTO) request.getAttribute("employeeDTO");
            %>
            
            <form action="chamcongchitiet" method="post">
                <input type="hidden" name="action" value="chamcong">
                <input type="hidden" id="id" name="id" value="<%=employeeDTO.getId()%>">
                <div class="mb-3">
                    <label class="form-label">Tên nhân viên</label>
                    <input type="text" class="form-control" value="<%=employeeDTO.getName()%>" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ngày Chấm Công</label>
                    <input type="date"  id="workDate" class="form-control workDate" name="date">
                </div>
                <div class="mb-3">
                    <label class="form-label">Giờ Check-in</label>
                    <input type="time" id="checkIn" class="form-control"name="timeCheckIn">
                </div>
                <div class="mb-3">
                    <label class="form-label">Giờ Check-out</label>
                    <input type="time" id="checkOut" class="form-control" name="timeCheckOut">
                </div>
                <button type="submit" class="btn btn-primary">Xác Nhận Chấm Công</button>
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
                <script src="js/attendence.js"></script>
</body>
</html>
