<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container">
     <div class="row">
      <h1>내용보기</h1>
      <table class="table table-striped">
        <tr>
          <th width=20% class="text-center danger">번호</th>
          <td width=30% class="text-center">${vo.board_no }</td>
          <th width=20% class="text-center danger">작성일</th>
          <td width=30% class="text-center"> 
            <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-center danger">이름</th>
          <td width=30% class="text-center">${vo.id }</td>
          <th width=20% class="text-center danger">조회수</th>
          <td width=30% class="text-center">${vo.hit }</td>
        </tr>
        <tr>
          <th width=20% class="text-center danger">제목</th>
          <td colspan="3" class="text-left">${vo.title }</td>
        </tr>
        <tr>
          <td colspan="4" class="text-left" valign="top" height=200>
            ${vo.content }
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <a href="update.do?no=${vo.no }" class="btn btn-sm btn-success">수정</a>
            <a href="delete.do?no=${vo.no }" class="btn btn-sm btn-info">삭제</a>
            <a href="list.do" class="btn btn-sm btn-warning">목록</a>
          </td>
        </tr>
      </table>
     </div>
   </div>
</body>
</html>