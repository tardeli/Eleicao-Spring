<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

  
<label for="eleitor">Eleitor</label>
<select id="eleitor" name="eleitor.numeroTitulo">
	<c:forEach items="${eleitores}" var="eleitor">
		<c:set var="selecionado" value="" />
		<c:if test="${eleitor.numeroTitulo eq voto.eleitor.numeroTitulo}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${eleitor.numeroTitulo}" ${selecionado}>${eleitor.nome}
	</c:forEach>
</select>



<label for="data">Data: </label>
<fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${voto.data}" var="dataFormatada" />
<input type="text" name="data" id="data" value="${dataFormatada}" placeholder="dd/mm/aaaa">

<br/>

<label for="urna">Urna: </label>
<input type="text" name="urna" id="urna" value="${voto.urna}" maxlength="11">
<br/>

<label for="candidato">Candidato</label>
<select id="candidato" name="candidato.codigoRegistro">
	<c:forEach items="${candidatos}" var="candidato">
		<c:set var="selecionado" value="" />
		<c:if test="${candidato.codigoRegistro eq voto.candidato.codigoRegistro}">
			<c:set var="selecionado" value="selected" />
		</c:if>
		<option value="${candidato.codigoRegistro}" ${selecionado}>${candidato.nome}
	</c:forEach>
</select>


