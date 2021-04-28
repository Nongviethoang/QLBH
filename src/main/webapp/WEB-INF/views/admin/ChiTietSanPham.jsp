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
						<h4 class="page-title">Chi tiết sản phẩm</h4>
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

							<li class="active">Chi tiết sản phẩm</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				 <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">Chi tiết sản phẩm</h3>

                                
                        <button class="add">
                                           <i class="fa fa-angle-double-left"></i><a href="${base}/admin1/sanpham">Danh sách sản phẩm</a>   </button> 

                            <style type="text/css">
                            table tr td:first-child{
                                width:200px;
                                
                                 
                            }
                            
                            </style>
                            <!-- <p class="text-muted">Add class <code>.table</code></p> -->
                            <div class="table-responsive">
                                <table class="table table-striped">
                                        <tr  >
                                            <td>ID</td>
                                            <td>${sanpham.id}</td>
                                        </tr>
                                        <tr>
                                            <td>Tên sản phẩm</td>
                                            <td>${sanpham.tenSanPham}</td>
                                        </tr>
                                          
                                        <tr>
                                            <td>Giá gốc</td>
                                            <td><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${sanpham.giaGoc }"
														type="currency" /></td>
                                        </tr>
                                        <tr>
                                            <td>Giá khuyến mãi</td>
                                            <td><fmt:setLocale value="vi_VN"
														scope="session" /> <fmt:formatNumber value="${sanpham.gia }"
														type="currency" /></td>
                                        </tr>
                                        <tr>
                                           
                                            <td>Số lượng còn</td>
                                            <td>${sanpham.soLuong}</td>
                                        </tr>
                                        <tr>
                                            <td>Mã sản phẩm bán</td>
                                            <td>${sanpham.seo}</td>
                                        </tr>
                                        <tr>
                                           
                                            <td>Danh mục</td>
                                            <td>${sanpham.danhMucs.tenDanhMuc}</td>
                                        </tr>
                                        <tr>
                                           
                                            <td>Thương hiệu</td>
                                            <td>${sanpham.thuongHieus.tenThuongHieu}</td>
                                        </tr>
                                        
                                         
                                         <tr>
                                            <td>Thời gian bảo hành</td>
                                            <c:if test="${sanpham.baoHanh==1}">
                                             <td>6 tháng</td>
                                            </c:if>
                                           <c:if test="${sanpham.baoHanh==2}">
                                             <td>12 tháng</td>
                                            </c:if>
                                            <c:if test="${sanpham.baoHanh==3}">
                                             <td>24 tháng</td>
                                            </c:if>
                                            
                                        </tr>
                                        <tr>
                                        <td>Số sản phẩm đã bán</td>
                                            <td>${sanpham.soLuongBan}</td>
                                        </tr>
                                         <tr>
                                        <td>Số lần được mua</td>
                                            <td>${sanpham.soLanMua}</td>
                                        </tr>
                                         <tr>
                                        <td>Ngày tạo</td>
                                            <td>${sanpham.createDate}</td>
                                        </tr>
                                         <tr>
                                       
                                    </tbody>
                                </table>
                                
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                <div class="col-md-12">
                <span>Cấu hình</span>
                <p>${sanpham.cauHinh}</p>
                </div>
                </div>
                <div class="row">
                <div class="col-md-12">
                <span>Đánh giá</span>
                <p>${sanpham.gioiThieu}</p>
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
