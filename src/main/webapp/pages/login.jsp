<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/template/login/css/sign-in.css'/>">
<link rel="stylesheet" href="<c:url value='/template/login/css/as-alert-message.min.css'/>">
</head>
<body>
<header id="site-header" class="w3l-header fixed-top">
		<!--/nav-->
		<nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
			<div class="container">
				
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				</div>
				<div class="Login_SignUp" id="login_s">
					<a class="nav-link" href="sign_in.html"><i class="fa fa-user-circle-o"></i></a>
				</div>
				<!-- toggle switch for light and dark theme -->
				
			</div>
		</nav>
	</header>

	<div class="container_signup_signin" id="container_signup_signin">
		<div class="form-container sign-up-container">
			<form name="sign-up-form" id="regis" action="regis" method="post">
				<h1>Đăng ký</h1>
				<input  type="text" placeholder="họ tên" name="fullname"/>
				<input  type="text" placeholder="username" name="username"/>
				<input  type="email" placeholder="email" name="email"/>
				<input  type="password" placeholder="mật khẩu" name="password"/>
				<button>Đăng ký</button>
			</form>
		</div>
		
		<div class="form-container sign-in-container">
			<form name="sign-in-form" style="color: var(--theme-title);" action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
				<h1>Đăng nhập</h1>
				<div class="social-container">
					<a href="#" class="social" style="color: var(--theme-title);"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social" style="color: var(--theme-title);"><i
							class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social" style="color: var(--theme-title);"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span>
				<input name="username" type="text" placeholder="username" />
				<input name="password" type="password" placeholder="Password" />
				<a data-toggle="modal" data-target=".bd-example-modal-lg">Forgot your password?</a>
				<button>Đăng nhập</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your login details</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Register and book your tickets now!!!</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value='/template/login/assets/js/theme-change.js'/>"></script>
	<script src="<c:url value='/template/login/assets/js/jquery-3.3.1.min.js'/>"></script>
	<script src="<c:url value='/template/login/assets/js/as-alert-message.min.js'/>"></script>
	<script>
		$(function () {
			$('.navbar-toggler').click(function () {
				$('body').toggleClass('noscroll');
			})
		});
	</script>
	<script>
		$(window).on("scroll", function () {
			var scroll = $(window).scrollTop();

			if (scroll >= 80) {
				$("#site-header").addClass("nav-fixed");
			} else {
				$("#site-header").removeClass("nav-fixed");
			}
		});

		//Main navigation Active Class Add Remove
		$(".navbar-toggler").on("click", function () {
			$("header").toggleClass("active");
		});
		$(document).on("ready", function () {
			if ($(window).width() > 991) {
				$("header").removeClass("active");
			}
			$(window).on("resize", function () {
				if ($(window).width() > 991) {
					$("header").removeClass("active");
				}
			});
		});
	</script>

	<script src="<c:url value='/template/login/js/sign-in.js'/>"></script>

</body>

  
</body>
</html>