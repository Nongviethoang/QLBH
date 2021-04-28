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
						<h4 class="page-title">${danhmuc.id!=null?'Sửa danh mục':'Thêm danh mục' }</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<ol class="breadcrumb">

							<li class="active">${danhmuc.id!=null?'Sửa danh mục':'Thêm danh mục' }</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row row-main">

					<div class="col-md-12 col-xs-12">
						<div class="white-box">
							<sf:form class="form-horizontal form-material"
								action="${base}/admin1/danhmuc/themdanhmuc" method="post"
								modelAttribute="danhmuc" enctype="multipart/form-data">
								<sf:hidden path="id" />
								<div class="form-group">
									<label class="col-md-12">Tên danh mục</label>
									<div class="col-md-12">
										<sf:input path="tenDanhMuc" required="required" type="text"
											placeholder="Tên danh mục" name="tendanhmuc"
											class="form-control form-control-line" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-12">Mô tả</label>
									<div class="col-md-12">
										<sf:textarea path="moTa" required="required" type="text"
											id="motadanhmuc" placeholder="Mô tả" name="mota"
											class="form-control form-control-line" />
									</div>
								</div>
								<%--  <c:if test="${danhmuc.id!=null}"> --%>
								<div class="form-group">
									<label class="col-md-12">Các danh mục con</label>
									<div class="col-md-12">

										<sf:select class="form-control form-control-line"
											path="childs">
											
											<option value="">Không có danh mục con</option>
											<sf:options items="${listDanhMuc}" itemValue="id"
												itemLabel="tenDanhMuc" />
										</sf:select>
									</div>
								</div>
								<%--  </c:if> --%>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn btn-success">${danhmuc.id!=null?'Sửa':'Thêm' }</button>
									</div>
								</div>
							</sf:form>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->

		</div>
	</div>

	<jsp:include page="/WEB-INF/views/admin/layout/js.jsp"></jsp:include>


</body>

</html>
