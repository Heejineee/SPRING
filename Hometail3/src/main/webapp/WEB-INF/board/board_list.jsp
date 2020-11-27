<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- SimpleDateFormat --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${no==1 }">
	       <table class="table">
	         <tr>
	           <td>
	             <a href="insert.do" class="btn btn-sm btn-primary">새글</a>
	           </td>
	         </tr>
	       </table>
       <table class="table table-striped">
         <tr class="danger">
           <th class="text-center" width=10%>번호</th>
           <th class="text-center" width=45%>제목</th>
           <th class="text-center" width=15%>이름</th>
           <th class="text-center" width=20%>작성일</th>
           <th class="text-center" width=10%>조회수</th>
         </tr>
         <c:forEach var="fvo" items="${fList }">
           <tr>
               <td class="text-center" width=10%>${fvo.board_no }</td>
	           <td class="text-left" width=45%>
	             <a href="detail.do?board_no=${fvo.board_no }">${fvo.title }</a>
	           </td>
	           <td class="text-center" width=15%>${fvo.id }</td>
	           <td class="text-center" width=20%>
	             <fmt:formatDate value="${fvo.regdate }" pattern="yyyy-MM-dd"/>
	           </td>
	           <td class="text-center" width=10%>${fvo.hit }</td>
           </tr>
         </c:forEach>
       </table>
       <table class="table">
         <td class="text-center">
          <a href="#" class="btn btn-sm btn-primary">이전</a>
          ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-sm btn-primary">다음</a>
         </td>
       </table>
        </c:if>
        <c:if test="${no==2 }">
	        <c:forEach var="vo" items="${list }">
	          		<div class="col-md-4 ftco-animated">
			            <div class="blog-entry">
			              <a href="blog-single.html" class="block-20" style="background-image: url('${vo.poster}');">
			              </a>
			              <div class="text d-flex py-4">
			                <div class="meta mb-3">
			                  <div>${vo.regdate }</div>
			                  <div>${vo.id }</div>
			                </div>
			                <div class="desc pl-3">
				                <h3 class="heading">${vo.title }</h3>
				              </div>
			              </div>
			            </div>
			          </div>
			         </c:forEach>
		</c:if>
</body>
</html>