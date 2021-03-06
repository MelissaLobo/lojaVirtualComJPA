<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lobo Marinho</title>
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
	Logado como: ${usuarioLogado.email}<br />
	</c:if>

	<div align="right">
		<h4><a href="http://localhost:8080/formularioCadastrarProduto">Quero Vender</a></h4>
	</div><div align="center"><h2><a href="http://localhost:8080/home">Lobo Marinho</a></h2></div>
	<c:if test="${not empty produtos}">

		<table border=1 cellspacing=0 cellpadding=2 bordercolor="000"  style="background-color:white;">
			
			<c:forEach var="produto" items="${produtos}">
				<tr>
					<td>
						<h3>${produto.nome} - R$ ${produto.valor} </h3> ${produto.descricao},
						- ${produto.marca} <br /> Setor ${produto.categoria } <br /> 
						<input type="submit" value="Adicionar no Carrinho de Compras" onclick="location. href= 'http://localhost:8080/addProdutoNoCarrinhoDeCompra?idDoproduto=${produto.id}' ">
						<input type="submit" value="Comentarios" onclick="location. href= 'http://localhost:8080/mostraProduto?idDoProduto=${produto.id}' ">
						<br />
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	
	<div align="right"><a href="http://localhost:8080/carrinhoDeCompras">Carrinho de Compras</a></div>
	<div align="center"><a href="http://localhost:8080/home">Inicio</a></div>

	<div align="right">
		<form action="http://localhost:8080/deslogar" method="POST">
			<input type="hidden" name="logout" value="Logout" /> <input
				type="submit" value="Deslogar" />
		</form>
	</div>
	
</body>
</html>