<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello form.jsp
<br />

<form action="form_ok.do" method="get" >
데이터 <input type="text" value="data" />
<input type="submit" value="전송" />
</form>

<form action="form_ok.do" method="post" >
데이터 <input type="text" value="data" />
<input type="submit" value="전송" />
</form>

</body>
</html>