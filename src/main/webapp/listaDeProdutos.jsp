<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Produtos</title>

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
a:link, a:visited {
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
	<div align="center">
		<h2>
			<a href="http://localhost:8080/lojaVirtual/index.jsp">Lobo Marinho</a>
		</h2>
		
	</div>

	<c:if test="${not empty produtos}">


			<table border=1 cellspacing=0 cellpadding=2 bordercolor="000"  style="background-color:white;">
				
			<c:forEach var="produto" items="${produtos}">
				<tr>
					<td>
						<h3>${produto.nome} - R$ ${produto.valor}</h3>
						${produto.descricao}, - ${produto.marca}
						<br /> Setor ${produto.categoria } <br /> 
						<input type="submit" value="Adicionar no Carrinho de Compras"
						onclick="location. href= 'http://localhost:8080/lojaVirtual/addProdutoNoCarrinhoDeCompra?idDoproduto=${produto.id}' ">
						<br />
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<div align="right">
		<h4><a href="http://localhost:8080/lojaVirtual/carrinhoDeCompras">Carrinho de Compras</a></h4>
	</div>
	<div align="center">
		<a href="http://localhost:8080/lojaVirtual/index.jsp">Inicio</a>
	</div>
</body>
</html>