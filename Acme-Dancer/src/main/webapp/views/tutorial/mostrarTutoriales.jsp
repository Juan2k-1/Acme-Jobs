<%--
 * action-2.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listado de estilos existentes -->
<table class="styles-table">
	<thead>
		<tr>
			<th><spring:message code="tutorial.name" /></th>
			<th><spring:message code="tutorial.description" /></th>
			<th><spring:message code="tutorial.numReproducciones" /></th>
			<th><spring:message code="tutorial.actions" /></th>
		</tr>
	</thead>
	<tbody>
		<jstl:forEach var="tutoriales" items="${tutoriales}">
			<tr>
				<td><a href="tutorial/verTutorial.do?id=${tutoriales.id}">
						${tutoriales.titulo} </a></td>
				<td><a href="tutorial/verTutorial.do?id=${tutoriales.id}">
						${tutoriales.descripcion} </a></td>
				<td>${tutoriales.numReproducciones} </td>
				<security:authorize access="hasRole('ACADEMIA')">
					<td><a href="tutorial/editarTutorial.do?id=${tutoriales.id}">
							<spring:message code="administrator.edit" />
					</a> | <a href="tutorial/eliminarTutorial.do?id=${tutoriales.id}"
						onclick="return confirm('<spring:message code="tutorial.confirm.delete"/>');">
							<spring:message code="tutorial.delete" />
					</a></td>
				</security:authorize>
			</tr>
		</jstl:forEach>
	</tbody>
</table>
<!-- Formulario para crear un nuevo estilo -->
<h2>
	<spring:message code="tutorial.create.new.tutorial" />
</h2>
<form:form method="POST" action="tutorial/crearTutorial.do"
	modelAttribute="nuevoTutorial">
	<div>
		<label for="titulo"><spring:message code="tutorial.name" /></label>
		<form:input path="titulo" id="titulo" />
		<form:errors path="titulo" cssClass="error" />
	</div>
	<div>
		<label for="descripcion"><spring:message
				code="tutorial.description" /></label>
		<form:input path="descripcion" id="descripcion" />
		<form:errors path="descripcion" cssClass="error" />
	</div>
	<div>
		<label for="video">URL</label>
		<form:input path="video" id="descripcion" />
		<form:errors path="video" cssClass="error" />
	</div>
	<div>
		<input type="submit"
			value="<spring:message code="tutorial.create"/>" />
	</div>
</form:form>
