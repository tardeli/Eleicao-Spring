<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Lista de Candidatos</title>
</head>
<body>

<c:import url="../header.jsp"></c:import>

<div class="container">
	<div class="container" style="text-align:center; margin: 8px 0 8px 0">
    <a href="/candidato/novo" class="btn btn-success">Novo</a>
    </div>
    <h4>Lista de Candidato</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Cód. Registro</th>
				<th>Nome</th>
				<th>Cpf</th>
				<th>Partido</th>
				<th>Cargo</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="candidato" items="${candidatos}"> 
			<tr>
				<td>${candidato.codigoRegistro}</td>
				<td>${candidato.nome}</td>
				<td>${candidato.cpf}</td>
				<td>${candidato.partido.nome}</td>
				<td>${candidato.cargo}</td>
				
				<td><a href="/candidato/visualizar/${candidato.codigoRegistro}" class="btn btn-info">Editar</a></td>
				<td><a href="/candidato/deletar/${candidato.codigoRegistro}" class="btn btn-danger">Excluir</a></td>
			</tr>
		</c:forEach>  
		</tbody>
	</table>
</div>	
</body>
</html>