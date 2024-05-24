<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<label for="username">Nombre de usuario:</label>
	<input type="text" id="username" name="username" />
	<br />

	<label for="password">Contraseña:</label>
	<input type="password" id="password" name="password" />
	<br />

	<!-- Campos para el actor -->
	<label for="nombre">Nombre:</label>
	<input type="text" id="nombre" name="nombre" />
	<br />

	<label for="apellidos">Apellidos:</label>
	<input type="text" id="apellidos" name="apellidos" />
	<br />

	<label for="email">Email:</label>
	<input type="email" id="email" name="email" />
	<br />

	<label for="telefono">Teléfono:</label>
	<input type="text" id="telefono" name="telefono" />
	<br />
	
	<label for="direccion">Dirección:</label>
	<input type="text" id="direccion" name="direccion" />
	<br />
	
	<label for="codigoPostal">Código Postal:</label>
	<input type="text" id="codigoPostal" name="codigoPostal" />
	<br />

	<label for="actorType">Tipo de actor:</label>
	<select id="actorType" name="actorType">
		<option value="">Seleccione</option>
		<option value="ALUMNO">Alumno</option>
		<option value="ACADEMIA">Academia</option>
	</select>
	<br />

	<!-- Campos específicos para Alumno -->
	<div id="alumnoFields" class="hidden">
		<label for="tarjetaCredito">Tarjeta de Crédito:</label> <input
			type="text" id="tarjetaCredito" name="tarjetaCredito" /> <br />
	</div>

	<!-- Campos específicos para Academia -->
	<div id="academiaFields" class="hidden">
		<label for="nombreComercial">Nombre Comercial:</label> <input
			type="text" id="nombreComercial" name="nombreComercial" /> <br />
	</div>

	<!-- Botón para enviar el formulario -->
	<input type="submit" value="Registrarse" />

</form:form>