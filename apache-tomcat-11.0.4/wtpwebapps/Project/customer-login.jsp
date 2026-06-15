<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
 <%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<div class="container-fluid py-5">
        <div class="container py-5">
            <div class="mx-auto text-center wow fadeIn" data-wow-delay="0.1s" style="max-width: 500px;">
                <div class="btn btn-sm border rounded-pill text-primary px-3 mb-3">Customer Login</div>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="wow fadeIn" data-wow-delay="0.3s">
                    <form>
    <div class="row g-3 justify-content-center">

        <!-- Email Field -->
        <div class="col-6">
            <div class="form-floating">
                <input type="email" class="form-control" id="email" placeholder="Your Email">
                <label for="email">Your Email</label>
            </div>
        </div>

        <!-- Password Field -->
        <div class="col-6">
            <div class="form-floating">
                <input type="password" class="form-control" id="password" placeholder="Password">
                <label for="password">Password</label>
            </div>
        </div>

        <!-- Button Centered -->
        <div class="col-auto">
            <button class="btn btn-primary px-4 py-2" type="submit">Customer Login</button>
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