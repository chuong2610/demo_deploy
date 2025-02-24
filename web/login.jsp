<%-- 
    Document   : Login
    Created on : Feb 23, 2025, 8:31:33 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập & Đăng Ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: #eceff1;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .auth-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        .auth-container h2 {
            color: #37474f;
            margin-bottom: 20px;
        }
        .btn-primary {
            background: #6f4e37;
            border: none;
        }
        .btn-primary:hover {
            background: #5a3b2c;
        }
    </style>
</head>
<body>
    <div class="auth-container">
        <h2>Đăng Nhập</h2>
        <form action="login" method="post">
            <input type="hidden" name="action" value="login">
            <div class="mb-3">
                <input type="text" name="username" class="form-control" placeholder="userName" required>
            </div>
            <div class="mb-3">
                <input type="password" name="password" class="form-control" placeholder="Mật khẩu" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
        </form>
        <% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
    <p style="color: red;"><%= error %></p>
<% } %>
        <p class="mt-3">Chưa có tài khoản? <a href="#" onclick="showRegister()">Đăng ký</a></p>
    </div>
    
   
</body>
</html>
