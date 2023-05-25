<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

</head>
<body>
	<%@ include file="../common/menuuser.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-8 list-truyen">
				<div class="row listindex">
				<div class="col-sm-12" style="margin-bottom: 40px">
					<h4>Truyện mới</h4>
					<hr>
				</div>
				<c:forEach items="${listTruyen}" var="list">
					<div class="col-sm-3 single-story">
						<a href="chitiet?id=${list.id}"><img class="img-single" src="${list.anh}"></a>
						<a href="chitiet?id=${list.id}">${list.ten}</a>
						<p>Tập: ${list.tap}</p>
						<c:choose>
							<c:when test="${pageContext.request.userPrincipal.name == null}">
							</c:when>
							<c:otherwise>
								<button class="btn-success"><a style="color: #fff" href="luuTruyen?id=${list.id}">Lưu truyện</a></button>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
				</div>
			</div>

			<div class="col-sm-3 theloai">
				<div class="row">
					<div class="col-sm-12">
						<h4>Thể loại chuyện</h4>
						<hr>
					</div>
					<c:forEach items="${listLoaiTruyen}" var="list">
					<div class="col-sm-6">
						<a href="trang-chu?id=${list.id}">${list.name}</a>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- partial -->
</body>
</html>