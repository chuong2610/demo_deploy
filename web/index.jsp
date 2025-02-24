<%-- 
    Document   : index.jsp
    Created on : Feb 23, 2025, 5:05:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Nhân Sự - Quán Cà Phê</title>
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
        .dropdown-menu {
            right: 0;
            left: auto;
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

        .stat-card {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-bottom: 20px;
        }
        .stat-card h4 {
            font-size: 1.5rem;
            font-weight: bold;
            color: #333;
        }
        .stat-card p {
            font-size: 1.2rem;
            color: #555;
        }
        .stat-card .number {
            font-size: 2rem;
            font-weight: bold;
            color: #6f4e37;
        }
        .stat-card .icon {
            font-size: 3rem;
            color: #6f4e37;
        }
        .profile {
    position: relative;
    display: flex;
    align-items: center;
}

    </style>
</head>
<body>
    <div class="sidebar">
        <h3 class="text-center">☕ Quán Cà Phê</h3>
        <a href="danhsachnhanvien.html">📋 Quản Lý Nhân Viên</a>
        <a href="chamcong.html">⏱ Chấm Công & Lịch Làm</a>
        <a href="">💰 Tính Lương</a>
        <a href="#">📊 Báo Cáo</a>
        <a href="#">⚙️ Cài Đặt</a>
    </div>
    
    <div class="header">
        <h4>Quản Lý Nhân Sự</h4>
        <div class="profile dropdown">
            <a href="#" class="dropdown-toggle" id="profileDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                My Profile
            </a>
            <img src="https://via.placeholder.com/40" alt="Profile Picture">
            <ul class="dropdown-menu" aria-labelledby="profileDropdown">
                <li><a class="dropdown-item" href="#">🔑 Đăng Nhập</a></li>
                <li><a class="dropdown-item" href="#">👤 Thông Tin Tài Khoản</a></li>
                <!-- <li><hr class="dropdown-divider"></li> -->
                <!-- <li><a class="dropdown-item" href="#">🚪 Đăng Xuất</a></li> -->
            </ul>
        </div>
    </div>
    
    <div class="content">
        <h2 class="mb-3">Chào mừng đến với hệ thống quản lý nhân sự</h2>
        <p>Chọn một chức năng từ thanh điều hướng bên trái.</p>
        
        <!-- Section thông tin nhanh -->
        <div class="image-container">
            <img src="img/470222384_122166712016327850_7637632029446358062_n_1.jpg" alt="Hình ảnh quán cà phê">
            <img src="img/470574703_122167283666327850_553815178295824727_n.jpg" alt="Hình ảnh quán cà phê khác">
        </div>
        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
            <div class="col mb-8">
                <div class="stat-card">
                    <div class="icon">👨‍💼</div>
                    <h4>Số Nhân Viên</h4>
                    <p class="number">25</p>
                </div>
            </div>
            <div class="col mb-8">
                <div class="stat-card">
                    <div class="icon">🧑‍💻</div>
                    <h4>Nhân Viên Đang Làm</h4>
                    <p class="number">10</p>
                </div>
            </div>
           
        </div>

        <!-- Section thông tin chi tiết -->
        <div class="mt-4">
            <h3>Danh Sách Nhân Viên</h3>
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Tên</th>
                        <th>Vị trí</th>
                        <th>Email</th>
                        <th>Điện thoại</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nguyễn Văn A</td>
                        <td>Quản lý</td>
                        <td>nguyenvana@gmail.com</td>
                        <td>0901234567</td>
                    </tr>
                    <tr>
                        <td>Trần Thị B</td>
                        <td>Nhân viên pha chế</td>
                        <td>thanhtib@gmail.com</td>
                        <td>0902345678</td>
                    </tr>
                    <tr>
                        <td>Lê Minh C</td>
                        <td>Phục vụ</td>
                        <td>leminhc@gmail.com</td>
                        <td>0903456789</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="footer">
        <p>&copy; 2025 Quán Cà Phê. All rights reserved.</p>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>
