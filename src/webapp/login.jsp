<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style> 
body {background: linear-gradient(to right, #A9D0F5, #0B3861);}
</style>

<style type="text/css">
h1,h2 {
	color: white;
	font-size: 30px;
	font-family: 'Arial';
}
</style>

<style type="text/css">
a:link,a:visited {
	text-decoration: none;
	color: #FFF
}

a:hover {
	text-decoration: underline;
	color: #000
}
</style>

</head>
<body>

<div align="center"><h3><a href="http://localhost:8080/lojaVirtual/index.jsp">Lobo Marinho</a></h3></div>

	<c:if test="${not empty erro}"> ${erro}<br /></c:if>
	
	<h3>Login:</h3>
	<form action="http://localhost:8080/lojaVirtual/login" method="POST">
		Email:<input type="text" name="email" /> 
		Senha:<input type="password" name="senha" /> 
		<input type="submit" value="efetuar login" />
	</form>
	

<div align="center"><a href="http://localhost:8080/lojaVirtual/cadastro.jsp">Cadastre-se</a></div>
</body>
</html>