<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de alteração de usuário</title>
</head>
<body>
	<form action="alterarUsuario" method="post">
	<br>Página para a alteração das motos cadastradas:<br><br>
		Marca: <input type="text" name="marca" id="marca" value=${usuario.marca}><br><br>
		Modelo: <input type="text" name="modelo" id="modelo" value=${usuario.modelo}><br><br>
		Ano: <input type="number" name="ano" id="ano" value=${usuario.ano}><br><br>
		<input type="hidden" name="id" id="id" value=${usuario.id}>
  		<input type="submit" value="Alterar">
	</form>
</body>
</html>