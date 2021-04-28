<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- index-331:38-->
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Ngọc Hưng Computer</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
	<div class="body-wrapper">
		<jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>
		<!-- Begin Slider With Category Menu Area -->
		<div class="slider-with-banner">
			<div class="container">
				<div class="row">
					<!-- Begin Category Menu Area -->
					<div class="col-lg-3">
						<!--Category Menu Start-->
						<div class="category-menu category-menu-2">
							<div class="category-heading">
								<h2 class="categories-toggle">
									<span>Danh mục sản phẩm</span>
								</h2>
							</div>
							<div id="cate-toggle" class="category-menu-list">
								<ul>${menu}
								</ul>
							</div>
						</div>
						<!--Category Menu End-->
					</div>
					<!-- Category Menu Area End Here -->
					<!-- Begin Slider Area -->
					<div class="col-lg-6 col-md-8">
						<div class="slider-area slider-area-3 pt-sm-30 pt-xs-30 pb-xs-30">
							<div class="slider-active owl-carousel">
								<!-- Begin Single Slide Area -->
								<div
									class="single-slide align-center-left animation-style-01 bg-7">
									<div class="slider-progress"></div>

								</div>
								<!-- Single Slide Area End Here -->
								<!-- Begin Single Slide Area -->
								<div
									class="single-slide align-center-left animation-style-02 bg-8">
									<div class="slider-progress"></div>

								</div>
								<!-- Single Slide Area End Here -->
								<!-- Begin Single Slide Area -->
								<div
									class="single-slide align-center-left animation-style-01 bg-9">
									<div class="slider-progress"></div>

								</div>
								<!-- Single Slide Area End Here -->
							</div>
						</div>
					</div>
					<!-- Slider Area End Here -->
					<!-- Begin Li Banner Area -->
					<div class="col-lg-3 col-md-4 text-center pt-sm-30">
						<div class="li-banner">
							<a href="#"> <img src="${base}/user/images/banner/1.jpg"
								alt="">
							</a>
						</div>
						<div class="li-banner mt-15 mt-sm-30 mt-xs-25 mb-xs-5">
							<a href="#"> <img src="${base}/user/images/banner/2.jpg"
								alt="">
							</a>
						</div>
					</div>
					<!-- Li Banner Area End Here -->
				</div>
			</div>
		</div>
		<!-- Slider With Category Menu Area End Here -->

		<!-- Begin Li's Special Product Area -->
		<section
			class="product-area li-laptop-product Special-product pt-60 pb-45">
			<div class="container">


				<!-- new -->
				<div class="row">
					<div class="col-lg-12">
						<!-- sort by price -->
						<div class="row">
							<ul class="sort-price">
								<span>Chọn mức giá</span>
								<li class="right-menu"><a href="/price1">Dưới 5 triệu</a></li>
								<li class="right-menu"><a href="/price2"> 5 triệu - 10
										triệu</a></li>
								<li class="right-menu"><a href="/price3"> 10 triệu - 15
										triệu</a></li>
								<li class="right-menu"><a href="/price4"> 15 triệu - 20
										triệu</a></li>
								<li class="right-menu"><a href="/price5">20 triệu - 30
										triệu</a></li>
								</li>
								<li class="right-menu"><a href="/price6"> Trên 30 triệu
								</a></li>
							</ul>
						</div>
						<!-- end sort by price -->
						<!-- sort branch -->
						<div class="row">
							<ul class="sort-price">
								<span>Thương hiệu</span>
								<c:forEach items="${thuongHieus}" var="item">
									<li class="right-menu"><a
										href="${base}/thuonghieu/${item.tenThuongHieu}">${item.tenThuongHieu}</a>
									</li>
								</c:forEach>
							</ul>
						</div>
						<!-- end sort branch  -->
						<div class="li-section-title">
							<h2>
								<span>Sản phẩm mới</span>
							</h2>
						</div>
						<div class="row">

							<div class="special-product-active owl-carousel">
								<c:forEach items="${spMoi}" var="spMoi">
									<div class="col-lg-12">

										<!-- single-product-wrap start -->
										<div class="single-product-wrap">
											<div class="product-image">

												 <a href="${base}/sanphamchitiet/${spMoi.id}"> <img
													src="${base}/upload${spMoi.anhs.get(0).path}" alt="Li's Product Image">
												</a> 

											</div>
											<div class="product_desc">
												<div class="product_desc_info">
													<div class="product-review">
														<h5 class="manufacturer">
															<a href="${base}/sanphamchitiet/${spMoi.id}">${spMoi.seo}</a>
														</h5>

													</div>
													<h4>
														<a class="product_name"
															href="${base}/sanphamchitiet/${spMoi.id}">${spMoi.tenSanPham}</a>
													</h4>
													<div class="price-box">
														Giá bán: <span class="new-price"><fmt:setLocale
																value="vi_VN" scope="session" /> <fmt:formatNumber
																value="${spMoi.gia}" type="currency" /> </span>
																<br> <span
															class="old-price"> <fmt:setLocale value="vi_VN"
																scope="session" /> <fmt:formatNumber
																value="${spMoi.giaGoc}" type="currency" />
														</span> <span class="discount-percentage">Tiết kiệm ${spMoi.phanTramGiam}%</span>

													</div>

												</div>
												<div class="add-actions">
													<ul class="add-actions-link">
														<li class="add-cart active"><c:if
																test="${user==null}">

																<button class="btn btn-success" onclick="Redirect();">Thêm
																	vào giỏ</button>
															</c:if> <c:if test="${user!=null}">

																<button class="btn btn-success"
																	onclick="addToCart(${spMoi.id},1)">Thêm vào
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
							<!--/new -->

						</div>
		</section>
		<!-- Li's Special Product Area End Here -->
		<!-- Begin Featured Product With Banner Area -->
		<div
			class="featured-pro-with-banner mt-sm-5 pb-sm-10 mt-xs-5 pb-xs-10">
			<div class="container">
				<div class="row">
					<!-- Begin Li's Featured Banner Area -->
					<div class="col-lg-3 text-center">
						<div class="single-banner featured-banner">
							<a href="#"> <img
								src="${base}/user/images/banner/featured-banner.jpg"
								alt="Li's Featured Banner">
							</a>
						</div>
					</div>
					<!-- Li's Featured Banner Area End Here -->
					<!-- Begin Featured Product Area -->
					<div class="col-lg-9">
						<div class="featured-product pt-sm-30 pt-xs-30">
							<div class="li-section-title">
								<h2>
									<span>Sản phẩm hot</span>
								</h2>
							</div>
							<div class="row">
								<c:forEach items="${spHot}" var="spHot">
									<div class="col-md-6 ">
										<div class="featured-product-bundle">
											<div class="featured-pro-wrapper mb-30 mb-sm-25">
												<div class="product-img">
													 <a href="${base}/sanphamchitiet/${spHot.id}"> <img
														alt="" src="${base}/upload${spHot.anhs.get(0).path}"
														style="width: 170px; height: 162px">
													</a>  
													
												</div>
												<div class="featured-pro-content">
													<div class="product-review">
														<h5 class="manufacturer">
															<a href="${base}/sanphamchitiet/${spHot.id}">Mã sản
																phẩm:${spHot.seo}</a>
														</h5>
													</div>

													<h4>
														<a class="featured-product-name"
															href="${base}/sanphamchitiet/${spHot.id}">${spHot.tenSanPham}</a>
													</h4>
													<div class="featured-price-box">
														Giá bán: <span class="new-price"><fmt:setLocale
																value="vi_VN" scope="session" /> <fmt:formatNumber
																value="${spHot.gia}" type="currency" /> </span>
															<br> <span
															class="old-price"><strike> <fmt:setLocale value="vi_VN"
																scope="session" /> <fmt:formatNumber
																value="${spHot.giaGoc}" type="currency" /></strike>
														</span> <span class="discount-percentage">Tiết kiệm ${spHot.phanTramGiam}%</span>

													</div>
													<div class="featured-product-action">
														<ul class="add-actions-link">
															<li class="add-cart active"><c:if
																	test="${user==null}">

																	<button class="btn btn-success" onclick="Redirect();">Thêm
																		vào giỏ</button>
																</c:if> <c:if test="${user!=null}">

																	<button class="btn btn-success"
																		onclick="addToCart(${spHot.id},1);">Thêm vào
																		giỏ</button>
																</c:if></li>

														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- Featured Product Area End Here -->
				</div>
			</div>
		</div>
		<!-- Featured Product With Banner Area End Here -->
		<!-- Begin Li's Laptop Product Area -->
		<section class="product-area li-laptop-product pt-60 pb-45">
			<div class="container">

				<!-- Laptop -->
				<div class="row">
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2>
								<span>Laptop</span>
							</h2>
						</div>
						<div class="row">
							<div class="special-product-active owl-carousel">
								<c:forEach items="${spvp}" var="spMoi">
									<div class="col-lg-12">
								<!-- single-product-wrap start -->
										<div class="single-product-wrap">
											<div class="product-image">
												 <a href="${base}/sanphamchitiet/${spMoi.id}"> <img
													src="${base}/upload${spMoi.anhs.get(0).path}" alt="Li's Product Image">
												 
											</div>
											<div class="product_desc">
												<div class="product_desc_info">
													<div class="product-review">
														<h5 class="manufacturer">
															<a href="${base}/sanphamchitiet/${spMoi.id}">${spMoi.seo}</a>
														</h5>
													</div>
													<h4>
														<a class="product_name"
															href="${base}/sanphamchitiet/${spMoi.id}">${spMoi.tenSanPham}</a>
													</h4>
													<div class="price-box">
														Giá bán: <span class="new-price"><fmt:setLocale
																value="vi_VN" scope="session" /> <fmt:formatNumber
																value="${spMoi.gia}" type="currency" /> </span>
																<br> <span
															class="old-price"> <fmt:setLocale value="vi_VN"
																scope="session" /> <fmt:formatNumber
																value="${spMoi.giaGoc}" type="currency" />
														</span> <span class="discount-percentage">Tiết kiệm ${spMoi.phanTramGiam}%</span>
													</div>

												</div>
												<div class="add-actions">
													<ul class="add-actions-link">
														<li class="add-cart active"><c:if
																test="${user==null}">

																<button class="btn btn-success" onclick="Redirect();">Thêm
																	vào giỏ</button>
															</c:if> <c:if test="${user!=null}">

																<button class="btn btn-success"
																	onclick="addToCart(${spMoi.id},1)">Thêm vào
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
							<!--/laptop -->
							<!-- Li's Section Area End Here -->

						</div>
					</div>
		</section>
		<section class="product-area li-laptop-product pt-60 pb-45">
			<div class="container">
				<!-- pc -->
				<div class="row">
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2>
								<span>PC</span>
							</h2>
						</div>
						<div class="row">
							<div class="special-product-active owl-carousel">
								<c:forEach items="${pc}" var="pc">
									<div class="col-lg-12">

										<!-- single-product-wrap start -->
										<div class="single-product-wrap">
											<div class="product-image">
												 <a href="${base}/sanphamchitiet/${pc.id}"> <img
													src="${base}/upload${pc.anhs.get(0).path}" alt="Li's Product Image">
												</a>  
											</div>
											<div class="product_desc">
												<div class="product_desc_info">
													<div class="product-review">
														<h5 class="manufacturer">
															<a href="${base}/sanphamchitiet/${pc.id}">${pc.seo}</a>
														</h5>

													</div>
													<h4>
														<a class="product_name"
															href="${base}/sanphamchitiet/${pc.id}">${pc.tenSanPham}</a>
													</h4>
													<div class="price-box">
														Giá bán: <span class="new-price"><fmt:setLocale
																value="vi_VN" scope="session" /> <fmt:formatNumber
																value="${pc.gia}" type="currency" /> </span>
																<br> <span
															class="old-price"> <fmt:setLocale value="vi_VN"
																scope="session" /> <fmt:formatNumber
																value="${pc.giaGoc}" type="currency" />
														</span><span class="discount-percentage">Tiết kiệm ${pc.phanTramGiam}%</span>
													</div>

												</div>
												<div class="add-actions">
													<ul class="add-actions-link">
														<li class="add-cart active"><c:if
																test="${user==null}">

																<button class="btn btn-success" onclick="Redirect();">Thêm
																	vào giỏ</button>
															</c:if> <c:if test="${user!=null}">

																<button class="btn btn-success"
																	onclick="addToCart(${pc.id},1)">Thêm vào giỏ</button>
															</c:if></li>

													</ul>
												</div>
											</div>
										</div>
										<!-- single-product-wrap end -->
									</div>
								</c:forEach>
							</div>
							<!--/PC -->
						</div>
		</section>
		<!-- Li's Laptop Product Area End Here -->

		<!-- Begin Li's Static Banner Area -->
		<div class="li-static-banner li-static-banner-3 text-center mt-5">
			<div class="container">
				<div class="row">
					<!-- Begin Single Banner Area -->
					<div class="col-lg-6 col-md-6">
						<div class="single-banner pb-xs-30">
							<a href="#"> <img src="${base}/user/images/banner/4.jpg"
								alt="Li's Static Banner">
							</a>
						</div>
					</div>
					<!-- Single Banner Area End Here -->
					<!-- Begin Single Banner Area -->
					<div class="col-lg-6 col-md-6">
						<div class="single-banner">
							<a href="#"> <img src="${base}/user/images/banner/5.jpg"
								alt="Li's Static Banner">
							</a>
						</div>
					</div>
					<!-- Single Banner Area End Here -->
				</div>
			</div>
		</div>
		<!-- Li's Static Banner Area End Here -->
		<!-- Begin Li's Trending Product Area -->
		<section class="product-area li-trending-product pt-60 pb-45 pt-xs-50">
		</section>
		<!-- Li's Trending Product Area End Here -->
		<jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
	</div>
	<!-- Body Wrapper End Here -->
	<jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
</body>
<!-- index-331:41-->
</html>
