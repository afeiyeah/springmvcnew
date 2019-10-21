<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.action" method="post" enctype="multipart/form-data">
	<div>
		用户ID： <input type="text" value="${editUser.uid}" name="uid"/>
		用户名：<input type="text" value="${editUser.uname}" name="uname"/>
		生日：<input type="text" value="${editUser.birthday}" name="birthday"/>
		城市：<select name="city.cityid">
				<option value="-1">请选择</option>
				<option value="0">沈阳市</option>
				<option value="1">大连市</option>
			</select>
	
	</div>
	<div>
		头像：<input type="file" name="photo"/>
	</div>
	<div>
		
		<button type="submit">提交</button>
		
		
	</div>
	</form>

</body>
</html>