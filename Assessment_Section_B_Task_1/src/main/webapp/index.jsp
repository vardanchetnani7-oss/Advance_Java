<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Cart App</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 80px auto; text-align: center; }
        a { display: inline-block; margin-top: 20px; padding: 10px 18px; background: #337ab7;
            color: white; text-decoration: none; border-radius: 4px; }
    </style>
</head>
<body>
    <h1>Welcome to the Food Cart App</h1>
    <p>Click below to view your cart and start adding items.</p>
    <a href="<%= request.getContextPath() %>/cart">Go to Cart</a>
</body>
</html>
