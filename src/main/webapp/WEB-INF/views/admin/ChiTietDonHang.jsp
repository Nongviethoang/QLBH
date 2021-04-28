<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="plugins/images/favicon.png">
<title>Administrator</title>

<jsp:include page="/WEB-INF/views/admin/layout/css.jsp"></jsp:include>
</head>

<body class="fix-header">
	<!-- ============================================================== -->
	<!-- Preloader -->
	<!-- ============================================================== -->
	<div class="preloader">
		<svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none"
				stroke-width="2" stroke-miterlimit="10" />
        </svg>
	</div>
	<!-- ============================================================== -->
	<!-- Wrapper -->
	<!-- ============================================================== -->
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/admin/layout/header.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- Page Content -->
		<!-- ============================================================== -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Danh chi tiết đơn hàng</h4>
					</div>
					<div class="col-lg-3 col-sm-4 col-md-4 col-xs-12"></div>
					<div class="col-lg-6 col-sm-4 col-md-4 col-xs-12">
						<ol class="breadcrumb">

							<li class="active">Chi tiết đơn hàng</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
				<div class="row">
					<div class="col-md-3">
						<h5>Mã đơn</h5>
						<span>${donHang.seo}</span>
					</div>
					<div class="col-md-6">
						<h5>Thông tin khách hàng</h5>
						<span>Họ và tên:${donHang.tenKhachHang}</span> <br> <span>Địa
							chỉ:${donHang.diaChi}</span> <br> <span>Số điện
							thoại:${donHang.soDienThoai}</span>
					</div>
					<div class="col-md-3">
						<h5>Ngày đặt hàng</h5>
						<span>${donHang.ngayLap}</span>
					</div>
				</div>
				<div class="row">

					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Danh sách chi tiết đơn hàng</h3>
							<!-- <p class="text-muted">Add class <code>.table</code></p> -->
							<button class="add">
								<i class="fa fa-plus-square"></i><a
									href="${base}/admin1/donhang">Danh sách đơn hàng</a>
							</button>
							<div class="table-responsive">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>No</th>
											<th>ID</th>

											<th>Tên sản phẩm</th>
											<th>Số lượng</th>
											<th>Thành tiền</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${chitiet}" var="ct" varStatus="loop">

											<tr>
												<td>${loop.index+1 }</td>
												<td>${ct.id}</td>

												<td>${ct.sanPhams.tenSanPham}</td>
												<td>${ct.soLuong}</td>
												<td><fmt:setLocale value="vi_VN" scope="session" /> <fmt:formatNumber
														value="${ct.soLuong*ct.sanPhams.gia}" type="currency" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
							<div class="row">
								<div class="col-md-4">
									<h5>
										Tổng tiền:
										<fmt:setLocale value="vi_VN" scope="session" />

										<fmt:formatNumber value="${donHang.tongTien}" type="currency" />
									</h5>
								</div>
								<div class="col-md-6">
									<form action="${base}/admin1/donhang/duyet/${donHang.id}">
										<div class="row">
											<div class="col-md-4">
												<c:if test="${tinhTrang!=null}">
													<select name="tinhTrang">
														<option>Tùy chọn</option>
														<c:if test="${tinhTrang==1}">
															<option value="1" selected="selected">Chưa duyệt</option>
															<option value="2">Đã duyệt</option>
															<option value="3">Giao</option>
														</c:if>
														<c:if test="${tinhTrang==2}">
															<option value="1">Chưa duyệt</option>
															<option value="2" selected="selected">Đã duyệt</option>
															<option value="3">Giao</option>
														</c:if>
														<c:if test="${tinhTrang==3}">
															<option value="1">Chưa duyệt</option>
															<option value="2">Đã duyệt</option>
															<option value="3" selected="selected">Giao</option>
														</c:if>
													</select>
												</c:if>
												<c:if test="${tinhTrang==null }">
													<select name="tinhTrang">
														<option>Tùy chọn</option>
														<option value="1">Chưa duyệt</option>
														<option value="2">Đã duyệt</option>
														<option value="3">Giao</option>
													</select>
												</c:if>



											</div>

											<button type="submit" class="btn btn-primary">Xác
												nhận</button>
												<c:if test="${tinhTrang==2}">
												<button type="submit" class="btn btn-danger ml-5">Xuất hóa đơn</button>
												</c:if>
										</div>
									</form>
								</div>
								<div class="col-md-2"></div>
							</div>
						</div>
					</div>
					<!-- /.row -->
				</div>

			</div>
			<!-- /#page-wrapper -->
		</div>
		<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>
</body>

</html>
