<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/pagingTagLibs.tld"%>
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
                            <li class="active">Tất cả sản phẩm</li>
                        </ul>
                    </div>
                </div>
            </div>
             <!-- shop-top-bar start -->
           
           
                            <div class="shop-top-bar mt-30" style="padding-left: 170px;">
                                
                                <!-- product-select-box start -->
                                <div class="product-select-box">
                                    <div class="product-short">
                                        <p>Sắp xếp:</p>
                                        <form action="" method="get">
                                       		<select class="sort-select" name="sort">
                                       		<option value="0" >Tất cả</option>
                                            <option value="1" >Tên (A - Z)</option>
                                             <option value="2" >Tên (Z - A)</option>
                                              <option value="3" >Giá (Thấp&gt;Cao)</option>
                                            <option value="4">Giá (Cao &gt; Thấp)</option>
                                        	</select>
                                        	 <input style="height: 36px;" class="btn" id="btnSubmit" type="submit"  value="Sắp xếp">
                                         </form>
                                    </div>
                                </div>
                                <!-- product-select-box end -->
                            </div>
                          
                            <!-- shop-top-bar end -->
            <!-- Li's Breadcrumb Area End Here -->
            <!--Shopping Cart Area Strat-->
           <!-- shop-products-wrapper start -->
                            <div class="shop-products-wrapper" style="padding: 50px 150px">
                            
                                <div class="tab-content">
                                    <div id="grid-view" class="tab-pane fade active show" role="tabpanel">
                                        <div class="product-area shop-product-area">
                                            <div class="row">
                                            <c:forEach items="${list}" var="sp">
                                                <div class="col-lg-4 col-md-4 col-sm-6 mt-40">
                                                    <!-- single-product-wrap start -->
                                                    
                                                    <div class="single-product-wrap">
                                                        <div class="product-image">
                                                            <a href="${base}/sanphamchitiet/${sp.id}">
                                                                <img src="${base }/upload${sp.anhs.get(0).path}" alt="Li's Product Image">
                                                            </a>
                                                            
                                                        </div>
                                                        <div class="product_desc">
                                                            <div class="product_desc_info">
                                                                <div class="product-review">
                                                                    <h5 class="manufacturer">
                                                                        <a href="${base}/sanphamchitiet/${sp.id}">Mã sản phẩm:${sp.seo}</a>
                                                                    </h5>
                                                                   
                                                                </div>
                                                                <h4><a class="product_name" href="${base}/sanphamchitiet/${sp.id}">${sp.tenSanPham}</a></h4>
                                                                <div class="price-box">
														Giá bán: <span class="new-price"><fmt:setLocale
																value="vi_VN" scope="session" /> <fmt:formatNumber
																value="${sp.gia}" type="currency" /> </span>
																<br> <span
															class="old-price"> <fmt:setLocale value="vi_VN"
																scope="session" /> <fmt:formatNumber
																value="${sp.giaGoc}" type="currency" />
														</span><span class="discount-percentage">Tiết kiệm ${sp.phanTramGiam}%</span>
													</div>
                                                            </div>
                                                            <div class="add-actions">
													<ul class="add-actions-link">
														<li class="add-cart active"><c:if
																test="${user==null}">

																<button class="btn btn-success"
																	onclick="alert('Bạn cần đăng nhập để thêm vào giỏ hàng')">Thêm
																	vào giỏ</button>
															</c:if> <c:if test="${user!=null}">

																<button class="btn btn-success"
																	onclick="addToCart(${sp.id},1)">Thêm vào
																	giỏ</button>
															</c:if></li>

													</ul>
												</div>
                                                        </div>
                                                    </div>
                                                    
                                                    <!-- single-product-wrap end -->
                                                </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                     <div class="paginatoin-area">
                                        <div class="row">
                                             <div class="col-lg-6 col-md-6 pt-xs-15">
                                               
                                                <!-- Phân trang -->
                                               <tag:paginate offset="${page.offset}"
												count="${page.count }" uri="${pageUrl}" />
                                            </div>
                                        </div>
                                 </div>
                                </div>
                            </div>
                            <!-- shop-products-wrapper end -->
            <!--Shopping Cart Area End-->
            <jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
        </div>
        <jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
    </body>

<!-- shopping-cart31:32-->
</html>
