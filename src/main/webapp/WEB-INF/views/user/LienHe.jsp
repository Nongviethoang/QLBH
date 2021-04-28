<!-- sử dụng tiếng việt -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- Paging -->
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/pagingTagLibs.tld"%>

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
        <jsp:include page="/WEB-INF/views/valiable.jsp"></jsp:include>
        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
            <jsp:include page="/WEB-INF/views/user/layout/header.jsp"></jsp:include>
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="/">Trang chủ</a></li>
                            <li class="active">Liên hệ</li>
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
                           
                                <div class="row justify-content-center">
                                    <div class="col-6">
                                        <sf:form class="form-horizontal form-material" action="${base}/gui-lienhe" method="post" modelAttribute="lienhe" enctype="multipart/form-data">
                                            <div class="checkbox-form">
                                                <h3>Bạn có thắc mắc, câu hỏi hãy liên hệ với chúng tôi</h3>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label>Họ và tên<span class="required">*</span></label>
                                                            <sf:input required="required"  path="hoTen"  placeholder="Họ tên" type="text" id="hoTen" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label>Email <span class="required">*</span></label>
                                                            <sf:input path="email" required="required"  placeholder="email" type="email" id="email"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label>Số điện thoại  <span class="required">*</span></label>
                                                            <sf:input path="soDienThoai" required="required"  placeholder="Số điện thoại" id="soDienThoai" type="text"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                            <label>Nội dung <span class="required">*</span></label>
                                                            <sf:textarea path="noiDung" required="required"  id="noiDung"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="checkout-form-list">
                                                           
                                                            <input type="submit" onclick="alert('Cảm ơn bạn đã gửi thông tin đến chúng tôi')" value="Gửi" class="btn btn-primary">
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                
                                            </div>
                                        </sf:form>
                                    </div>
                                </div>
                           
                        </div>
                    </div>
                </div>
            </div>
          <script type="text/javascript">
          $(".reset").click(function() {
        	    $(this).closest('form').find("input[type=text], textarea").val("");
        	   
        	});
          </script>
            <!--Shopping Cart Area End-->
           <jsp:include page="/WEB-INF/views/user/layout/footer.jsp"></jsp:include>
        </div>
       <jsp:include page="/WEB-INF/views/user/layout/js.jsp"></jsp:include>
    </body>

<!-- shopping-cart31:32-->
</html>
