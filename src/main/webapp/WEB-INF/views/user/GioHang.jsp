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
            <!-- Header Area End Here -->
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="/">Trang chủ</a></li>
                            <li class="active">Giỏ hàng <label style="color:red">${thongbao}</label></li>
                        </ul>
                    </div>
                </div>
                
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!--Shopping Cart Area Strat-->
            <div class="Shopping-cart-area pt-60 pb-60">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <form action="${base}/giohang/dathang" method="post">
                                <div class="table-content table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                               <th>#</th>
                                                <th class="cart-product-name">Tên sản phẩm</th>
                                                <th class="li-product-price">Giá</th>
                                                <th class="li-product-quantity">Số lượng</th>
                                                <th class="li-product-subtotal">Thành tiền</th>
                                                 <th>Xóa</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <c:forEach items="${cart.listHang}" var="item" varStatus="loop">
                                            <tr>
                                            	<td>${loop.index+1}</td>
                                                <td class="li-product-name"><a href="#">${item.tenSp}</a></td>
                                                <td class="li-product-price"><span class="amount"><fmt:setLocale value="vi_VN" scope="session"/>
                                             					<fmt:formatNumber value="${item.gia}" type="currency" /></span></td>
                                                <td class="quantity">${item.soLuong}
                                                </td>
                                                <td class="product-subtotal"><span class="amount"><fmt:setLocale value="vi_VN" scope="session"/>
                                             					<fmt:formatNumber value="${item.gia*item.soLuong}" type="currency" /></span></td>
                                             	<td><a href="${base}/giohang/xoa/${loop.index}"><i class="fa fa-trash">Xóa</i></a></td>
                                            </tr>
                                           </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6 col-12">
                                       
                                            <div class="checkbox-form">
                                                <h3>Thông tin</h3>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label for="hoten">Họ và tên<span class="required">*</span></label>
                                                            <input required value="${user.hoTen}" name="hoTen" placeholder="Họ và tên" id="hoten" type="text"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label for="diachi">Địa chỉ <span class="required">*</span></label>
                                                            <input required value="${user.diaChi}" name="diaChi" placeholder="Street address" id="diachi" type="text"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label for="sodienthoai">Số điện thoại  <span class="required">*</span></label>
                                                            <input required value="${user.soDienThoai}" placeholder="Số điện thoại"  name="soDienThoai"  id="phone" />
                                                       <label id="message"></label>
                                                        </div>
                                                    </div>
                                                    
                                                </div>

                                            </div>
                                       
                                    </div>
                                    <div class="col-md-5 ml-auto">
                                        <div class="cart-page-total">
                                            <h2>Thanh toán</h2>
                                            <select name="thanhToan">
                                                <option value="Online">Online</option>
                                                <option value="Offline">Offline</option>
                                            </select>

                                           
                                            <ul>
                                               
                                                <li>Tổng tiền<span><fmt:setLocale value="vi_VN" scope="session"/>
                                             					<fmt:formatNumber value="${tongTien}" type="currency" /></span></li>
                                            </ul>
                    						
                                            <button onclick="return checkPhone();" type="submit" class="btn btn-success">Đặt hàng</button>
                                            
                                        </div>
                                    </div>
                                </div>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
            <!--Shopping Cart Area End-->
           <jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
        </div>
        <!-- Body Wrapper End Here -->
        <jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
    </body>

<!-- shopping-cart31:32-->
</html>
