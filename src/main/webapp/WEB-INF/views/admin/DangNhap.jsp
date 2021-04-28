<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Administrator</title>
      <jsp:include page="/WEB-INF/views/admin/layout/css.jsp"></jsp:include>
     <jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
</head>
   
</head>

<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <!-- Login Form s-->
                <form action="/perform_login" method="post" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="login-form">
                        <h4 class="login-title">Please Sign in</h4>
                        <c:if test="${not empty param.login_error}">
							<div class="alert alert-danger" role="alert">
							  Đăng nhập không thành công, vui lòng thử lại!!!
							</div>
						</c:if>
                        <div class="row">
                            <div class="col-md-12 col-12 mb-20">
                                <br>    
                                <input class="mb-0" name="username" type="email" placeholder="email">
                            </div>
                            <div class="col-12 mb-20">
                                <br>
                                <input class="mb-0" name="password" type="password" placeholder="Mật khẩu">
                            </div>
                             <label style="color: red">${errorlogin}</label>
                            <div class="col-md-8">
                                <div class="check-box d-inline-block ml-0 ml-md-2 mt-10">
                                    <br>
                                    <input type="checkbox" id="remember_me">
                                    <label for="remember_me">Nhớ mật khẩu</label>
                                    <br>
                                </div>
                            </div>
                                <button type="submit" class="col-md-12 btn btn-success">Đăng nhập</button>
                               <br>                            
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>
    
</head>
</body>

</html>
