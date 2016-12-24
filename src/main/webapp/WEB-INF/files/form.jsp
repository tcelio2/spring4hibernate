<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:hasBindErrors name="aluno">
	<c:forEach var="error" items="${errors.allErrors}" >
		<li><spring:message code="${error.code}" text="${error.defaultMessage}" /></li>
	</c:forEach>
</spring:hasBindErrors>

<form:form action="salvarAluno" method="post" modelAttribute="aluno">
	<div>
		<label for="title">Nome</label>
		<form:input path="nome" />
		<form:errors path="telefone" cssClass="error" />
	</div>
	<div>
		<label for="title">Telefone</label>
		<form:input path="telefone" />
		<form:errors path="telefone" cssClass="error" />
	</div>
	<div>
		<input type="submit" value="enviar"/>
	
	</div>
</form:form>

</body>
</html>