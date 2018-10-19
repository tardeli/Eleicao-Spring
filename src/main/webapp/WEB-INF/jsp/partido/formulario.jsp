<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<label for="nome">Nome: </label>
<input type="text" name="nome" id="nome" value="${partido.nome}" size="36" required>
<form:errors path="partido.nome" />
<br/>
<label for="sigla">Sigla: </label>
<input type="text" name="sigla" id="sigla" value="${partido.sigla}">
<form:errors path="partido.sigla" />
<br/>
