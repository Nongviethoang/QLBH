<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- login-register31:27-->
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Đăng kí</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
    </head>
    <body>
    
        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
             <div class="page-section mb-60">
                <div class="container">
                    <div class="row justify-content-center">
                       <div class="col-md-6 mt-5">
                            <sf:form action="${base}/register" method="post" modelAttribute="thanhvien" >
                                <div class="login-form">
                                    <h4 class="login-title">Đăng kí</h4>
                                    <div class="row">
                                        <div class="col-md-12 col-12 mb-20">
                                            <label>Họ tên</label>
                                            <sf:input path="hoTen" required="required" class="mb-0" type="text" placeholder="Họ tên"/>
                                        </div>
                                        <div class="col-md-12 mb-20">
                                            <label>Email</label>
                                            <sf:input path="email" required="required" class="mb-0" type="email" placeholder="Email "/>
                                            <label id="error">${error}</label>
                                        </div>
                                        <div class="col-md-12 mb-20 ">
                                            <label>Mật khẩu</label>
                                             <sf:input path="password" required="required" id="password" class="mb-0" type="password" placeholder="******"/>
                                             
                                        </div>
                                         <div class="col-md-12 mb-20 ">
                                            <label>Mật khẩu</label>
                                             <input required="required" id="repassword" class="mb-0" type="password" placeholder="******"/>
                                            <label id="message"></label>
                                        </div>
                                        <div class="col-12 mt-5">
                                            <button type="submit" onclick="return checkPassword();"  class="register-button mt-0">Đăng kí</button>
                                             <button  class="register-button mt-0"><a href="${base }/login">Đăng nhập</a></button>
                                            
                                            <br>
                                            <br>
                                             <a href="/">Quay lại</a>
                                        </div>
                                    </div>
                                </div>
                            </sf:form>
                        </div> 
                    </div>
                </div>
            </div>
            <!-- Footer Area End Here -->
        </div>
            <script src="${base}/user/js/validate.js"></script>
    </body>

<!-- login-register31:27-->
</html>
