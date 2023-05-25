<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<c:url value='/template/assets/css/style.css'/>">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="trang-chu">Web đọc truyện</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="trang-chu">Trang chủ</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Thể loại <span class="caret"></span></a>
					<ul class="dropdown-menu">
					<c:forEach items="${listLoaiTruyen}" var="list">
						<li><a href="trang-chu?id=${list.id}">${list.name}</a></li>
					</c:forEach>
					</ul></li>
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name == null}">
						<li><a href="login">Đăng nhập</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="logout">Đăng xuất</a></li>
						<li><a href="truyendaluu">truyện đã lưu</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<form class="navbar-form navbar-left" action="trang-chu" method="get">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search" name="q">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</nav>
</body>

</html>