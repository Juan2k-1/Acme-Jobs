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

<!-- Listado de cursos existentes -->
<table class="styles-table">
    <thead>
        <tr>
            <th><spring:message code="academia.nombre"/></th>
            <th><spring:message code="academia.cursos"/></th>
        </tr>
    </thead>
    <tbody>
        <jstl:forEach var="academias" items="${academias}">
            <tr>
                <td>${academias.nombreComercial}</td> 
                <td>
                <jstl:forEach var="cursos" items="${academias.cursos}">
                <a href="course/DatosCursos.do?id=${cursos.id}">${cursos.titulo}</a>
                 </jstl:forEach>
                 </td>
            </tr>
        </jstl:forEach>

    </tbody>
</table>
