<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f2f4f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .success-box {
            background: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            width: 360px;
            text-align: center;
        }
        .success-box h2 {
            color: #2e7d32;
        }
        .success-box p {
            color: #555;
            font-size: 15px;
        }
        a.logout {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4a6cf7;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        a.logout:hover {
            background-color: #3a5be0;
        }
    </style>
</head>
<body>
    <div class="success-box">
        <h2>&#10003; Login Successful</h2>
        <p>Welcome, <strong><%= request.getAttribute("username") %></strong>!</p>
        <p>You have successfully logged in.</p>
        <a class="logout" href="<%= request.getContextPath() %>/logout">Log Out</a>
    </div>
</body>
</html>
