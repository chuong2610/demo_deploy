<%-- 
    Document   : register
    Created on : Mar 2, 2025, 10:04:07 PM
    Author     : ADMIN
--%>

<%@page import="model.Employee"%>
<%@page import="dto.RoleDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng Ký - Quán Cà Phê</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                background: #eceff1;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }
            .register-container {
                background: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                width: 500px;
            }
            .register-container h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #37474f;
            }
            .btn-custom {
                background: #6f4e37;
                color: white;
            }
            .btn-custom:hover {
                background: #5a3d2b;
            }
        </style>
    </head>
    <body>
        <div class="register-container">
            <h2>Đăng Ký</h2>
            <%
                List<RoleDTO> roleDTOs = (List<RoleDTO>) request.getAttribute("roleDTOs");
                Employee e = (Employee) request.getAttribute("employee");
            %>

            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <form>
                <input type="hidden" name="acction" value="register">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name" class="form-label">Họ và Tên</label>
                        <input type="text" name="name" class="form-control" id="name" value="${employee.name}" placeholder="Nhập họ và tên" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="birthday" class="form-label">Ngày sinh</label>
                        <input type="date" name="birthday" class="form-control" id="birthday" required value="${employee.date}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="phoneNumber" class="form-label">Số điện thoại</label>
                        <input type="tel" name="phone" class="form-control" id="phoneNumber" placeholder="Nhập số điện thoại" required value="${employee.phone}">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" id="email" placeholder="Nhập email" required value="${employee.email}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="gender" class="form-label">Giới tính</label>
                        <select name="gender" class="form-select" id="gender" required>
                            <option value="">Chọn giới tính</option>
                            <option value="nam">Nam</option>
                            <option value="nữ">Nữ</option>
                            <option value="other">Khác</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="userName" class="form-label">Tên đăng nhập</label>
                        <input type="text" name="userName" class="form-control" id="userName" placeholder="Nhập tên đăng nhập" required value="${employee.userName}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="password" class="form-label">Mật khẩu</label>
                        <input type="password" name="password" class="form-control" id="password" placeholder="Nhập mật khẩu" required value="${employee.password}">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="confirm-password" class="form-label">Xác nhận Mật khẩu</label>
                        <input type="password" name="confirm-password" class="form-control" id="confirm-password" placeholder="Nhập lại mật khẩu" required value="${employee.password}">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Vai trò</label>
                    <select class="form-select" id="role" required>
                        <option value="">Chọn Role</option>
                        <%
                            for (RoleDTO rdto : roleDTOs) {
                        %>

                        <option value="<%=rdto.getId()%>"><%=rdto.getName()%></option>
                        <%}%>
                    </select>
                </div>
                <button type="submit" class="btn btn-custom w-100">Đăng Ký</button>
            </form>

            <p class="text-center mt-3">Đã có tài khoản? <a href="login.html">Đăng nhập</a></p>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
