<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
</head>
<body>

<div align="center"><h3><a href="http://localhost:8080/index.jsp">Lobo Marinho</a></h3></div>

<h1>Cadastro:</h1>
	<form action="cadastro" method="POST">
		Nome: <input type="text" name="nome"> 
		Email: <input type="text" name="email"> 
		Senha: <input type="text" name="senha"> 
		<input type="submit" value="Salvar">
	</form>

<div align="center"><a href="http://localhost:8080/index.jsp">Inicio</a></div>
</body>
</html>