<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Voto</title>
</head>
<body>
	<c:import url="../header.jsp"></c:import>
	<div class="formulario">
		<h4>Alterar Voto</h4>
		<form action="/voto/alterar" method="post">
			<input type="hidden" name="codigo" value="${voto.codigo}">
			<c:import url="formulario.jsp"></c:import>
			<br/>
			<button class="btn btn-success" type="submit">Salvar</button>
	
			<a class="btn btn-danger" href="/voto/listar">Cancelar</a> 
		</form>
	</div>
</body>
</html>
