<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- login-register31:27-->
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Đăng nhập</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/WEB-INF/views/user/layout/css.jsp"></jsp:include>
</head>
<body>
	<!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	<!-- Begin Body Wrapper -->
	<div class="body-wrapper">
		<div class="page-section mb-60">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<!-- Login Form s-->
						<form action="/perform_login" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<div class="login-form">

								<h4 class="login-title">Đăng nhập</h4>
								<c:if test="${not empty param.login_error}">
									<div class="alert alert-danger" role="alert">Đăng nhập
										không thành công, vui lòng thử lại!!!</div>
								</c:if>
								<div class="row">
									<div class="col-md-12 col-12 mb-20">
										<label>Email</label>
										<input class="mb-0" name="username" type="email" placeholder="email">
									</div>
									<div class="col-12 mb-20">
										<label>Mật khẩu</label>
										<input class="mb-0" name="password" type="password" placeholder="Mật khẩu">
									</div>
									<label style="color: red">${errorlogin}</label>
									<div class="col-md-8">
										<div class="check-box d-inline-block ml-0 ml-md-2 mt-10">
											<input type="checkbox" id="remember_me"> <label
												for="remember_me">Ghi nhớ mật khẩu</label>
										</div>
									</div>
									<div class="col-md-4 mt-10 mb-20 text-left text-md-right">
										<a href="#"> Quên mật khẩu?</a>
									</div>
									<div class="col-md-12">
										<button type="submit" class="register-button mt-0">Đăng
											nhập</button>
										<button class="register-button mt-0">
											<a href="/dangki">Đăng kí</a>
										</button>
										<br> <br> <a href="/">Quay lại</a>
									</div>
								</div>
							</div>
							</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer Area End Here -->
	</div>
</body>

<!-- login-register31:27-->
</html>
