<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart Cleared</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 80px auto; text-align: center; }
        h1 { color: #2e7d32; }
        a { display: inline-block; margin-top: 20px; padding: 10px 18px; background: #5cb85c;
            color: white; text-decoration: none; border-radius: 4px; }
    </style>
</head>
<body>
    <h1>✅ Your cart has been cleared</h1>
    <p>Your session was ended and all cart items were removed.</p>
    <a href="<%= request.getContextPath() %>/cart">Start a New Cart</a>
</body>
</html>
