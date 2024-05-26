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

<!-- Datos de curso -->
<table class="styles-table">
    <thead>
        <tr>
            <th><spring:message code="curso.nombre"/></th>
            <th><spring:message code="curso.nivel"/></th>
            <th><spring:message code="curso.inicio"/></th>
            <th><spring:message code="curso.fin"/></th>
            <th><spring:message code="cursos.hora"/></th>
            <th><spring:message code="curso.estilo"/></th>
            <th><spring:message code="curso.academia"/></th>
        </tr>
    </thead>
    <tbody>
            <tr>
                <td>${curso.titulo}</td>
                <td>${curso.nivel}</td>
                <td>${curso.fechaInicio}</td>  
                <td>${curso.fechaFin}</td>  
                <td>${curso.hora}</td>  
                <td>${curso.estilo.nombre}</td>  
                <td>${curso.academia.nombreComercial}</td>     
            </tr>
    </tbody>
</table>
