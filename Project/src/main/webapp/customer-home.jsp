<%@page import="models.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@include file="customer-header.jsp"%>
<%
    List<Product> list = ProductDao.getallProducts();
%>

<div class="container mt-4 d-flex justify-content-center">
    <table class="table table-bordered table-hover align-middle" style="width:90%; max-width:950px;">
        <thead class="table-secondary">
            <tr>
                <th>Sr.No</th>
                <th>Image</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% int count = 1;
               for (Product p : list) { %>
            <tr>
                <td><%=count++%></td>
                <td><img src="pimages/<%=p.getPimage()%>" width="240" height="120" style="object-fit:cover;"></td>
                <td><%=p.getPname()%></td>
                <td>Rs:<%=p.getPprice()%></td>
                <td><%=p.getPcategory()%></td>
                <td>
                   <form action="cartcontroller" method="post">
    <input type="hidden" name="action" value="addtocart">
    <input type="hidden" name="pid" value="<%=p.getPid()%>">
    <input type="hidden" name="cusid" value="<%=c.getId()%>">
    <button type="submit" class="btn btn-success btn-sm">
        <i class="bi bi-cart-plus"></i> Add to Cart
    </button>
</form>
                </td>
            </tr>
            <% } %>
        </tbody>
        <tfoot>
            <tr class="table-secondary">
                <td colspan="6" class="text-end text-muted">
                    Total: <strong><%=list.size()%></strong> Products
                </td>
            </tr>
        </tfoot>
    </table>
</div>