<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addbtn() {
		var content = document.getElementById("content");
		content.innerHTML += "<div> <input type='file' name='fname' > " + 
			"<input type='button' value='remove' onclick='this.parentNode.parentNode.removeChild(this.parentNode);' ><br></div>"
			// "<input type='button' value='remove' onclick='removebtn(this)' ><br></div>"
	}
	
	function removebtn(btn) {
		var content = document.getElementById("content");
		content.removeChild(btn.parentNode);
	}
</script>
</head>
<body>
<!-- enctype: 包装类型, urlencoding,  多 部分 -->
<form action="${pageContext.request.contextPath }/helloupload2" 
	method="post" enctype="multipart/form-data">
	
	<input type="button" value="添加上传文件" onclick="addbtn()">
<hr>
	<input type="file" name="fname" > <br>
	<div id="content"></div>
	<input type="submit" value="文件上传">
</form>

</body>
</html>