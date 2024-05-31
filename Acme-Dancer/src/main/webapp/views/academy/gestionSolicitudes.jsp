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
		<spring:message code="solicitud.gestion" />
	</h2>
	<table>
		<tr>
			<th><spring:message code="solicitud.alumno" /></th>
			<th><spring:message code="solicitud.curso" /></th>
			<th><spring:message code="solicitud.estado" /></th>
			<th><spring:message code="solicitud.acciones" /></th>
		</tr>
		<jstl:forEach var="solicitud" items="${solicitudes}">
			<tr>
				<td>${solicitud.alumno.nombre}</td>
				<td>${solicitud.curso.titulo}</td>
				<td>${solicitud.estado}</td>
				<td>
					<form action="academy/aceptarSolicitud.do" method="post">
						<input type="hidden" name="id" value="${solicitud.id}" />
						<input type="submit" value="<spring:message code='solicitud.aceptar' />" />
					</form>
					<form action="academy/rechazarSolicitud.do" method="post">
						<input type="hidden" name="id" value="${solicitud.id}" />
						<input type="submit" value="<spring:message code='solicitud.rechazar' />" />
					</form>
				</td>
			</tr>
		</jstl:forEach>
	</table>
</div>