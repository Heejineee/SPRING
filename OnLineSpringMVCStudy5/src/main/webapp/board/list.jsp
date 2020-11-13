<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		width:900px;
	}
	h1{
		text-align:center;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>스프링 게시판(MyBatis : Annotation)</h1>
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-primary">새글</a>
					</td>
				</tr>
			</table>
			<table class="table table-striped">
				<tr class="info">
					<th class="text-center" width=10%>번호</th>
					<th class="text-center">제목</th>
					<th class="text-center" width=15%>이름</th>
					<th class="text-center" width=20%>작성일</th>
					<th class="text-center" width=10%>조회수</th>
				</tr>
				<%-- 데이터 출력 위치 --%>
				<c:forEach var="vo" items="${list }">	<%-- for(BoardVO vo:request.getAttribute("list")) 이거랑 같은거임! --%>				
					<tr>
						<td class="text-center" width=10%>${vo.no }</td>
						<td><a href="detail.do?no=${vo.no }">${vo.subject }</a></td>
						<td class="text-center" width=15%>${vo.name }</td>
						<td class="text-center" width=20%>
							<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
						</td>
						<td class="text-center" width=10%>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<table class="table">
				<tr>
					<td class="text-center">
						<a href="#" class="btn btn-sm btn-primary">이전</a>
						${curpage } page / ${totalpage } pages
						<a href="#" class="btn btn-sm btn-primary">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>















