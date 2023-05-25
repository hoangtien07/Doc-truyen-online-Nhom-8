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

			<button>
				<i class="fa fa-plus"></i> <a href="addtruyen">Thêm truyện</a>
			</button>
			<h3 class="mt-4"> Danh sách truyện</h3>

			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Danh sách truyện
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>Ảnh</th>
								<th>Tên truyện</th>
								<th>tập</th>
								<th>Tên tập</th>
								<th>Ngày tạo</th>
								<th>Loại truyện</th>
								<th>sửa</th>
								<th>xóa</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Ảnh</th>
								<th>Tên truyện</th>
								<th>tập</th>
								<th>Tên tập</th>
								<th>Ngày tạo</th>
								<th>Loại truyện</th>
								<th>sửa</th>
								<th>xóa</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${listTruyen}" var="list">
								<tr>
									<td><img style="width: 100px" src="${list.anh}"></td>
									<td>${list.ten}</td>
									<td>${list.tap}</td>
									<td>${list.tenTap}</td>
									<td>${list.createdDate}</td>
									<td>${list.loaiTruyen.name}</td>
									<td><a href="addtruyen?id=${list.id}">sửa</a></td>
                            		<td><a href="deleteTruyen?id=${list.id}">xóa</a></td>
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
