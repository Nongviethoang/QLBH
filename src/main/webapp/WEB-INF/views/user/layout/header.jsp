<%@page import="com.haui.SaleLaptop.entities.ThanhVienEntity"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
<!-- Begin Header Area -->
            <header class="li-header-4">
                <!-- Begin Header Top Area -->
                <div class="header-top">
                    <div class="container">
                        <div class="row">
                            <!-- Begin Header Top Left Area -->
                            <div class="col-lg-3 col-md-4">
                                <div class="header-top-left">
                                    
                                </div>
                            </div>
                            <!-- Header Top Left Area End Here -->
                            <!-- Begin Header Top Right Area -->
                            <div class="col-lg-9 col-md-8">
                                <div class="header-top-right">
                                <c:if test="${user!=null}">
                                    <ul class="ht-menu">
                                    
                                                    <li><a href="#">Xin chào, ${user.hoTen}</a></li>
                                                    
                                                    <li><a href="${base}/thongtin">Thông tin</a></li>
                                                    <li><a href="${base}/donmua/${user.id}">Đơn hàng</a></li>
                                                    <li><a href="${base}/logout">Đăng xuất</a></li>
                                                  
                                                    <c:forEach items="${user.quyens}" var="quyen">
                                                     <c:if test="${quyen.id==1}">
                                                      <li><a href="${base}/admin1">Admin</a></li>
                                                      </c:if>
                                                    </c:forEach>
                                    </ul>
                                    </c:if>
                                     <c:if test="${user==null}">
                                    <ul class="ht-menu">
                                    
                                                    <li><a href="${base}/login">Đăng nhập</a></li>
                                                    <li><a href="${base}/dangki">Đăng kí</a></li>
                                                    
                                        <!-- Setting Area End Here -->
                                        
                                    </ul>
                                     </c:if>
                                </div>
                            </div>
                            <!-- Header Top Right Area End Here -->
                        </div>
                    </div>
                </div>
                <!-- Header Top Area End Here -->
                <!-- Begin Header Middle Area -->
                <div class="header-middle pl-sm-0 pr-sm-0 pl-xs-0 pr-xs-0">
                    <div class="container">
                        <div class="row">
                            <!-- Begin Header Logo Area -->
                            <div class="col-lg-3">
                                <div class="logo pb-sm-30 pb-xs-30">
                                    <a href="/">
                                        <img src="${base}/user/images/menu/logo/ngochung.jpg" alt="">
                                    </a>
                                </div>
                            </div>
                            <!-- Header Logo Area End Here -->
                            <!-- Begin Header Middle Right Area -->
                            <div class="col-lg-9">
                                <!-- Begin Header Middle Searchbox Area -->
                                <form action="${base}/timkiem" class="hm-searchbox">
                                    <input type="text" name="timKiem" placeholder="Nhập têm sản phẩm, tên danh mục, thương hiệu tìm kiếm ...">
                                    <button class="li-btn" type="submit"><i class="fa fa-search"></i></button>
                                </form>
                                <!-- Header Middle Searchbox Area End Here -->
                                <!-- Begin Header Middle Right Area -->
                                <div class="header-middle-right">
                                    <ul class="hm-menu">
                                        <!-- Begin Header Middle Wishlist Area -->
                                        <li class="hm-wishlist">
                                            <!-- <a href="/">
                                                <span class="cart-item-count wishlist-item-count">0</span>
                                                <i class="fa fa-heart-o"></i>
                                            </a> -->
                                        </li>
                                        <!-- Header Middle Wishlist Area End Here -->
                                        <!-- Begin Header Mini Cart Area -->
                                        <li class="hm-minicart">
                                            <div class="cart">
                                            
                                                <span class="item-icon" ></span>
                                                <span class="item-text">
                                                <c:if test="${user==null}">
                                                 <a href="#" style="color: white" onclick="Redirect();">Giỏ hàng</a>
                                                </c:if>
                                                <c:if test="${user!=null}">
                                                <a href="/cart/views" style="color: white">Giỏ hàng</a>
                                                  <span class="cart-item-count" id="totalItemsInCart" title="">${totalitem}</span>
                                                    </c:if>
                                                    
                                                    <span class="cart-item-count"></span>
                                                </span>
                                            </div>
                                        </li>
                                        <!-- Header Mini Cart Area End Here -->
                                    </ul>
                                </div>
                                <!-- Header Middle Right Area End Here -->
                            </div>
                            <!-- Header Middle Right Area End Here -->
                        </div>
                    </div>
                </div>
                <!-- Header Middle Area End Here -->
                <!-- Begin Header Bottom Area -->
                <div class="header-bottom header-sticky stick d-none d-lg-block d-xl-block">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <!-- Begin Header Bottom Menu Area -->
                                <div class="hb-menu hb-menu-2">
                                    <nav>
                                        <ul>
                                            <li class="dropdown-holder"><a href="/">Trang chủ</a>
                                            </li>
                                             <li class="dropdown-holder"><a href="/all-product">Sản phẩm</a>
                                            </li>
                                            <li class="megamenu-static-holder"><a href="/gioithieu">Giới thiệu</a></li>
                                            <li><a href="/userlienhe">Liên hệ</a></li>
                                        </ul>
                                    </nav>
                                </div>
                                <!-- Header Bottom Menu Area End Here -->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Header Bottom Area End Here -->
                <!-- Begin Mobile Menu Area -->
                <div class="mobile-menu-area d-lg-none d-xl-none col-12">
                    <div class="container"> 
                        <div class="row">
                            <div class="mobile-menu">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Mobile Menu Area End Here -->
            </header>
            <!-- Header Area End Here -->