<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostra Produto</title>

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
			<a href="http://localhost:8080/index.jsp">Lobo Marinho</a>
		</h2>
		
	</div>
<body>
	<table border=1 cellspacing=0 cellpadding=2 bordercolor="000"  style="background-color:white;">
		<tr>
					<td>
	<h3>${produto.nome} - R$ ${produto.valor}</h3>
						${produto.descricao}, - ${produto.marca}
						<br /> Setor ${produto.categoria } <br /> 
		</td>
					</tr>
	</table> <br/> <br/>
	
	<h1>Comentarios: </h1>
	<br />
   
	<c:if test="${not empty comentarios}">
		<a href="http://localhost:8080/listaDeComentarios"></a>
		<ul>
			<c:forEach var="comentario" items="${comentarios}">
				<br />
				<li>${comentario.nome}<br /> ${comentario.texto }
				</li>
			</c:forEach>
		</ul>
	</c:if>
	
	    <h1>Publicar um comentário:</h1>
	<form action="http://localhost:8080/comentar" method="POST">
	    <input type="hidden" name="idDoProduto" value="${produto.id}">
		Nome: <input type="text" name="nome"> <br/>
		<textarea name="texto" rows="5" cols="50" style="background-color: #ffffff"> ESCREVA AQUI O SEU COMENTARIO</textarea><br/>
		<input type="submit" value="Publicar">
	</form>

<div align="center"><a href="http://localhost:8080/home">Inicio</a></div>



</body>
</html>