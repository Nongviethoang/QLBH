<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- shopping-cart31:32-->
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
         <title>Ngọc Hưng Computer</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
    </head>
    <body>
   
        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
            <jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="index.html">Trang chủ</a></li>
                            <li class="active">Giới thiệu</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!--Shopping Cart Area Strat-->
            <div class="Shopping-cart-area pt-60 pb-60">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                        <div id="vnson_content_wrapper_default" style="color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px;"><strong style="font-weight: bold;">Máy tính&nbsp;Ngọc Hưng</strong>&nbsp;- là một đơn vị kinh doanh các&nbsp;sản phẩm CNTT uy tín tại Hà Nội. Chuyên&nbsp;<strong style="color: rgb(32, 95, 160); font-weight: bold;"><a href="http://suamaytinhhaiduong.vn/" style="color: rgb(32, 95, 160);">Sửa máy tính tại </a>Hà Nội</strong>,&nbsp;<strong style="font-weight: bold;">sửa máy in chuyên nghiệp tại Hà Nội.&nbsp;</strong>Ngọc Hưng đã tạo được chỗ đứng vững chắc trên thị trường bán buôn, bán lẻ, trở thành thương hiệu quen thuộc và là đối tác tin cậy của nhiều khách hàng khu vực quanh địa bàn Hải Dương và các tỉnh lân cận.<br><br><strong style="font-weight: bold; font-size: 18.6667px;">Ngọc Hưng</strong>&nbsp;luôn lấy yếu tố hài hòa về lợi ích làm nền tảng niềm tin của khách hàng về giá thành, chất lượng và dịch vụ là sự sống còn của&nbsp;<strong style="font-weight: bold; font-size: 18.6667px;">Ngọc Hưng</strong>. Do vậy, mọi hoạt động kinh doanh của Hoàng Tăng luôn hướng tới mục tiêu tôn trọng và bảo đảm quyền lợi cho khách hàng, chinh phục khách hàng bằng chất lượng sản phẩm và dịch vụ tối ưu.<br><br>&nbsp;Mục tiêu của Cửa hàng máy tính&nbsp;<strong style="font-weight: bold; font-size: 18.6667px;">Ngọc Hưng</strong>:</div><ul style="list-style: none; color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px;"><li style="margin-bottom: 10px;"><em><strong style="font-weight: bold;">&nbsp;Con người là vốn quý!</strong></em></li><li style="margin-bottom: 10px;"><em><strong style="font-weight: bold;">&nbsp;Nhã nhặn, niềm nở, lịch sự khi giao tiếp với khách hàng, tối đa lợi ích khách hàng</strong></em></li><li style="margin-bottom: 10px;"><em><strong style="font-weight: bold;">&nbsp;Xây dựng, duy trì và phát triển hệ thống phân phối mạnh và phủ sóng</strong></em></li><li style="margin-bottom: 0px;"><em><strong style="font-weight: bold;">&nbsp;Trở thành nhà phân phối có tên tuổi và uy tín trên thị trường&nbsp;</strong></em></li></ul><div style="color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px;"><strong style="font-weight: bold;">CÁC LĨNH VỰC HOẠT ĐỘNG:</strong></div><ul style="list-style: none; color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px;"><li style="margin-bottom: 10px;">- Tin học</li><li style="margin-bottom: 10px;">- Điện tử</li><li style="margin-bottom: 0px;">- Viễn thông</li></ul><div style="color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px; margin-left: 40px;"><em><strong style="font-weight: bold;">Đặc biệt trong lĩnh vực tin học Công ty chú trọng các họat động như:</strong></em></div><div style="color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px;">&nbsp;</div><ul style="list-style: none; color: rgb(0, 0, 0); font-family: &quot;Times New Roman&quot;, serif; font-size: 18.6667px;"><li style="margin-bottom: 10px;">- Thiết kế giải pháp tổng thể (thiết kế hệ thống, xây dựng mạng LAN, WAN,..)</li><li style="margin-bottom: 10px;">- Cung cấp các thiết bị tin học (Máy chủ, máy tính PC, máy tính NOTEBOOKS, các thiết bị ngoại vi, các ứng dụng.)</li><li style="margin-bottom: 10px;">- Cung cấp phần mềm của các hãng trên thế giới, các phần mềm quản lý, truyền thông...</li><li style="margin-bottom: 10px;">- Tư vấn và đào tạo cho khách hàng.</li><li style="margin-bottom: 10px;">- Các dịch vụ bảo hành, bảo trì...</li></ul>
                        </div>
                    </div>
                </div>
            </div>
            <!--Shopping Cart Area End-->
            <jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
        </div>
        <jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
    </body>

<!-- shopping-cart31:32-->
</html>
