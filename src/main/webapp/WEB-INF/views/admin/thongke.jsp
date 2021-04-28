<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/pagingTagLibs.tld"%>
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
<style type="text/css">
table a
{
text-align: center;
display: block;
color: black;
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
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					
					</div>
					<div class="col-lg-3 col-sm-4 col-md-4 col-xs-12">
                        <ul class="nav navbar-top-links navbar-right pull-right">
                           
                        </ul>
                    </div>
					<div class="col-lg-6 col-sm-4 col-md-4 col-xs-12">
						<ol class="breadcrumb">

							
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<div class="row">
				<div class="col-md-12">
				<h4>Thống kê đơn hàng và sản phẩm tháng hiện tại</h4>
				<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>Tổng số đơn hàng</th>
									<th>Tổng đơn hàng giao thành công</th>
									<th>Tổng đơn hàng đã hủy</th>
									<th>Doanh thu</th>
									<th>Tổng số sản phẩm tồn</th>
									<th>Tổng số sản phẩm bán</th>
									<th>Sản phẩm bán chạy nhất</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><a href="${base}/admin1/donhangthangnay">${tongdon}</a></td>
									<td><a href="${base}/admin1/donhang/donhangthang/${4}">${dongiao}</a></td>
									<td><a href="${base}/admin1/donhang/donhangthang/${5}">${donhuy}</a></td>
									<td><a href="#"><fmt:setLocale
										value="vi_VN" scope="session" /> <fmt:formatNumber
										value="${doanhthuthang}" type="currency" /></a></td>
									<td><a href="#">${hangton}</a></td>
									<td><a href="#">${hangban}</a></td>
									<td><a href="${base}/admin1/sanphamhot/${hanghot}">${hanghot}</a></td>
								</tr>
							</tbody>
						</table>
				</div>
				</div>
				<!-- /.row -->
				<!-- thống kê theo thời gian -->
				<div class="row">
					<div class="col-md-12">
						<h4>Thống kê theo thời gian</h4>
						<form action="${base}/admin1/thongke" method="get">
						<c:if test="${start==null&&end==null}">
							Từ ngày<input type="date" name="start" /> Đến ngày<input
								type="date" name="end" /> <input type="submit"
								class="btn btn-danger" value="Lọc">
						</c:if>
						<c:if test="${start!=null&&end!=null}">
							Từ ngày<input type="date" value="${start}" name="start" /> Đến ngày<input
								type="date" value="${end}" name="end" /> 
								<input type="submit" 
								class="btn btn-danger" value="Lọc">
						</c:if>
					
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>Tổng số đơn hàng</th>
									<th>Tổng đơn hàng giao thành công</th>
									<th>Tổng đơn hàng đã hủy</th>
									<th>Doanh thu</th>
									<th>Tổng số sản phẩm tồn</th>
									<th>Tổng số sản phẩm bán</th>
									<th>Sản phẩm bán chạy nhất</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><a href="${base}/admin1/donhangthangloc/${start}/${end}">${tongdont}</a></td>
									<td><a href="${base}/admin1/donhang/donhangthangloc/${4}/${start}/${end}">${dongiaot}</a></td>
									<td><a href="${base}/admin1/donhang/donhangthangloc/${5}/${start}/${end}">${donhuyt}</a></td>
									<td><a href="#"><fmt:setLocale
										value="vi_VN" scope="session" /> <fmt:formatNumber
										value="${doanhthuthangt}" type="currency" /></a></td>
									<td><a href="#">${hangtont}</a></td>
									<td><a href="#">${hangbant}</a></td>
									<td><a href="${base}/admin1/sanphamhot/${hanghott}">${hanghott}</a></td>
								</tr>
							</tbody>
						</table>
					</form>
					</div>
				</div>
				<!-- /end -->
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>
</body>
</html>
>