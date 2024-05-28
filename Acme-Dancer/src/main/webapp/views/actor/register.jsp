<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<style>
    .hidden {
        display: none;
    }
</style>

<form:form id="register" method="POST" action="registerActor/register.do">

	<!-- Campos para la cuenta de usuario -->
	<label for="username"><spring:message code="register.username" />:</label>
	<input type="text" id="username" name="username" required />
	<br />

	<label for="password"><spring:message code="register.password" />:</label>
	<input type="password" id="password" name="password" required />
	<br />

	<!-- Campos para el actor -->
	<label for="nombre"><spring:message code="register.nombre" />:</label>
	<input type="text" id="nombre" name="nombre" required />
	<br />

	<label for="apellidos"><spring:message code="register.apellidos" />:</label>
	<input type="text" id="apellidos" name="apellidos" required />
	<br />

	<label for="email"><spring:message code="register.email" />:</label>
	<input type="email" id="email" name="email" required />
	<br />

	<label for="telefono"><spring:message code="register.telefono" />:</label>
	<input type="text" id="telefono" name="telefono" required />
	<br />
	
	<label for="direccion"><spring:message code="register.direccion" />:</label>
	<input type="text" id="direccion" name="direccion" />
	<br />
	
	<label for="codigoPostal"><spring:message code="register.codigoPostal" />:</label>
	<input type="text" id="codigoPostal" name="codigoPostal" />
	<br />

	<label for="actorType"><spring:message code="register.actorType" />:</label>
	<select id="actorType" name="actorType">
		<option value=""><spring:message code="register.seleccione" /></option>
		<option value="ALUMNO"><spring:message code="register.alumno" /></option>
		<option value="ACADEMIA"><spring:message code="register.academia" /></option>
	</select>
	<br />
	
		<!-- Campos específicos para Alumno -->
		<div id="alumnoFields" class="hidden" >
			<label for="titular"><spring:message code="register.titular" />:</label> 
		    <input type="text" id="titular" name="titular" /> <br />
		
		    <label for="marca"><spring:message code="register.marca" />:</label> 
		    <input type="text" id="marca" name="marca"  /> <br />
		
		    <label for="numero"><spring:message code="register.numero" />:</label> 
		    <input type="text" id="numero" name="numero" pattern="\d*" /> <br />
		
		    <label for="mes"><spring:message code="register.mes" />:</label> 
		    <input type="number" id="mes" name="mes" min="1" max="12"  /> <br />
		
		    <label for="año"><spring:message code="register.año" />:</label> 
		    <input type="number" id="año" name="año" min="2024"  /> <br />
		
		    <label for="codigoCVV"><spring:message code="register.codigoCVV" />:</label> 
		    <input type="text" id="codigoCVV" name="codigoCVV" pattern="\d{3}"  /> <br />
		</div>	

		<!-- Campos específicos para Academia -->
		<div id="academiaFields" class="hidden">
			<label for="nombreComercial"><spring:message code="register.nombreComercial" />:</label> <input
				type="text" id="nombreComercial" name="nombreComercial" /> <br />
		</div>


	<!-- Botón para enviar el formulario -->
	<input type="submit" name="guardar" value="<spring:message code="register.registrarse" />" />
</form:form>