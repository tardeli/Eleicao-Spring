<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Lista de Partidos</title>
</head>
<body>

<c:import url="../header.jsp"></c:import>

<div class="container">
	<div class="container" style="text-align:center; margin: 8px 0 8px 0">
    <a href="/partido/novo" class="btn btn-success">Novo</a>
    </div>
    <h4>Lista de Partidos</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Sigla</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="partido" items="${partidos}"> 
			<tr>
				<td>${partido.codigo}</td>
				<td>${partido.nome}</td>
				<td>${partido.sigla}</td>
				<td><a href="/partido/visualizar/${partido.codigo}" class="btn btn-info">Editar</a></td>
				<td><a href="/partido/deletar/${partido.codigo}" class="btn btn-danger">Excluir</a></td>
			</tr>
		</c:forEach>  
		</tbody>
	</table>
</div>	
</body>
</html>