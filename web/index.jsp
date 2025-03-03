<%-- 
    Document   : index.jsp
    Created on : Feb 23, 2025, 5:05:47 PM
    Author     : ADMIN
--%>

<%@page import="dto.EmployeeDTO"%>
<%@page import="dto.RoleDTO"%>
<%@page import="java.util.List"%>
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
       
        .dropdown-menu {
            right: 0;
            left: auto;
        }
        .content {
            margin-left: 280px;
            padding: 90px 30px;
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

        .image-container {
    display: flex;
    justify-content: center;
    gap: 10px; /* Khoảng cách giữa hai ảnh */
    margin-bottom: 20px;
}

.image-container img {
    width: 50%; /* Mỗi ảnh chiếm 50% chiều rộng */
    height: auto;; /* Chiều cao cố định */
    object-fit: cover; /* Giữ tỉ lệ ảnh mà không bị méo */
    border-radius: 10px; /* Bo góc ảnh */
}


    </style>
</head>
<body>
    <jsp:include page="sidebar.jsp"/>
    
   <jsp:include page="header.jsp"/>
    
    
    
    <div class="content">
        <h2 class="mb-3">Chào mừng đến với hệ thống quản lý nhân sự của Nhà Meo Coffee !!</h2>
        <p>Chọn một chức năng từ thanh điều hướng bên trái.</p>
        
        <!-- Section thông tin nhanh -->
        <div class="image-container">
            <img src="img/cu-1557.jpg" alt="Hình ảnh quán cà phê">
            <img src="img/hinh-anh-quan-cheo-veo-vao-buoi-toi-6572e0c54e93d65669330692.jpg" alt="Hình ảnh quán cà phê khác">
        </div>
        
        <%
            int number=(int) request.getAttribute("numberEmployeeAttendencing");
            List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) request.getAttribute("employeeDTOs");
            int total= employeeDTOs.size();
        %>
        
        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
            <div class="col mb-8">
                <div class="stat-card">
                    <div class="icon">👨‍💼</div>
                    <h4>Số Nhân Viên</h4>
                    <p class="number"><%= total %></p>
                </div>
            </div>
            <div class="col mb-8">
                <div class="stat-card">
                    <div class="icon">🧑‍💻</div>
                    <h4>Nhân Viên Đang Làm</h4>
                    <p class="number"><%= number %></p>
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
                    <% for(EmployeeDTO e: employeeDTOs){%>
                    <tr>
                        <td><%=e.getName()%></td>
                        <td><%=e.getRoleDTO().getName()%></td>
                        <td><%=e.getEmail()%></td>
                        <td><%=e.getPhone()%></td>
                    </tr>
                    <% }%>
                    
                </tbody>
                
            </table>
        </div>
        
        
    </div>

    <%@ include file="footer.jsp" %>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>
