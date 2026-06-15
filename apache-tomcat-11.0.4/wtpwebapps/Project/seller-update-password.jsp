<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	%>
<%String msg = (String) request.getAttribute("msg");
if(msg!=null){%>
<h2>
<%out.print(msg);%></h2><%} %>
<%
						String email = (String) request.getAttribute("email");
						%>

<div class="container-fluid py-5">
        <div class="container py-5">
            <div class="mx-auto text-center wow fadeIn" data-wow-delay="0.1s" style="max-width: 500px;">
                <div class="btn btn-sm border rounded-pill text-primary px-3 mb-3">Update New Password Setup</div>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="wow fadeIn" data-wow-delay="0.3s">
                        <form action="seller" method="post">
							<input type="hidden" name="email" value="<%=email%>">	
                            <div class="row g-3">
                                
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="password" class="form-control" name="np" id="new password" placeholder="new password">
                                        <label for="email">New Password</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="password" class="form-control" name="cnp" id="confirm new password" placeholder="confirm new password">
                                        <label for="email">Confirm New Password</label>
                                    </div>
                                </div>
                              
                                <div class="col-6">
                                    <button class="btn btn-primary w-100 py-3" name = "action" value = "up" type="submit">Update Password</button>
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