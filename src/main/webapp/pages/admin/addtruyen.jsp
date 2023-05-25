<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
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
<script
	src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js"
	referrerpolicy="origin"></script>
<script>
	tinymce.init({
		selector : 'textarea#editor',
	});
</script>
</head>
<body class="sb-nav-fixed">
	<%@ include file="../../common/menuadmin.jsp"%>
	<div id="layoutSidenav_content">
		<form:form action="posttruyen" method="post" modelAttribute="truyen"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-5" style="margin-top: 100px; margin-left: 30px">
					<h5>Thêm/ sửa truyện</h5>

					<form:input type="hidden" path="id" />
					<label>tên truyện</label>
					<form:input type="text" class="form-control" path="ten" />
					<label>tập</label>
					<form:input type="number" class="form-control" path="tap" />
					<label>Tên tập</label>
					<form:input type="text" class="form-control" path="tenTap" />

					<label>ảnh nền phim</label> <input type="file" class="form-control"
						name="file"> <label for="editor">Loại truyện</label> <br>
					<select name="loaitruyen" class="form-control">
						<c:forEach items="${listLoaiTruyen}" var="list">
							<c:choose>
								<c:when test="${list.id == truyen.loaiTruyen.id}">
									<option selected="selected" value="${list.id}">${list.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${list.id}">${list.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <br>
					<button class="form-control btn-success" style="margin-top: 30px">Thêm/
						sửa</button>

				</div>
				<div class="col-sm-5" style="margin-top: 100px; margin-left: 30px">
					<label>nội dung truyện</label>
					<form:textarea id="editor" name="content" path="noiDung"></form:textarea>
				</div>
			</div>
		</form:form>
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
