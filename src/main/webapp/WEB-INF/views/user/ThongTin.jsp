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
                            <li class="active">Thông tin thành viên</li>
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
                                        
                                        
                                        
                                       
                                        <div class="col-md-9">
                                        
                                            <table class="table">
                                                <tr>
                                                    <td><label class="col-md-4">Họ và tên<span class="required">*</span></label></td>
                                                    <td><input class="col-md-8" value="${user.hoTen}" readonly="readonly" type="text" name="hoTen"/></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-4">Địa chỉ<span class="required">*</span></label></td>
                                                    <td><input value="${user.diaChi}" readonly="readonly" type="text" name="diaChi" class="col-md-8" /></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-4">Giới tính<span class="required">*</span></label></td>
                                                    <td> <input class="col-md-8"  type="text"  readonly="readonly" value="${user.gioiTinh==true?'Nam':'Nữ'}"/>  
        												   </td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-4">Ngày sinh<span class="required">*</span></label></td>
                                                    <td>
                                                    <c:if test="${user.ngaySinh!=null}">
                                                    <input class="col-md-8" value="${user.fomatDate(user.ngaySinh)}    readonly="readonly"type="text" name="ngaySinh"/>
                                                    </c:if>
                                                     <c:if test="${user.ngaySinh==null}">
                                                      <input  value=" " readonly="readonly" type="text" name="ngaySinh"/>
                                                    </c:if>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-4">Email<span class="required">*</span></label></td>
                                                    <td><input class="col-md-8" value="${user.email} " readonly="readonly"type="email" name="email"/></td>
                                                </tr>
                                                <tr>
                                                    <td><label class="col-md-4">Số điện thoại<span class="required">*</span></label></td>
                                                    <td><input class="col-md-8" value="${user.soDienThoai}"  readonly="readonly"type="text" name="soDienThoai"/></td>
                                                </tr>
                                                <!-- <tr>
                                                    <td><label class="col-md-6">Ảnh đại diện<span class="required">*</span></label></td>
                                                    <td><input type="file"  name="anh" class="form"></td>
                                                </tr> -->
                                                <tr>
                                                    <td><a href="${base}/chinhsua/${user.id}" class="btn btn-primary">Cập nhật thông tin</a></td>
                                                </tr>
                                                
                                            </table>      
                                        </div>
                                      
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
