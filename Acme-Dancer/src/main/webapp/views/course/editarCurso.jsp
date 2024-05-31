<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
	<h2>
		<spring:message code="curso.edit" />
	</h2>
	<form:form method="POST" action="course/guardarCurso.do"
		modelAttribute="curso">
		<form:hidden path="id" />
		<form:hidden path="version" />
		<div>
			<label for="titulo"><spring:message code="curso.edit.title" /></label>
			<form:input path="titulo" id="nombre" />
		</div>
		<div>
			<label for="nivel"><spring:message code="curso.edit.nivel" /></label>
			<input type="text" id="nivel" name="nivel" required />
		</div>

		<div>
			<label for="fechaInicio" ><spring:message
					code="curso.edit.fechini" /></label>
			<input type="text" id="fechaInicio" name="fechaInicio" required />
		</div>
		<div>
			<label for="fechaFin"><spring:message
					code="curso.edit.fechaFin" /></label>
			<input type="text" id="fechaFin" name="fechaFin" required />
		</div>
		<div>
			<label for="hora"><spring:message code="curso.edit.hora" /></label>
			<form:input path="hora" id="hora" />
		</div>
		<div>
			<label for="estilo"><spring:message code="curso.edit.estilo" />:</label>
			<select id="estilo" name="estilo">
				<jstl:forEach var="estilo" items="${estilos}">
						<option value="${estilo.nombre}">${estilo.nombre}</option>
				</jstl:forEach>
			</select>
		</div>

		<div>
			<input type="submit" value="<spring:message code="curso.edit.save"/>" />
		</div>
	</form:form>
</div>

