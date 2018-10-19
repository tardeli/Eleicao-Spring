<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<label for="numeroTitulo">Número Título: </label>
<input type="text" name="numeroTitulo" id="numeroTitulo" value="${eleitor.numeroTitulo}" size="36" required>
<br/>
<label for="nome">Nome: </label>
<input type="text" name="nome" id="nome" value="${eleitor.nome}" size="36" required>
<form:errors path="eleitor.nome" />
<br/>
<label for="nomeMae">Mãe: </label>
<input type="text" name="nomeMae" id="nomeMae" value="${eleitor.nomeMae}">
<form:errors path="eleitor.nomeMae" />
<br/>
<label for="zonaEleitoral">Zonal Eleitoral: </label>
<input type="text" name="zonaEleitoral" id="zonaEleitoral" value="${eleitor.zonaEleitoral}">
<form:errors path="eleitor.zonaEleitoral" />
<br/>
<label for="secao">Seção: </label>
<input type="text" name="secao" id="secao" value="${eleitor.secao}">
<form:errors path="eleitor.secao" />
<br/>
