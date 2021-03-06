<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
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
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
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
                        <h4 class="page-title">Th??m s???n ph???m</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            
                            <li class="active">Th??m s???n ph???m</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row row-main">
                   
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            <sf:form class="form-horizontal form-material" modelAttribute="sanpham" action="${base}/admin1/sanpham/themsanpham" method="post" enctype="multipart/form-data"  >
                                 <sf:hidden path="id"/>
                                  <sf:hidden path="seo"/>
                                  
                                 <div class="form-group">
                                    <label class="col-md-12">T??n s???n ph???m</label>
                                    <div class="col-md-12">
                                        <sf:input path="tenSanPham" required="required" type="text" placeholder="T??n s???n ph???m"  name="tensanpham" class="form-control form-control-line"/> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">S??? l?????ng</label>
                                    <div class="col-md-12">
                                        <sf:input path="soLuong" required="required" type="number" id="number" placeholder="T??n s???n ph???m"  name="soLuong" class="form-control form-control-line"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Gi?? b??n</label>
                                    <div class="col-md-12">
                                        <sf:input path="gia" required="required" type="text" placeholder="Gi?? b??n" id="price"  name="gia" class="form-control form-control-line"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Gi?? g???c</label>
                                    <div class="col-md-12">
                                        <sf:input path="giaGoc" required="required" type="text" placeholder="Gi?? b??n" id="pricesale"  name="giagoc" class="form-control form-control-line"/> </div>
                                </div>
                               <!--  <div class="form-group">
                                    <label class="col-md-12">???nh</label>
                                    <div class="col-md-12">
                                        <input name="anh" type="file" class="form-control form-control-line"> </div>
                                </div> -->
                                
                                 
                                    
                                    <div class="col-md-12">
                                     
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Th????ng hi???u</label>
                                    <div class="col-md-12">
                                         <sf:select class="form-control form-control-line" path="thuongHieus.id">
                                          <%--  <sf:option  value="${}"></sf:option> --%>
                                           <sf:options items="${listThuongHieu}" itemLabel="tenThuongHieu" itemValue="id" />
                                        </sf:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Danh m???c</label>
                                    <div class="col-md-12">
                                         <sf:select class="form-control form-control-line" path="danhMucs.id">
                                          <%--  <sf:option  value="${}"></sf:option> --%>
                                           <sf:options items="${listDanhMuc}" itemLabel="tenDanhMuc" itemValue="id" />
                                           
                                        </sf:select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-12">C???u h??nh</label>
                                    <div class="col-md-12">
                                        <sf:textarea required="required"  path="cauHinh" type="text"  id="motasanpham" name="cauhinh" placeholder="C???u h??nh" class="form-control form-control-line"/> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">????nh gi??</label>
                                    <div class="col-md-12">
                                        <sf:textarea required="required"  path="gioiThieu" type="text"  id="gioithieu" name="cauhinh" placeholder="C???u h??nh" class="form-control form-control-line"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Th???i gian b???o h??nh</label>
                                    <div class="col-md-12">
                                        <sf:select required="required"  path="baoHanh">
                                        <sf:option value="1">6 th??ng</sf:option>
                                         <sf:option value="2">12 th??ng</sf:option>
                                          <sf:option value="3">24 th??ng</sf:option>
                                        </sf:select>
                                      </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" onclick="return checkNumber();" class="btn btn-success">${sanpham.id==null?'Th??m':'S???a' }</button>
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
