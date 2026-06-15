<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	<h2 class="mb-4 section-title">
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
                <div class="btn btn-sm border rounded-pill text-primary px-3 mb-3">Seller Login</div>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="wow fadeIn" data-wow-delay="0.3s">
                    <form action="seller" method="post">
    <div class="row g-3 justify-content-center">

        <!-- Email Field -->
        <div class="col-6">
            <div class="form-floating">
                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                <label for="email">Email</label>
            </div>
        </div>

        

        <!-- Button Centered -->
        <div class="col-auto">
            <button class="btn btn-primary px-4 py-2" type="submit" name="action" value="sendotp">Send OTP</button>
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