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
                            <li class="active">Đơn hàng</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
             <!-- Begin Product Area -->
            <div class="product-area pt-35">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="li-product-tab">
                                <ul class="nav li-product-menu">
                                   <li><a class="active" data-toggle="tab" href="#all">Tất cả</a></li>
                                   <li><a data-toggle="tab" href="#confirm"><span>Chờ xác nhận</span></a></li>
                                 	<li><a data-toggle="tab" href="#wait"><span>Chờ lấy hàng</span></a></li>
                                   <li><a data-toggle="tab" href="#shipping"><span>Đang giao</span></a></li>
                                   <li><a data-toggle="tab" href="#shipped"><span>Đã giao</span></a></li>
                                   <li><a data-toggle="tab" href="#cancel"><span>Đã hủy</span></a></li>
                                </ul>               
                            </div>
                            <!-- Begin Li's Tab Menu Content Area -->
                        </div>
                    </div>
                    <style type="text/css">
                    .table>tbody>tr>td:first-child{
                    width:50%;
                    }
                    </style>
                    <div class="tab-content">
                        <div id="all" class="tab-pane active show" role="tabpanel">
                            <div class="product-description">
                               <table class="table">
                               <c:forEach items="${donhang}" var="donhang">
                               <c:if test="${donhang.trangThai!=5}"></c:if>
                                   <tr>
                                    <th>Mã đơn hàng: ${donhang.seo}</th>
                                       <td> Tình trạng<span class="btn btn-primary"><c:if test="${donhang.trangThai==1}">Chưa duyệt</c:if>
                                       <c:if test="${donhang.trangThai==2}">Đã duyệt</c:if>
                                       <c:if test="${donhang.trangThai==3}">Đang giao</c:if>
                                       <c:if test="${donhang.trangThai==4}">Đã giao</c:if> 
                                       <c:if test="${donhang.trangThai==5}">Đã huỷ</c:if></span></td>
                                   </tr>
                               <c:forEach items="${donhang.chiTiets}" var="chitiet">
                                   <tr>
                                       <td rowspan="4"><img src="${base}/upload${chitiet.sanPhams.anhs.get(0).path}" width="250px" height="185px" alt=""></td>
                                  		<td>${chitiet.sanPhams.tenSanPham}</td>
                                   </tr>
                                    <tr>
                                        <td>Số lượng x ${chitiet.soLuong}</td>
                                    </tr>
                                    <tr>
                                         <td>Giá: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia}"
														type="currency" /></td>
                                    </tr>
                                    <tr>
                                         <td>Thành tiền: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia*chitiet.soLuong}"
														type="currency" /></td>
                                    </tr>
                                   </tr>
                                   </c:forEach>
                                   <tr>
                                       <td>Ngày đặt: <b>${donhang.fomatDate(donhang.ngayLap)}</b> Tổng tiền:<span style="color: red;font-weight:bold"><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${donhang.tongTien}"
														type="currency" /></span>
										</td>
                                       
                                    </tr>
                                    
                                    </c:forEach>
                               </table>
                            </div>
                        </div>
                        <div id="confirm" class="tab-pane" role="tabpanel">
                            <div class="product-details-manufacturer">
                               
                                <table class="table">
                                <c:forEach items="${donhang}" var="donhang">
                               	<c:if test="${donhang.trangThai==1}">
                               	
                                    <tr>
                                    <th>Mã đơn hàng: ${donhang.seo}</th>
                                        <td>Tình trạng<span class="btn btn-primary">Chờ xác nhận</span></td>
                                    </tr>
                                       <c:forEach items="${donhang.chiTiets}" var="chitiet">
                                   <tr>
                                       <td rowspan="4"><img src="${base}/upload${chitiet.sanPhams.anhs.get(0).path}" width="250px" height="185px" alt=""></td>
                                   <td>${chitiet.sanPhams.tenSanPham}</td>
                                   </tr>
                                   
                                    
                                    <tr>
                                        <td>Số lượngx ${chitiet.soLuong}</td>
                                    </tr>
                                    <tr>
                                         <td>Giá: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia}"
														type="currency" /></td>
                                    </tr>
                                    <tr>
                                         <td>Thành tiền: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia*chitiet.soLuong}"
														type="currency" /></td>
                                    </tr>
                                  
                                   </c:forEach>
                                    <tr>
                                        <td>Ngày đặt: <b>${donhang.fomatDate(donhang.ngayLap)}</b>Tổng tiền:<span style="color: red;font-weight:bold"><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${donhang.tongTien}"
														type="currency" /></span></td>
                                        <td><a href="${base}/huydonhang/${donhang.id}" class="btn btn-danger">Hủy đơn hàng</a></td>
                                     </tr>
                                     </c:if>
                                      </c:forEach>
                                </table>
                            </div>
                        </div>
                       <div id="wait" class="tab-pane" role="tabpanel">
                            <div class="product-details-manufacturer">
                                <table class="table">
                                <c:forEach items="${donhang}" var="donhang">
                               	<c:if test="${donhang.trangThai==2}">
                               	
                                    <tr>
                                    <th>Mã đơn hàng: ${donhang.seo}</th>
                                        <td>Tình trạng<span class="btn btn-primary">Chờ lấy hàng</span></td>
                                    </tr>
                                       <c:forEach items="${donhang.chiTiets}" var="chitiet">
                                   <tr>
                                       <td rowspan="4"><img src="${base}/upload${chitiet.sanPhams.anhs.get(0).path}" width="250px" height="185px" alt=""></td>
                                  	 <td>${chitiet.sanPhams.tenSanPham}</td>
                                   </tr>
                                    <tr>
                                        <td>x ${chitiet.soLuong}</td>
                                    </tr>
                                    <tr>
                                         <td>Giá: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia}"
														type="currency" /></td>
                                   
                                   </tr>
                                    <tr>
                                         <td>Thành tiền: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia*chitiet.soLuong}"
														type="currency" /></td>
                                    </tr>
                                   </c:forEach>
                                    <tr>
                                       <td >Ngày đặt: <b>${donhang.fomatDate(donhang.ngayLap)}</b>Tổng tiền:<span style="color: red;font-weight:bold"><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${donhang.tongTien}"
														type="currency" /></span></td>
                                        
                                     </tr>
                                     </c:if>
                                      		
                                      </c:forEach>
                                </table>
 
                            </div>
                        </div>
                      <div id="shipping" class="tab-pane" role="tabpanel">
                            <div class="product-details-manufacturer">
                               
                                <table class="table">
                                <c:forEach items="${donhang}" var="donhang">
                               	<c:if test="${donhang.trangThai==3}">
                               	
                                    <tr>
                                    <th>Mã đơn hàng: ${donhang.seo}</th>
                                        <td>Tình trạng<span class="btn btn-primary">Đang giao</span></td>
                                    </tr>
                                       <c:forEach items="${donhang.chiTiets}" var="chitiet">
                                   <tr>
                                       <td rowspan="4"><img src="${base}/upload${chitiet.sanPhams.anhs.get(0).path}" width="250px" height="185px" alt=""></td>
                                  <td>${chitiet.sanPhams.tenSanPham}</td>
                                   </tr>
                                   
                                    
                                    <tr>
                                        <td>x ${chitiet.soLuong}</td>
                                    </tr>
                                    <tr>
                                         <td>Giá: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia}"
														type="currency" /></td>
                                     <tr>
                                         <td>Thành tiền: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia*chitiet.soLuong}"
														type="currency" /></td>
                                    </tr>
                                   </c:forEach>
                                    <tr>
                                        <td>Ngày đặt: <b>${donhang.fomatDate(donhang.ngayLap)}</b>Tổng tiền:<span style="color: red;font-weight:bold"><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${donhang.tongTien}"
														type="currency" /></span></td>
                                        <td><a href="${base}/donhang/dagiao/${donhang.id}" class="btn btn-danger">Đã nhận hàng</a></td>
                                     </tr>
                                     </c:if>	
                                    
                                      </c:forEach>
                                </table>
 
                            </div>
                        </div>
                       <div id="shipped" class="tab-pane" role="tabpanel">
                            <div class="product-details-manufacturer">
                               
                                <table class="table">
                                <c:forEach items="${donhang}" var="donhang">
                    	<c:if test="${donhang.trangThai==4}">
                                    <tr>
                                    <th>Mã đơn hàng: ${donhang.seo}</th>
                                        <td>Tình trạng<span class="btn btn-primary">Đã giao</span></td>
                                    </tr>
                                       <c:forEach items="${donhang.chiTiets}" var="chitiet">
                                   <tr>
                                       <td rowspan="4"><img src="${base}/upload${chitiet.sanPhams.anhs.get(0).path}" width="250px" height="185px" alt=""></td>
                                    	<td>${chitiet.sanPhams.tenSanPham}</td>
                                   </tr>
                                   
                                   
                                    <tr>
                                        <td>x ${chitiet.soLuong}</td>
                                    </tr>
                                    <tr>
                                         <td>Giá: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia}"
														type="currency" /></td>
                                   
                                   </tr>
                                    <tr>
                                         <td>Thành tiền: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia*chitiet.soLuong}"
														type="currency" /></td>
                                    </tr>
                                   </c:forEach>
                                    <tr>
                                        <td>Ngày đặt: <b>${donhang.fomatDate(donhang.ngayLap)}</b>Tổng tiền:<span style="color: red;font-weight:bold"><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${donhang.tongTien}"
														type="currency" /></span></td>
                                       
                                     </tr>
                                     </c:if>	
                                     
                                      </c:forEach>
                                </table>
 
                            </div>
                        </div>
                         <div id="cancel" class="tab-pane" role="tabpanel">
                            <div class="product-details-manufacturer">
                               
                                <table class="table">
                                <c:forEach items="${donhang}" var="donhang">
                               	<c:if test="${donhang.trangThai==5}">
                               	
                                    <tr>
                                    <th>Mã đơn hàng: ${donhang.seo}</th>
                                        <td>Tình trạng<span class="btn btn-primary">Đã hủy</span></td>
                                    </tr>
                                       <c:forEach items="${donhang.chiTiets}" var="chitiet">
                                   <tr>
                                       <td rowspan="4"><img src="${base}/upload${chitiet.sanPhams.anhs.get(0).path}" width="250px" height="185px" alt=""></td>
                                   
 
                                    <td>${chitiet.sanPhams.tenSanPham}</td>
                                    </tr>
                                    <tr>
                                        <td>x ${chitiet.soLuong}</td>
                                    </tr>
                                    <tr>
                                         <td>Giá: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia}"
														type="currency" /></td>
                                   
                                   </tr>
                                    <tr>
                                         <td>Thành tiền: <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${chitiet.sanPhams.gia*chitiet.soLuong}"
														type="currency" /></td>
                                    </tr>
                                   </c:forEach>
                                    <tr>
                                       <td>Ngày đặt: <b>${donhang.fomatDate(donhang.ngayLap)}</b>Tổng tiền:<span style="color: red;font-weight:bold"><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${donhang.tongTien}"
														type="currency" /></span></td>
                                       
                                     </tr>
                                     </c:if>	
                                     
                                      </c:forEach>
                                </table>
 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Product Area End Here -->
            
           <jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
        </div>
        <!-- Body Wrapper End Here -->
        <jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
    </body>

<!-- shopping-cart31:32-->
</html>
