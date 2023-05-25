<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<%@ include file="../common/menuuser.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-8 list-truyen">
				<div class="row">
					<div class="col-sm-12 chitiettruyen">
						<p>${truyen.ten}</p>
						<p>Chương ${truyen.tap}: ${truyen.tenTap}</p>
						<p>Người đăng: Admin</p>
						<p>${truyen.createdDate}</p>
					</div>
					<div class="col-sm-12" id="noidungs">
						<div id="nd">
							${truyen.noiDung}
						</div>
					</div>
					
				</div>
			</div>

			<div class="col-sm-3 theloai">
				<div class="row lienquan">
					<div class="col-sm-12">
						<h4>Chuyện liên quan</h4>
						<hr>
					</div>
					<c:forEach items="${listTruyen}" var="list">
					<div class="col-sm-6 single-story">
						<a href="chitiet?id=${list.id}"><img class="img-single" src="${list.anh}"></a>
						<a href="chitiet?id=${list.id}">${list.ten}</a>
						<p>Tập: ${list.tap}</p>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- partial -->
</body>
<script type="text/javascript">

</script>
</html>