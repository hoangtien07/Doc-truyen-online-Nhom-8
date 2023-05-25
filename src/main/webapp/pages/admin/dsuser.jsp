<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Dashboard - SB Admin</title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/styles.css'/>">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<%@ include file="../../common/menuadmin.jsp"%>
	<div id="layoutSidenav_content">
		<main>
		<div class="container-fluid px-4">

			<h3 class="mt-4">Danh sách User</h3>

			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Danh sách user
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>id</th>
								<th>họ tên</th>
								<th>số điện thoại</th>
								<th>username</th>
								<th>email</th>
								<th>actived</th>
								<th>khóa</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>id</th>
								<th>họ tên</th>
								<th>số điện thoại</th>
								<th>username</th>
								<th>email</th>
								<th>actived</th>
								<th>khóa</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${dsUser}" var="list">
								<tr>
									<td>${list.id}</td>
									<td>${list.fullname}</td>
									<td>${list.phone}</td>
									<td>${list.username}</td>
									<td>${list.email}</td>
									<td>${list.actived}</td>
									<c:choose>
								    <c:when test="${list.actived == '1'}">
								       <td><button class="btn-success"><a href="active?id=${list.id}" style="color:#fff">Khóa</a></button></td>
								    </c:when>    
								    <c:otherwise>
								        <td><button class="btn-warning"><a href="active?id=${list.id}" style="color:#fff">Mở Khóa</a></button></td>
								    </c:otherwise>
								</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</main>

	</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value='/template/admin/js/datatables-simple-demo.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/demo/chart-area-demo.js'/>"></script>
	<script src="<c:url value='/template/admin/js/scripts.js'/>"></script>
</body>
</html>
