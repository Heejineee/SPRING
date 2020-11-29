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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('#new').hover(function(){
			$(this).css("cursor", "pointer")
		}, function(){
			$(this).css("cursor", "")
		});
		
		$('#new').click(function(){
			$.ajax({
				type:'POST',
				url:'../board/board_insert.do',
				success:function(res)
				{
					$('#print').html(res);
				}
			});
		});
	

		//페이지 넘기는 용도
		$('li').click(function(){
			let page=$(this).attr("page");
			console.log(page);
			$.ajax({
					type:'post',
					url:'../board/board_list.do',
					data: {page:page,no:no},
					success:function(result)
					{
						$('#print').html(result);
					}
				})
		});
		
	});
</script> 
</head>
<body>
	<c:if test="${no==1 }">
	       <table class="table">
	         <tr>
	           <td>
	             <span class="btn btn-sm btn-primary" id="new">새글</span>
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
			   <div class="col text-center">
             <div class="block-27">
               <ul>
                  <c:if test="${curpage>BLOCK }">
                    <li page="${startPage-1 }"><a style="cursor: pointer;">&lt;</a></li>
                 </c:if>
                 
                 <c:forEach var="i" begin="${startPage }" end="${endPage }">
                     <c:if test="${i==curpage }">
                           <li class="active" page="${i }">
                               <a style="cursor: pointer;">${i }</a>
                           </li> 
                     </c:if>
                     <c:if test="${i!=curpage }">
                           <li page="${i }">
                               <a style="cursor: pointer;">${i }</a>
                           </li>
                    </c:if>
                  </c:forEach>
                 
                 <c:if test="${endPage<totalpage }">
                    <li page="${endPage+1 }"><a style="cursor: pointer;">&gt;</a></li>
                 </c:if>
                 
               </ul>
             </div>
           </div>
        </c:if>
        <c:if test="${no==2 }">
	        <c:forEach var="rvo" items="${rList }">
	          		<div class="col-md-4 ftco-animated">
			            <div class="blog-entry">
			              <a href="detail.do?board_no=${rvo.board_no }" class="block-20" style="background-image: url('${rvo.poster}');">
			              </a>
			              <div class="text d-flex py-4">
			                <div class="meta mb-3">
			                  <div>${rvo.regdate }</div>
			                  <div>${rvo.id }</div>
			                </div>
			                <div class="desc pl-3">
				                <h3 class="heading">${rvo.title }</h3>
				              </div>
			              </div>
			            </div>
			          </div>
			         </c:forEach>
      <div class="col text-center">
             <div class="block-27">
               <ul>
                  <c:if test="${acurpage>BLOCK }">
                    <li page="${astartPage-1 }"><a style="cursor: pointer;">&lt;</a></li>
                 </c:if>
                 
                 <c:forEach var="i" begin="${astartPage }" end="${aendPage }">
                     <c:if test="${i==acurpage }">
                           <li class="active" page="${i }">
                               <a style="cursor: pointer;">${i }</a>
                           </li> 
                     </c:if>
                     <c:if test="${i!=acurpage }">
                           <li page="${i }">
                               <a style="cursor: pointer;">${i }</a>
                           </li>
                    </c:if>
                  </c:forEach>
                 
                 <c:if test="${aendPage<atotalpage }">
                    <li page="${aendPage+1 }"><a style="cursor: pointer;">&gt;</a></li>
                 </c:if>
                 
               </ul>
             </div>
           </div>
		</c:if>
		<c:if test="${no==4 }">
	       <table class="table">
	         <tr>
	           <td>
	             <span class="btn btn-sm btn-primary" id="new">새글</span>
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
         <c:forEach var="qvo" items="${qList }">
           <tr>
               <td class="text-center" width=10%>${qvo.board_no }</td>
	           <td class="text-left" width=45%>
	             <a href="detail.do?board_no=${qvo.board_no }">${qvo.title }</a>
	           </td>
	           <td class="text-center" width=15%>${qvo.id }</td>
	           <td class="text-center" width=20%>
	             <fmt:formatDate value="${qvo.regdate }" pattern="yyyy-MM-dd"/>
	           </td>
	           <td class="text-center" width=10%>${qvo.hit }</td>
           </tr>
         </c:forEach>
       </table>
       <div class="col text-center">
             <div class="block-27">
               <ul>
                  <c:if test="${qcurpage>BLOCK }">
                    <li page="${qstartPage-1 }"><a style="cursor: pointer;">&lt;</a></li>
                 </c:if>
                 
                 <c:forEach var="i" begin="${qstartPage }" end="${qendPage }">
                     <c:if test="${i==qcurpage }">
                           <li class="active" page="${i }">
                               <a style="cursor: pointer;">${i }</a>
                           </li> 
                     </c:if>
                     <c:if test="${i!=qcurpage }">
                           <li page="${i }">
                               <a style="cursor: pointer;">${i }</a>
                           </li>
                    </c:if>
                  </c:forEach>
                 
                 <c:if test="${qendPage<qtotalpage }">
                    <li page="${qendPage+1 }"><a style="cursor: pointer;">&gt;</a></li>
                 </c:if>
                 
               </ul>
             </div>
           </div>
        </c:if>
</body>
</html>