<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- single-product31:30-->
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Ngọc Hưng Computer</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>

</head>
<body>
	<!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	<!-- Begin Body Wrapper -->
	<div class="body-wrapper">
		<jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>
		<!-- Begin Li's Breadcrumb Area -->
		<div class="breadcrumb-area">
			<div class="container">
				<div class="breadcrumb-content">
					<ul>
						<li><a href="/">Trang chủ</a></li>
						<li class="active">Chi tiết sản phẩm</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- content-wraper start -->
		<div class="content-wraper">
			<div class="container">
				<div class="row single-product-area">
					<div class="col-lg-5 col-md-6">
                           <!-- Product Details Left -->
                            <div class="product-details-left">
                                <div class="product-details-images slider-navigation-1">
                                <c:forEach items="${listAnh}" var="anh">
                                    <div class="lg-image">
                                        <a class="popup-img venobox vbox-item" href="images/product/large-size/1.jpg" data-gall="myGallery">
                                            <img src="${base}/upload${anh.path}" alt="product image">
                                        </a>
                                    </div>
                                    </c:forEach> 
                                </div>
                               <div class="product-details-thumbs slider-thumbs-1">                                        
                                    <c:forEach items="${listAnh}" var="anh"> 
                                    <div class="sm-image"><img src="${base}/upload${anh.path}" alt="product image thumb"></div>
                                	</c:forEach>
                                </div>
                            </div>
                            <!--// Product Details Left -->
                        </div>

					<div class="col-lg-7 col-md-6">
						<div class="product-details-view-content pt-60">
							<div class="product-info">
								<h2>${sp.tenSanPham}</h2>
								<span class="product-details-ref">Thương
									hiệu:${sp.thuongHieus.tenThuongHieu}</span> <br> <span
									class="product-details-ref">Bảo hành:<a href="#"><c:if
											test="${sp.baoHanh==1}">6 tháng</c:if> <c:if
											test="${sp.baoHanh==2}">12 tháng</c:if> <c:if
											test="${sp.baoHanh==3}">24 tháng</c:if> </a></span>


								<div class="price-box pt-20">


									<span class="new-price"> <fmt:setLocale value="vi_VN"
											scope="session" /> <fmt:formatNumber value="${sp.gia }"
											type="currency" />
								</div>

								<div class="single-add-to-cart">

									<c:if test="${user==null}">
										<div class="cart-quantity">
											<div class="quantity">
												<label>Số lượng mua</label>
												<div class="cart-plus-minus">
													<input class="cart-plus-minus-box" value="1" type="text">
													<div class="dec qtybutton">
														<i class="fa fa-angle-down"></i>
													</div>
													<div class="inc qtybutton">
														<i class="fa fa-angle-up"></i>
													</div>
												</div>
											</div>
											<button class="btn btn-warning" onclick="Redirect();">Thêm
												vào giỏ</button>
										</div>
                              				 </c:if>
									<c:if test="${user!=null}">
										<div class="cart-quantity">
											<div class="quantity">
												<label>Số lượng mua</label>
												<div class="cart-plus-minus">
													<input class="cart-plus-minus-box" id="soLuong" value="1"
														type="text">
													<div class="dec qtybutton">
														<i class="fa fa-angle-down"></i>
													</div>
													<div class="inc qtybutton">
														<i class="fa fa-angle-up"></i>
													</div>
												</div>
											</div>
											<!-- Số lượng:<input
											type="number" name="sl" class="col-md-2" id="soLuong" value="1" />
										<br /> -->
											<button onclick="themHang(${sp.id});" class="btn btn-warning"
												type="submit">Thêm vào giỏ</button>
										</div>
									</c:if>
								</div>
								<div class="product-additional-info pt-25">
									<!-- <a class="wishlist-btn" href="#"><i class="fa fa-heart-o"></i>Thêm
										vào danh sách yêu thích</a>
									<div class="product-social-sharing pt-25">
										<ul>
											<li class="facebook"><a href="#"><i
													class="fa fa-facebook"></i>Facebook</a></li>
											<li class="twitter"><a href="#"><i
													class="fa fa-twitter"></i>Twitter</a></li>
											<li class="google-plus"><a href="#"><i
													class="fa fa-google-plus"></i>Google +</a></li>
											<li class="instagram"><a href="#"><i
													class="fa fa-instagram"></i>Instagram</a></li>
										</ul>
									</div> -->
								</div>
								<div class="block-reassurance">
									<ul>
										<li>
											<div class="reassurance-item">
												<div class="reassurance-icon">
													<i class="fa fa-check-square-o"></i>
												</div>
												<p>Chính sách bảo mật</p>
											</div>
										</li>
										<li>
											<div class="reassurance-item">
												<div class="reassurance-icon">
													<i class="fa fa-truck"></i>
												</div>
												<p>Chính sách giao hàng</p>
											</div>
										</li>
										<li>
											<div class="reassurance-item">
												<div class="reassurance-icon">
													<i class="fa fa-exchange"></i>
												</div>
												<p>Chính sách đổi trả</p>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- content-wraper end -->
		<!-- Begin Product Area -->
		<div class="product-area pt-35">
			<div class="container">
				<div class="row mt-5">
					<div class="col-lg-12">
						<div class="li-product-tab">
							<ul class="nav li-product-menu">
								<li><a class="active" data-toggle="tab" href="#description"><span>Cấu
											hình</span></a></li>
								<li><a data-toggle="tab" href="#product-details"><span>Đánh
											giá</span></a></li>
								<li><a data-toggle="tab" href="#reviews"><span>Bình
											luận(${countCmt} bình luận)</span></a></li>
							</ul>
						</div>
						<!-- Begin Li's Tab Menu Content Area -->
					</div>
				</div>
				<div class="tab-content">
					<div id="description" class="tab-pane active show" role="tabpanel">
						<div class="product-description">${sp.cauHinh }</div>
					</div>
					<div id="product-details" class="tab-pane" role="tabpanel">
						<div class="product-details-manufacturer">${sp.gioiThieu}</div>
					</div>

					<div id="reviews" class="tab-pane" role="tabpanel">
						<div class="product-reviews">
							<div class="product-details-comment-block">
								<c:forEach items="${binhluans}" var="bl">
									<div class="comment-author-infos pt-25">
										<span>${bl.thanhViens.hoTen}: ${bl.noiDung}</span> <em>${bl.thoiGian}</em>
									</div>
								</c:forEach>
								<div class="review-btn">
									<a class="review-links" href="#" data-toggle="modal"
										data-target="#mymodal">Viết bình luận</a>
								</div>
								<!-- Begin Quick View | Modal Area -->
								<div class="modal fade modal-wrapper" id="mymodal">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-body">
												<h3 class="review-page-title">Viết bình luận</h3>
												<div class="modal-inner-area row">
													<div class="col-lg-6">
														<div class="li-review-product">
															<img src="${base}/upload${listAnh.get(0).path}"
																width="200px" height="150px" alt="Li's Product">
														</div>
													</div>
													<div class="col-lg-6">
														<div class="li-review-content">
															<!-- Begin Feedback Area -->
															<div class="feedback-area">
																<div class="feedback">
																	<h3 class="feedback-title">Đánh giá</h3>
																	<c:if test="${user==null}">
																		<form action="${base}/login" method="get">Đăng
																			nhập để bình luận!!!!!</form>
																	</c:if>
																	<c:if test="${user!=null}">
																		<sf:form action="${base}/binhluansp/${sp.id}"
																			method="post" modelAttribute="binhluan">
																			<p class="feedback-form">
																				<label for="feedback">Nội dung</label>

																				<sf:textarea path="noiDung" id="feedback"
																					name="comment" cols="45" rows="8"
																					aria-required="true"></sf:textarea>
																			</p>
																			<div class="feedback-input">

																				<div class="feedback-btn pb-15">
																					<a href="#" class="close" data-dismiss="modal"
																						aria-label="Close">Đóng</a>
																					<button type="submit" class="btn btn-primary">
																						Gửi</a>
																				</div>
																			</div>
																		</sf:form>
																	</c:if>
																</div>
															</div>
															<!-- Feedback Area End Here -->
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Quick View | Modal Area End Here -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Product Area End Here -->
		<!-- Begin Li's Laptop Product Area -->
		<section class="product-area li-laptop-product pt-30 pb-50">
			<div class="container">
				<div class="row">
					<!-- Begin Li's Section Area -->
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2>
								<span>Các sản phẩm liên quan</span>
							</h2>
						</div>
						<div class="row">
							<c:forEach items="${sanPham}" var="sp">
								<div class="col-lg-3">

									<!-- single-product-wrap start -->

									<div class="single-product-wrap">
										<div class="product-image">
											<a href="${base}/sanphamchitiet/${sp.id}"> <img
												src="${base}/upload${sp.anhs.get(0).path}" alt="Li's Product Image">
											</a>

										</div>
										<div class="product_desc">
											<div class="product_desc_info">
												<div class="product-review">
													<h5 class="manufacturer">
														<a href="${base}/sanphamchitiet/${sp.id}">Mã sản
															phẩm:${sp.seo}</a>
													</h5>

												</div>
												<h4>
													<a class="product_name"
														href="${base}/sanphamchitiet/${sp.id}">${sp.tenSanPham}</a>
												</h4>
												<div class="price-box">
													<span class="new-price"> <fmt:setLocale
															value="vi_VN" scope="session" /> <fmt:formatNumber
															value="${sp.gia }" type="currency" />
												</div>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active">
													<button class="btn btn-warning"
														onclick="addToCart(${sp.id},1)">Thêm vào giỏ</button>
												</li>
												<li><a href="#" title="quick view"
													class="quick-view-btn" data-toggle="modal"
													data-target="#exampleModalCenter"><i class="fa fa-eye"></i></a></li>
												<li><a class="links-details" href="/"><i
														class="fa fa-heart-o"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
							</c:forEach>
							<!-- single-product-wrap end -->
						</div>

					</div>
				</div>
				<!-- Li's Section Area End Here -->
			</div>
	</div>
	</section>
	<!-- Li's Laptop Product Area End Here -->
	<jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
	<script type="text/javascript">
          $(".reset").click(function() {
        	    $(this).closest('form').find("input[type=text], textarea").val("");
        	   
        	});
          
          function themHang(idSp,soLuong) {
        		
        	  var soLuong=document.getElementById("soLuong").value;
      		if(soLuong<=0)
      			{
      			alert("Số lượng phải lớn hơn 0");
      			}
      		else
      			{	
      		var data = {};
   		data["idSp"] = idSp;
   		data["soLuong"]=soLuong
      			}
        		$.ajax({
        			url : "/cart/add",
        			type : "post",
        			contentType : "application/json",
        			data : JSON.stringify(data),

        			dataType : "json",
        			success : function(jsonResult) {
        				$("#totalItemsInCart").html(jsonResult.data),
        				alert("Đã thêm "+data.soLuong+" sản phẩm vào giỏ hàng!")
        				
        			},
        			error : function(jqXhr, textStatus, errorMessage) { // error callback 

        			}
        		});

          }
          
          </script>
	</div>
	<!-- Body Wrapper End Here -->
	<jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
</body>

<!-- single-product31:32-->
</html>
