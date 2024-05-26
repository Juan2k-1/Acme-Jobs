<%--
 * action-1.jsp
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

<form:form id="register" method="POST" action="profile/editarDatos.do">

	<!-- Campos para la cuenta de usuario -->
	<label for="username"><spring:message code="profile.username" />:</label>
	<input type="text" id="username" name="username" />
	<br />

	<label for="password"><spring:message code="profile.password" />:</label>
	<input type="password" id="password" name="password" />
	<br />

	<!-- Campos para el actor -->
	<label for="nombre"><spring:message code="profile.nombre" />:</label>
	<input type="text" id="nombre" name="nombre" />
	<br />

	<label for="apellidos"><spring:message code="profile.apellidos" />:</label>
	<input type="text" id="apellidos" name="apellidos" />
	<br />

	<label for="email"><spring:message code="profile.email" />:</label>
	<input type="email" id="email" name="email" />
	<br />

	<label for="telefono"><spring:message code="profile.telefono" />:</label>
	<input type="text" id="telefono" name="telefono" />
	<br />
	
	<label for="direccion"><spring:message code="profile.direccion" />:</label>
	<input type="text" id="direccion" name="direccion" />
	<br />
	
	<label for="codigoPostal"><spring:message code="profile.codigoPostal" />:</label>
	<input type="text" id="codigoPostal" name="codigoPostal" />
	<br />


	<!-- Bot�n para enviar el formulario -->
	<input type="submit" value="<spring:message code="profile.registrarse" />" />

</form:form>

