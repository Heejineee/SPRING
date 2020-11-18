<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <style type="text/css">
 	.row{
 		margin:0px auto;
 		width:360px;
 	}
 </style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center">&lt;${vo.ename}&gt;사원 정보</h1>
			<table class="table">
				<tr>
					<td width=26% class="text-right info">사번</td>
					<td>${vo.empno }</td>
				</tr>
				<tr>
					<td width=26% class="text-right info">이름</td>
					<td>${vo.ename }</td>
				</tr>
				<tr>
					<td width=26% class="text-right info">직위</td>
					<td>${vo.job }</td>
				</tr>
				<tr>
					<td width=26% class="text-right info">입사일</td>
					<td>
						<fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td width=26% class="text-right info">급여</td>
					<td>${vo.sal }</td>
				</tr>
				<tr>
					<td width=26% class="text-right info">부서명</td>
					<td>${vo.dname }</td>
				</tr>
				<tr>
					<td width=26% class="text-right info">근무지</td>
					<td>${vo.loc }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>