<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	<h2>
		<%
		out.print(msg);
		%>
	</h2>
	<%
	}
	%>
<div class="container-fluid py-5">
        <div class="container py-5">
            <div class="mx-auto text-center wow fadeIn" data-wow-delay="0.1s" style="max-width: 500px;">
                <div class="btn btn-sm border rounded-pill text-primary px-3 mb-3">Customer Register</div>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="wow fadeIn" data-wow-delay="0.3s">
                        <form action="customer" method="post">
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" name="name" id="email" placeholder="Name">
                                        <label for="email">Name</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                                        <label for="email">Email</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" name="password" id="email" placeholder="Password">
                                        <label for="email">Password</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" name="address" id="email" placeholder="Address">
                                        <label for="email">Address</label>
                                    </div>
                                </div>
                                
                                <div class="col-6">
                                    <div class="form-floating">
                                         <input type="text" class="form-control" name="contact" id="email" placeholder="Contact">
                                        <label for="email">Contact</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <button class="btn btn-primary w-100 py-3" name = "action" value = "register" type="submit">Customer Register</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>