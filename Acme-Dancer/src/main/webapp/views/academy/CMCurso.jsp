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

<!-- CM de Cursos -->
<table class="styles-table">
    <thead>

        <tr>
        
            <th><spring:message code="curso.nombre"/></th>
            <th><spring:message code="curso.nivel"/></th>
            <th><spring:message code="curso.inicio"/></th>
            <th><spring:message code="curso.fin"/></th>
            <th><spring:message code="curso.hora"/></th>
            <th><spring:message code="curso.estilo"/></th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
    		<jstl:forEach var="cursos" items="${cursos}">
            <tr>
                <td>${cursos.titulo}</td>
                <td>${cursos.nivel}</td>
                <td>${cursos.fechaInicio}</td>  
                <td>${cursos.fechaFin}</td>  
                <td>${cursos.hora}</td>  
                <td>${cursos.estilo.nombre}</td> 
                <td><a href="course/EditarCurso.do?id=${cursos.id}">Editar</a>|
                <a href="course/EliminarCurso.do?id=${cursos.id}">Eliminar</a></td>
                   
            </tr>
            </jstl:forEach>
    </tbody>
</table>
