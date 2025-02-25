<%-- 
    Document   : chamcongChitiet
    Created on : Feb 25, 2025, 10:59:54 PM
    Author     : ADMIN
--%>

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
    <div class="sidebar">
        <h3 class="text-center">☕ Nhà Meo Coffee</h3>
        <a href="#">📋 Quản Lý Nhân Viên</a>
        <a href="#">⏱ Chấm Công & Lịch Làm</a>
        <a href="#">💰 Tính Lương</a>
        <a href="#">📊 Báo Cáo</a>
        <a href="#">⚙️ Cài Đặt</a>
    </div>
    <div class="header">
        <h4>Chấm Công Chi Tiết</h4>
        <div class="profile">
            <a href="#">My Profile</a>
            <img src="https://via.placeholder.com/40" alt="Profile Picture">
        </div>
    </div>
    <div class="content">
        <h2>Thông Tin Nhân Viên</h2>
        <div class="form-container">
            <h4>Nhập Thông Tin Chấm Công</h4>
            <form>
                <div class="mb-3">
                    <label class="form-label">Tên Nhân Viên</label>
                    <input type="text" class="form-control" value="Nguyễn Văn A" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ngày Chấm Công</label>
                    <input type="date" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Giờ Check-in</label>
                    <input type="time" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">Giờ Check-out</label>
                    <input type="time" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Xác Nhận Chấm Công</button>
            </form>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2025 Quán Cà Phê. All rights reserved.</p>
    </div>
</body>
</html>
