<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="seller-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<div class="container-fluid py-5">
        <div class="container py-5">
            <div class="mx-auto text-center wow fadeIn" data-wow-delay="0.1s" style="max-width: 500px;">
                <div class="btn btn-sm border rounded-pill text-primary px-3 mb-3">Seller Profile</div>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="wow fadeIn" data-wow-delay="0.3s">
                        <form action="seller" method="post">
                        <input type="hidden" name="id" value="<%=s.getId()%>"
								class="form-control" id="email">
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" name="name" id="name" placeholder="Name" value = "<%=s.getName()%>">
                                        <label for="email">Name</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Email"  value = "<%=s.getEmail()%>">
                                        <label for="email">Email</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" name="address" id="address" placeholder="Address" value = "<%=s.getAddress()%>">
                                        <label for="email">Address</label>
                                    </div>
                                </div>
                                
                                <div class="col-6">
                                    <div class="form-floating">
                                         <input type="text" class="form-control" name="contact" id="contact" placeholder="Contact" value = "<%=s.getContact()%>">
                                        <label for="email">Contact</label>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <button class="btn btn-primary w-100 py-3" name = "action" value = "update" type="submit">Update</button>
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