<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.row{
		margin:0px auto;
		width:350px;
	}
	h1{
		text-align:center;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>로그인</h1>
			<form action="login_ok.do" method="post">
				<table class="table">
					<tr>
						<td width=25% class="text-right">ID</td>
						<td>
							<input type=text size=15 name=id>
						</td>
					</tr>
					<tr>
						<td width=25% class="text-right">Password</td>
						<td>
							<input type=password size=15 name=pwd>
						</td>
					</tr>
					<tr>
						<td class="text-center" colspan=2>
							<input type=submit value="로그인" class="btn btn-sm btn-danger">
							<input type=button value="취소" onclick="javascript:history.back()" class="btn btn-sm btn-warning">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>