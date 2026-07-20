<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.CartDao" %>
<%@ page import="dao.CartDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Food Cart</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 40px auto; }
        h1 { color: #333; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px 12px; text-align: left; }
        th { background-color: #f4f4f4; }
        .empty-msg { color: #777; font-style: italic; margin-top: 20px; }
        form.inline { display: inline-block; margin-right: 8px; }
        .add-form { margin-top: 20px; padding: 15px; background: #fafafa; border: 1px solid #ddd; }
        .clear-btn { background: #d9534f; color: white; border: none; padding: 8px 14px; cursor: pointer; }
        .add-btn { background: #5cb85c; color: white; border: none; padding: 8px 14px; cursor: pointer; }
        input[type=text], input[type=number] { padding: 6px; margin-right: 8px; }
    </style>
</head>
<body>

<h1>🛒 Your Food Cart</h1>

<%
    // View reads cart data through the DAO, not by touching HttpSession directly.
    CartDao cartDao = new CartDaoImpl();
    ArrayList<String> cart = cartDao.getCartItems(request);
%>

<% if (cart.isEmpty()) { %>
    <p class="empty-msg">Your cart is empty. Add something delicious below!</p>
<% } else { %>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Item</th>
            </tr>
        </thead>
        <tbody>
            <%
                int rowNum = 1;
                for (String item : cart) {
            %>
            <tr>
                <td><%= rowNum++ %></td>
                <td><%= item %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
<% } %>

<div class="add-form">
    <h3>Add an item</h3>
    <form class="inline" action="<%= request.getContextPath() %>/cart" method="post">
        <input type="hidden" name="action" value="add" />
        <input type="text" name="itemName" placeholder="Item name (e.g. Paneer Burger)" required />
        <input type="number" name="quantity" placeholder="Qty" min="1" value="1" style="width:70px;" />
        <button type="submit" class="add-btn">Add to Cart</button>
    </form>
</div>

<form action="<%= request.getContextPath() %>/cart" method="post" style="margin-top: 15px;">
    <input type="hidden" name="action" value="clear" />
    <button type="submit" class="clear-btn">Clear Cart</button>
</form>

</body>
</html>
