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
						<h4 class="page-title">Danh sách sản phẩm</h4>
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

							<li class="active">Quản lý sản phẩm</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Danh sách sản phẩm</h3>


							<button class="add">
								<i class="fa fa-plus-square"></i><a
									href="${base}/admin1/sanpham/themsanpham">Thêm sản phẩm</a>
							</button>


							<!-- <p class="text-muted">Add class <code>.table</code></p> -->
							<div class="table-responsive">
								<span><b>Số sản phẩm: ${tongSP }</b></span>
								<table class="table table-striped">
									<thead class="thead-dark" style="text-align:center">
										<tr>
											<th>No.</th>
											<th>Mã sản phẩm</th>
											<th>Tên sản phẩm</th>
											<th>Số lượng</th>
											<th>Giá</th>
											<th>Thương hiệu</th>
											<th>Thời gian bảo hành</th>
											<th>Danh mục</th>
											<th>Giá gốc</th>
											<th>Tùy chọn</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listSP}" var="sp" varStatus="loop">
											<tr>

												<td>${loop.index+1}</td>
												<td>${sp.id}</td>
												<td>${sp.tenSanPham}</td>
												<td>${sp.soLuong}</td>
												<td>
													<!-- định dạng tiền VNĐ --> <fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${sp.gia }"
														type="currency" />
												</td>

												<td>${sp.thuongHieus.tenThuongHieu}</td>
												<td>
												<c:if test="${sp.baoHanh==1}">6 tháng</c:if>
												<c:if test="${sp.baoHanh==2}">12 tháng</c:if>
												<c:if test="${sp.baoHanh==3}">24 tháng</c:if>
												</td>
												
												<td>${sp.danhMucs.tenDanhMuc}</td>
												<td><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${sp.giaGoc }"
														type="currency" /></td>
												<td>
													<div class="table-data-feature">

														<a href="${base}/admin1/sanpham/edit/${sp.id}" class="btn btn-primary"
															data-toggle="tooltip" data-placement="top" title="Edit">
															<i class="fa fa-edit"></i></i>
														</a>
														<button class="btn btn-danger" title="Delete"
															onclick="setIdDelete(${sp.id})" data-toggle="modal"
															data-target="#delete" type="button">
															<i class="fa fa-trash"></i>
														</button>
														<a href="${base}/admin1/sanpham/xemchitiet/${sp.id}" class="btn btn-success"
															data-toggle="tooltip" data-placement="top" title="View">
															<i class="fa fa-eye"></i></i>
														</a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<%-- <div class="row">
									<div class="col-lg-6 col-md-6 pt-xs-15">
										<!-- Phân trang -->
										<tag:paginate offset="${productSearch.offset}"
											count="${productSearch.count }" uri="${pageUrl}" />
									</div>
								</div> --%>
							</div>
						</div>
						<div class="modal fade" id="delete" aria-labelledby="deleteDM"
							aria-hidden=true>
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="deleteDM">Xóa sản phẩm</h5>
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
                                               <tag:paginate offset="${productSearch.offset}"
												count="${productSearch.count }" uri="${pageUrl}" />
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
    	form.setAttribute("action","/admin1/sanpham/delete/"+id+"");
    	console.log(id);
    }
    </script>
	<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>

</body>

</html>
