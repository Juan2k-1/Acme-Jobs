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

<jstl:choose>
    <jstl:when test="${not empty estadisticas}">
        <table class="styles-table">
            <thead>
                <tr>
                    <th><spring:message code="administrator.estadisticas" /></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><spring:message code="administrator.media.curso" /></td>
                    <td>${estadisticas['mediaCursosPorAcademia']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.max.courses" /></td>
                    <td>${estadisticas['maxCursosPorAcademia']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.min.courses" /></td>
                    <td>${estadisticas['minCursosPorAcademia']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.desv.courses" /></td>
                    <td>${estadisticas['desviacionCursosPorAcademia']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.media.requests.courses" /></td>
                    <td>${estadisticas['mediaSolicitudesPorCurso']}</td>
                </tr>
                <tr>
                    <td><spring:message code="administrator.max.requests.courses" /></td>
                    <td>${estadisticas['maxSolicitudesPorCurso']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.min.requests.courses" /></td>
                    <td>${estadisticas['minSolicitudesPorCurso']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.desv.requests.courses" /></td>
                    <td>${estadisticas['desviacionSolicitudesPorCurso']}</td>
                </tr>
                <tr>
                    <td><spring:message code="administrator.min.tutorials.academy" /></td>
                    <td>${estadisticas['minTutorialesPorAcademia']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.media.tutorials.academy" /></td>
                    <td>${estadisticas['mediaTutorialesPorAcademia']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.max.tutorials.academy" /></td>
                    <td>${estadisticas['maxTutorialesPorAcademia']}</td>
                </tr>
                
                 <tr>
                    <td><spring:message code="administrator.media.comentaries.actor" /></td>
                    <td>${estadisticas['mediaComentariosPorActor']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.media.subscribers.actor" /></td>
                    <td>${estadisticas['mediaSuscriptoresPorActor']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.min.reproductions" /></td>
                    <td>${estadisticas['minReproducciones']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.media.reproductions" /></td>
                    <td>${estadisticas['mediaReproducciones']}</td>
                </tr>
                
                <tr>
                    <td><spring:message code="administrator.max.reproductions" /></td>
                    <td>${estadisticas['maxReproducciones']}</td>
                </tr>
            </tbody>
        </table>
    </jstl:when>
    <jstl:otherwise>
        <p>
            <spring:message code="administrator.no.data" />.
        </p>
    </jstl:otherwise>
</jstl:choose>