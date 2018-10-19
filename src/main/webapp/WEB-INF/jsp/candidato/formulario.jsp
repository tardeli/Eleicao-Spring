<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<label for="nome">Nome: </label>
<input type="text" name="nome" id="nome" value="${candidato.nome}" size="36" required>
<form:errors path="partido.nome" />
<br/>
<label for="cpf">Cpf: </label>
<input type="text" name="cpf" id="cpf" value="${candidato.cpf}" maxlength="11">
<form:errors path="partido.cpf" />
<br/>
<label for="partido">Partido</label>
<select id="partido" name="partido.codigo">
	<c:forEach items="${partidos}" var="partido">
		<c:set var="selecionado" value="" />
		<c:if test="${partido.codigo eq candidato.partido.codigo}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${partido.codigo}" ${selecionado}>${partido.nome}
	</c:forEach>
</select>
<br/>
<label for="cargo">Cargo</label>
<select id="cargo" name="cargo">
	<c:forEach items="${cargos}" var="cargo">
		<c:set var="selecionado" value="" />
		<c:if test="${cargo eq candidato.cargo}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${cargo}" ${selecionado}>${cargo}
	</c:forEach>
</select>
<br/>
