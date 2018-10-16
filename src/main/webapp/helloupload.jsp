<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- enctype: 包装类型, urlencoding,  多 部分 -->
<form action="${pageContext.request.contextPath }/helloupload2" 
	method="post" enctype="multipart/form-data">
	
  用户名称：	<input type="text" name="username"> <br>

	<input type="file" name="fname" > <br>
	<input type="file" name="fname" > <br>
	<input type="submit" value="文件上传">
</form>

</body>
</html>