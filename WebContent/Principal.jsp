<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Miguel web page</title>
</head>
<body>
	<!-- Un JSP es una pagina que sirve para hacer contenido dinamico -->
	
	<h1>Hola, esto es el Principal.jsp</h1>
	
	<a href="index.html">Ir al formulario</a>
	<br/>
	
	<h3 style="color:red"> ${MensajeError} </h3>
	<h3 style="color:blue"> ${Mensaje} </h3>
	<br/>
	
	<h2> Lista de Clientes </h2>
	${listaClientes}
	<table>
	<tr>
		<th>Nombre</th>
		<th>NIF</th>
		<th>Ciudad</th>
		<th>Domicilio</th>
		<th>Telefono</th>
	</tr>
	
	<c:forEach items="${listaClientes}" var="Cliente">
		<tr>
		<td>${Cliente.nombre}</td>
		<td>${Cliente.nif}</td>
		<td>${Cliente.ciudad}</td>
		<td>${Cliente.domicilio}</td>
		<td>${Cliente.tlf}</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>