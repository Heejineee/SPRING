<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원정보</h1>
	<form method="post" action="../main/emp_ok.do">	<!-- .do 주면 MainController로 넘어감 / .jsp 주면 .jsp로 넘어감 -->
		<input type=text name=empno size=15><br>
		<input type=text name=ename size=15><br>
		<input type=text name=job size=15><br>
		<input type=text name=dept size=15><br>
		<input type=text name=loc size=15><br>
		<button>전송</button>
	</form>
</body>
</html>