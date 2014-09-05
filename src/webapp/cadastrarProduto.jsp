<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Produto</title>

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

	<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}<br />
	</c:if>

	<div align="center"><h3><a href="http://localhost:8080/lojaVirtual/home">Lobo Marinho</a></h3></div>

<form action="cadastrarProduto" method="POST">
		<h3>Cadastre o seu produto </h3>
		Nome do Produto: <input type="text" name="nome"> <br />
		Valor: <input type="text" name="valor"><br />
		Descrição:  <input type="text" name="descricao"><br />
		Marca: <input type="text" name="marca"><br /> 
		Categoria: <select name="categoria">
			<c:forEach var="categoria" items="${categorias}">
				<option value="${categoria}">${categoria}</option>
			</c:forEach></select> <br /> 
			<input type="submit" value="Salvar">
	</form>
	
<div align="center"><a href="http://localhost:8080/lojaVirtual/home">Inicio</a></div>


	<div align="right">
		<form action="http://localhost:8080/lojaVirtual/deslogar" method="POST">
			<input type="hidden" name="logout" value="Logout" /> 
			<input type="submit" value="Deslogar" />
		</form>
	</div>

</body>
</html>