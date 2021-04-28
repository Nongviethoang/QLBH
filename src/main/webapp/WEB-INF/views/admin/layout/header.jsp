<%@page import="com.haui.SaleLaptop.entities.ThanhVienEntity"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
    <%
String name="";
Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
if(principal instanceof UserDetails)
{
	name=((ThanhVienEntity)principal).getHoTen();
}
%>
<!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <div class="top-left-part">
                    <!-- Logo -->
                    <a class="logo" >
                        <!-- Logo icon image, you can use font-icon also --><b>
                        <!--This is dark logo icon--><img src="${base}/admin/plugins/images/admin-logo.png" alt="home" class="dark-logo" /><!--This is light logo icon--><img src="${base}/admin/plugins/images/admin-logo-dark.png" alt="home" class="light-logo" />
                     </b>
                        <!-- Logo text image you can use text also --><span class="hidden-xs">
                        <!--This is dark logo text--><img src="${base}/admin/plugins/images/admin-text.png" alt="home" class="dark-logo" /><!--This is light logo text--><img src="${base}/admin/plugins/images/admin-text-dark.png" alt="home" class="light-logo" />
                     </span> </a>
                </div>
                <!-- /Logo -->
                <ul class="nav navbar-top-links navbar-right pull-right">
                    
                    <li>
                        <a class="profile-pic" href="#"><i class="fa fa-user">Xin chào <%=name %></i></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- End Top Navigation -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
       <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
                </div>
                <ul class="nav" id="side-menu">
                <li style="padding: 70px 0 0;" class="active">
                        <a href="/admin1" class="waves-effect"><i class="fa fa-home fa-fw" aria-hidden="true"></i> Trang chủ</a>
                    </li>
                    <li >
                        <a href="/admin1/danhmuc" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>Quản lí danh mục</a>
                    </li>
                    
                    <li>
                        <a href="/admin1/sanpham" class="waves-effect"><i class="fa fa-product-hunt fa-fw" aria-hidden="true"></i>Quản lý sản phẩm</a>

                    </li>
                    <li>
                        <a href="/admin1/anhsanpham" class="waves-effect"><i class="fa fa-image fa-fw" aria-hidden="true"></i>Quản lý ảnh sản phẩm</a>
                    </li>
                    <li>
                        <a href="/admin1/thuonghieu" class="waves-effect"><i class="fa fa-bold fa-fw" aria-hidden="true"></i>Quản lý thương hiệu</a>

                    </li>
                    <li>
                        <a href="/admin1/donhang" class="waves-effect"><i class=" fa fa-shopping-cart fa-fw" aria-hidden="true"></i>Quản lý đơn hàng</a>

                    </li>
                    <li>
                        <a href="/admin1/thanhvien" class="waves-effect"><i class="fa fa-users fa-fw" aria-hidden="true"></i>Quản lý thành viên</a>

                    </li>
                    <li>
                        <a href="/admin1/lienhe" class="waves-effect"><i class="fa fa-commenting-o fa-fw" aria-hidden="true"></i>Quản lý câu hỏi</a>

                    </li>
                    <li>
                        <a href="/admin1/quyen" class="waves-effect"><i class="fa fa-user fa-fw" aria-hidden="true"></i>Quản lý quyền</a>

                    </li>
                 
                    <li>
                        <a href="/admin1/binhluan" class="waves-effect"><i class="fa fa-comment fa-fw" aria-hidden="true"></i>Bình luận</a>
                    </li>
                     <li>
                        <a href="/admin1/thongke" class="waves-effect"><i class="fa fa-bar-chart fa-fw" aria-hidden="true"></i>Thống kê</a>
                    </li>
                    <li>
                        <a href="/logout" class="waves-effect"><i class="fa fa-sign-out fa-fw" aria-hidden="true"></i> Đăng xuất</a>
                    </li>
                </ul>
                
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- End Left Sidebar -->
        <!-- ============================================================== -->