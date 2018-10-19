<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Lista de Votos</title>

</head>
<body>

<c:import url="../header.jsp"></c:import>

<div class="container">
	<div class="row">
		<div class="col-sm-6" style="text-align:right;padding:8px;">
	    	<a href="/voto/novo" class="btn btn-success">Novo</a>
	    </div>
	    <div class="col-sm-6" style="text-align:right;padding:8px;">
		    <label for="candidato">Filtrar por Candidato: </label>
			<select id="candidato" name="candidato.codigoRegistro">
				<option value="">Selecione</option>
				<c:forEach items="${candidatos}" var="candidato">
					
					<c:if test="${candidato.codigoRegistro eq voto.candidato.codigoRegistro}">
						<c:set var="selecionado" value="selected" />
					</c:if>
					<option value="${candidato.codigoRegistro}" ${selecionado}>${candidato.nome}
				</c:forEach>
			</select>
			<a id="pesquisar" href="#" class="btn btn-success">Enter</a>
		</div>
	</div>
    
    
    <h4>Lista de Voto</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Código</th>
				<th>Eleitor</th>
				<th>Data</th>
				<th>Urna</th>
				<th>Candidato</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="voto" items="${votos}"> 
			<tr>
				<td>${voto.codigo}</td>
				<td>${voto.eleitor.nome}</td>
				<fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${voto.data}" var="dataFormatada" />
				<td>${dataFormatada}</td>
				<td>${voto.urna}</td>
				<td>${voto.candidato.nome}</td>
				
				<td><a href="/voto/visualizar/${voto.codigo}" class="btn btn-info">Editar</a></td>
				<td><a href="/voto/deletar/${voto.codigo}" class="btn btn-danger">Excluir</a></td>
			</tr>
		</c:forEach>  
		</tbody>
	</table>
	
	<h6 style="text-align: center">Localizado ${fn:length(votos)} Voto(s).</h6>
</div>	

<script>
$(document).ready(function () {
    var estado = $('#candidato');
    estado.change(function () {
    	var link ="/voto/listarporcandidato/"+estado.val();
        document.getElementById('pesquisar').setAttribute("href", link );
    });
});

</script>
</body>
</html>