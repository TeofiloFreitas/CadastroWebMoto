<%@page import="br.santalucia.beans.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Motos Cadastradas</title>
</head>
<body>
	
	<c:forEach var="u" items="${usuarios}">
		Nome: ${u.nome}   
		<a href="excluirUsuario?id=${u.id}">Excluir</a>
		<a href="mostrarUsuario?id=${u.id}">Alterar</a>
		 <br>
	</c:forEach>
	
</body>
</html>