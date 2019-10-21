<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#exportUser").click(function(){
			
			window.location.href="exportUser.action";
		})
		$("#deleteUser").click(function(){
			document.forms[0].action="deleteUser.action";
			document.forms[0].submit();
		})
	})

</script>
</head>
<body>
	<!-- 建议一个实体对应一个controller -->
	<form action="selectUser.action" method="post">
		<button type="submit">查询用户信息</button>
		<table>
			<tr>
				<th></th>
				<th>用户id</th>
				<th>用户名</th>
				<th>生日</th>
			</tr>
			<c:forEach items="${ulist}" var="user">
				<tr>
					<td><input type="checkbox" name="chk" value="${user.uid}"></td>
					<td>${user.uid }</td>
					<td>${user.uname }</td>
					<td>${user.birthday}</td>
					<td><a href="edit.action?userid=${user.uid} ">编辑</a></td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" id="exportUser">导出</button>
		<button type="button" id="deleteUser">删除</button>
	</form>
</body>
</html>