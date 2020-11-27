<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="latest-products">
  	<div style="height:130px;"></div>
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <h2>총 <span style="color:red;">${count }</span>개의 맛있는 레시피가 있습니다.</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="../recipe/detail.do?no=${vo.no }"><img src="${vo.poster }" alt=""></a>
	              <div class="down-content">
	                <a href="../recipe/detail.do?no=${vo.no}"><h4>${vo.title }</h4></a>
	                <p>${vo.chef }</p>
	                <span>${vo.hit }</span>
	              </div>
	            </div>
	          </div>
	         </c:forEach>
        </div>
        <div class="row">
        	<div style="margin:0px auto;">
        		<a href="../recipe/list.do?page=${curpage>1?curpage-1:curpage }" class="bnt btn-sm btn-danger">이전</a>
        			${curpage} page / ${totalpage }  pages
        		<a href="../recipe/list.do?page=${curpage<totalpage?curpage+1:totalpage}" class="bnt btn-sm btn-danger">다음</a>
        	</div>
        </div>
      </div>
    </div>
</body>
</html>