<%-- 
    Document   : sidebar
    Created on : Mar 2, 2025, 9:42:14 PM
    Author     : ADMIN
--%>

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
        

       
    </style>
</head>
<body>
    <div class="sidebar">
        <h3 class="text-center">☕ Nhà Meo Coffee</h3>
        <a href="employees">📋 Quản Lý Nhân Viên</a>
        <a href="chamcong">⏱ Chấm Công & Lịch Làm</a>
        <a href="salary">💰 Tính Lương</a>
        <a href="#">📊 Báo Cáo</a>
        <a href="#">⚙️ Cài Đặt</a>
    </div>
    
   
</body>
</html>
