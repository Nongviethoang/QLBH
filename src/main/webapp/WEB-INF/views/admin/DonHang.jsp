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
						<h4 class="page-title">Đơn hàng</h4>
					</div>
					<div class="col-lg-3 col-sm-4 col-md-4 col-xs-12">
                        <ul class="nav navbar-top-links navbar-right pull-right">
                            <li>
                                <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                                    <input type="text" placeholder="Tìm kiếm..." class="form-control"> <a href=""><i class="fa fa-search"></i></a> </form>
                            </li>
                        </ul>
                    </div>
					<div class="col-lg-6 col-sm-4 col-md-4 col-xs-12">
						<ol class="breadcrumb">

							<li class="active">Quản lý đơn hàng</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Danh sách đơn hàng</h3>
							<ul style="display: flex;">
							<li> <a href="${base}/admin1/donhang/trangthai/${1}" class="btn btn-warning">Chưa duyệt</a></li>
							<li> <a href="${base}/admin1/donhang/trangthai/${2}" class="btn btn-success">Đã duyệt</a></li>
							<li> <a href="${base}/admin1/donhang/trangthai/${3}" class="btn btn-danger">Đang giao</a></li>
							<li> <a href="${base}/admin1/donhang/trangthai/${4}" class="btn btn-info">Đã giao</a></li>
							<li> <a href="${base}/admin1/donhang/trangthai/${5}" class="btn btn-primary">Đơn hủy</a></li>
							</ul>
							
								<!-- <p class="text-muted">Add class <code>.table</code></p> -->
								<div class="table-responsive">
									<table class="table table-striped">
										<thead class="thead-dark">
											<tr>
												<th>No.</th>
												<th>Mã đơn hàng</th>
												<th>Tên khách hàng</th>
												<th>Ngày lập</th>
												<th>Địa chỉ</th>
												<th>Số điện thoại</th>
												<th>Tổng tiền</th>
												<th>Tình trạng</th>
												<th>Lựa chọn</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${donHangs}" var="dh" varStatus="loop">
												<tr>
													<td>${loop.index+1}</td>
													<td>${dh.id}</td>
													<td>${dh.tenKhachHang}</td>
													<td>${dh.ngayLap}</td>
													<td>${dh.diaChi}</td>
													<td>${dh.soDienThoai}</td>
													<td>${dh.tongTien}</td>
													<td>
													<c:if test="${dh.trangThai==1}">
													<button class="btn btn-warning">Chưa duyệt</button>
													</c:if>
													<c:if test="${dh.trangThai==2}">
													<button class="btn btn-success">Đã duyệt</button>
													</c:if>
													<c:if test="${dh.trangThai==3}">
													<button class="btn btn-danger">Đang giao</button>
													</c:if>
													<c:if test="${dh.trangThai==4}">
													<button class="btn btn-info">Đã giao</button>
													</c:if>
													<c:if test="${dh.trangThai==5}">
													<button class="btn btn-primary">Đã hủy</button>
													</c:if>
													</td>
													<td>
															<c:if test="${dh.trangThai!=5}">
															<a href="${base}/admin1/donhang/chitiet/${dh.id}" class="btn btn-primary"
																data-toggle="tooltip" data-placement="top" title="Xem">
																<i class="fa fa-eye"></i>
															</a> 
															<c:if test="${dh.trangThai==1}">
															<button class="btn btn-danger" title="Delete"
															onclick="setIdDelete(${dh.id})" data-toggle="modal"
															data-target="#delete" type="button">
															<i class="fa fa-trash"></i>
															</button>
															</c:if>
															</c:if>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
						</div>
						<div class="modal fade" id="delete" aria-labelledby="deleteDM"
							aria-hidden=true>
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="deleteDM">Xóa đơn hàng</h5>
										<button type="button" class="close" data-disiss="modal">&times;</button>
									</div>
									<form id="formDelete" method="get" action="">
										<div class="modal-body">Bạn có chắc muốn xóa?</div>
										<div class="modal-footer">
											<button type="button" class="btn bt-secondary"
												data-dismiss="modal">Hủy</button>
											<button type="submit" class="btn bt-succes">Đồng ý</button>
										</div>

									</form>

								</div>
							</div>

						</div>
						<div class="paginatoin-area">
							<div class="row">
								<div class="col-lg-6 col-md-6 pt-xs-15">

									<!-- Phân trang -->
									<tag:paginate offset="${page.offset}" count="${page.count }"
										uri="${pageUrl}" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->

			</div>

		</div>
		<!-- /#page-wrapper -->
	</div>
	<script type="text/javascript">
    function setIdDelete(id)
    {
    	var form=document.getElementById("formDelete");
    	form.setAttribute("action","/admin1/huydonhangadmin/"+id+"");
    	console.log(id);
    }
    </script>
	<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>

</body>

</html>
