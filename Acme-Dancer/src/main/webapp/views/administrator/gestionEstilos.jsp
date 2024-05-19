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
<h2>Lista de Estilos</h2>
<table class="styles-table">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <jstl:forEach var="estilo" items="${estilos}">
            <tr>
                <td>${estilo.nombre}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/administrator/editarEstilo?id=${estilo.id}">Editar</a>
                    | <a href="${pageContext.request.contextPath}/administrator/gestionEstilos/delete?id=${estilo.id}" onclick="return confirm('¿Estás seguro de que deseas eliminar este estilo?');">Eliminar</a>
                </td>
            </tr>
        </jstl:forEach>
    </tbody>
</table>
