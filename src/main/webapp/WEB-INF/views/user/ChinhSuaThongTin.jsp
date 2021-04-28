<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- shopping-cart31:32-->
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
         <title>Ngọc Hưng Computer</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
    </head>
    <body>
   
        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
            <jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="/">Trang chủ</a></li>
                            <li class="active">Cập nhật thông tin</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!--Shopping Cart Area Strat-->
            <div class="Shopping-cart-area pt-60 pb-60">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-12">
                                <div class="checkbox-form">
                                    <h3>Thông tin cá nhân</h3>
                                    <div class="row justify-content-center">
                                        <sf:form action="${base }/suathongtin" method="post" modelAttribute="tv">
                                        <sf:hidden path="id"/>                                     
                                        <div class="col-md-12">
                                            <table class="table">
                                                <tr>
                                                    <td><label for="hoten" class="col-md-6">Họ và tên<span class="required">*</span></label></td>
                                                    <td><sf:input path="hoTen" type="text" id="hoTen" required="required" class="form"/></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="diachi"  class="col-md-6">Địa chỉ<span class="required">*</span></label></td>
                                                    <td><sf:input path="diaChi" type="text" id="diaChi" required="required" class="form"/></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-6">Giới tính<span class="required">*</span></label></td>
                                                    <td> Nam<sf:radiobutton  path="gioiTinh"  value="true"/>  
        												   Nữ<sf:radiobutton path="gioiTinh" value="false" /></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-6">Ngày sinh<span class="required">*</span></label></td>
                                                    <td><sf:input path="ngaySinh" type="date" id="ngaySinh" class="form"/></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-6">Email <span class="required">*</span></label></td>
                                                    <td><sf:input path="email" type="email" id="email" class="form"/></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-6">Số điện thoại<span class="required">*</span></label></td>
                                                    <td><sf:input path="soDienThoai" type="text" id="phone" class="form"/></td>
                                                   
                                               
                                                </tr>
                                                                                               <tr>
                                                    <td><label class="col-md-6">Mật khẩu<span class="required">*</span></label></td>
                                                    <td><sf:input path="password" type="password" readonly="true" id="matKhau" class="form"/></td>
                                                </tr>
                                                
                                                 <tr>
                                                    <td><button type="submit" onclick="return checkPhone();" class="btn btn-primary">Cập nhật thông tin</button></td>
                                                </tr>
                                                <tr>
                                                <td> <lable id="message"></lable></td>
                                                </tr>
                                               
                                            </table>

                                        </div>
                                        </sf:form>
                                    </div>
                                    
                                    
                                </div>
                           
                        </div>
                        
                    </div>
                </div>
            </div>
            <!--Shopping Cart Area End-->
            <jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
        </div>
        <jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
    </body>

<!-- shopping-cart31:32-->
</html>
