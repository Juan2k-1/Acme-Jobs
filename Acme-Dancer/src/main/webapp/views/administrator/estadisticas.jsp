<%--
 * estadisticas.jsp
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

<p>
	<spring:message code="administrator.estadisticas" />
</p>

<jstl:if test="${not empty estadisticas}">
	<ul>
		<li>Media de cursos por academia:
			${estadisticas['mediaCursosPorAcademia']}</li>
		<li>Máximo de cursos por academia:
			${estadisticas['maxCursosPorAcademia']}</li>
		<li>Mínimo de cursos por academia:
			${estadisticas['minCursosPorAcademia']}</li>
		<li>Desviación de cursos por academia:
			${estadisticas['desviacionCursosPorAcademia']}</li>
		<li>Media de solicitudes por curso:
			${estadisticas['mediaSolicitudesPorCurso']}</li>
		<li>Máximo de solicitudes por curso:
			${estadisticas['maxSolicitudesPorCurso']}</li>
		<li>Mínimo de solicitudes por curso:
			${estadisticas['minSolicitudesPorCurso']}</li>
		<li>Desviación de solicitudes por curso:
			${estadisticas['desviacionSolicitudesPorCurso']}</li>
		<li>Mínimo de tutoriales por academia:
			${estadisticas['minTutorialesPorAcademia']}</li>
		<li>Media de tutoriales por academia:
			${estadisticas['mediaTutorialesPorAcademia']}</li>
		<li>Máximo de tutoriales por academia:
			${estadisticas['maxTutorialesPorAcademia']}</li>
	</ul>
</jstl:if>
<jstl:if test="${empty estadisticas}">
	<p>No hay datos disponibles.</p>
</jstl:if>

<!-- <table> -->
<!-- 	<tr> -->
<%-- 		<th><spring:message code="administrator.indicator" /></th> --%>
<%-- 		<th><spring:message code="administrator.value" /></th> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<%-- 		<td><spring:message code="administrator.count.all.shouts" /></td> --%>
<%-- 		<td><jstl:out value="${statistics.get('count.all.shouts')}" /></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<%-- 		<td><spring:message code="administrator.count.short.shouts" /></td> --%>
<%-- 		<td><jstl:out value="${statistics.get('count.short.shouts')}" /></td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<%-- 		<td><spring:message code="administrator.count.long.shouts" /></td> --%>
<%-- 		<td><jstl:out value="${statistics.get('count.long.shouts')}" /></td> --%>
<!-- 	</tr> -->
<!-- </table> -->
