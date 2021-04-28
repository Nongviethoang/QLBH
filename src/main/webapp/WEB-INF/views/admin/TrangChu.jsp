<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
<jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
</head>
<style>
.order {
	color: black;
	font-size: 20px;
	font-weight: bold;
	text-align: center;
}

.order img {
	height: 250px;
	width: 250px;
}
</style>
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
		<!-- ============================================================== -->
		<jsp:include page="/WEB-INF/views/admin/layout/header.jsp"></jsp:include>

		<!-- ============================================================== -->
		<!-- Page Content -->
		<!-- ============================================================== -->
		<div id="page-wrapper">
			<div class="container-fluid">


				<div class="row row-main justify-content-center">
					<div class="col-md-12 mt-5">

						<h1>Trang quản trị của hàng bán máy tính Ngọc Hưng</h1>
					</div>


				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="order">
							<div class="col-md-12">
								<img src="${base}/admin/plugins/images/donhang.jpg" alt="">
								Đơn giao thành công: ${donHang}
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="order">
							<div class="col-md-12">
								<img src="${base }/admin/plugins/images/sanpham.jpg" alt="">
								Số sản phẩm còn:${soLuongSp}
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="order">
							<div class="col-md-12">
								<img src="${base }/admin/plugins/images/doanhthu.png" alt="">

								<span class="new-price">Doanh thu: <fmt:setLocale
										value="vi_VN" scope="session" /> <fmt:formatNumber
										value="${doanhThu }" type="currency" />
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="order">
							<div class="col-md-12">
								<img src="${base }/admin/plugins/images/thanhvien.jpg" alt="">
								Tổng số thành viên:${thanhVien}
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<!-- /.container-fluid -->
		</div>
	</div>
	</div>
	<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>

</body>

</html>
