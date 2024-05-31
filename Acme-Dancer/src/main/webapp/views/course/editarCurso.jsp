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
	<form:form method="POST" action="course/guardarCurso.do" modelAttribute="curso">
		<form:hidden path="id" />
		<form:hidden path="version" />
		<div>
			<label for="titulo"><spring:message code="curso.edit.title" /></label>
			<input type="text" id="titulo" name="titulo" value="${curso.titulo}" required />
		</div>
		
		<div>			
			<label for="nivel"><spring:message code="curso.edit.nivel" /></label>
			<select id="nivel" name="nivel">
				<option value="PRINCIPIANTE" ${curso.nivel == 'PRINCIPIANTE' ? 'selected' : ''}>PRINCIPIANTE</option>
				<option value="INTERMEDIO" ${curso.nivel == 'INTERMEDIO' ? 'selected' : ''}>INTERMEDIO</option>
				<option value="AVANZADO" ${curso.nivel == 'AVANZADO' ? 'selected' : ''}>AVANZADO</option>
				<option value="PROFESIONAL" ${curso.nivel == 'PROFESIONAL' ? 'selected' : ''}>PROFESIONAL</option>
			</select>
		</div>

		<div>
			<label for="fechaInicio" ><spring:message code="curso.edit.fechini" /></label>
			<input type="date" id="fechaInicio" name="fechaInicio" 
			value='<fmt:formatDate value="${curso.fechaInicio}" pattern="yyyy-MM-dd"/>' required />
		</div>
		
		<div>
			<label for="fechaFin"><spring:message code="curso.edit.fechaFin" /></label>
			<input type="date" id="fechaFin" name="fechaFin" 
			value='<fmt:formatDate value="${curso.fechaFin}" pattern="yyyy-MM-dd"/>' required />
		</div>
		
		<div>
			<label for="hora"><spring:message code="curso.edit.hora" /></label>
			<input type="text" id="hora" name="hora" value="${curso.hora}" required />
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

