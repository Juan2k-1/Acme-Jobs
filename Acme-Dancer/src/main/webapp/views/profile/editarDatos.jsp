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

<form:form id="register" method="POST" action="profile/editarDatos.do" modelAttribute="actor">

<!-- 	 <!-- Campos para la cuenta de usuario --> -->
<%--     <label for="username"><spring:message code="profile.username" />:</label>  --%>
<%--     <input type="text" id="username" name="username" value="${actor.cuentaUsuario.username}" required/>  --%>
<!--      <br />  -->
     
<%--      <label for="password"><spring:message code="profile.password" />:</label>  --%>
<%--     <input type="password" id="password" name="password" value="${actor.cuentaUsuario.password}" required/>  --%>
<!--     <br />  -->

    <!-- Campos para el actor -->
    <label for="nombre"><spring:message code="profile.nombre" />:</label>
    <input type="text" id="nombre" name="nombre" value="${actor.nombre}" required/>
    <br />

    <label for="apellidos"><spring:message code="profile.apellidos" />:</label>
    <input type="text" id="apellidos" name="apellidos" value="${actor.apellidos}" required/>
    <br />

    <label for="email"><spring:message code="profile.email" />:</label>
    <input type="email" id="email" name="email" value="${actor.email}" required/>
    <br />

    <label for="telefono"><spring:message code="profile.telefono" />:</label>
    <input type="text" id="telefono" name="telefono" value="${actor.telefono}" required/>
    <br />
    
    <label for="direccion"><spring:message code="profile.direccion" />:</label>
    <input type="text" id="direccion" name="direccion" value="${actor.direccion.direccion}"/>
    <br />
    
    <label for="codigoPostal"><spring:message code="profile.codigoPostal" />:</label>
    <input type="text" id="codigoPostal" name="codigoPostal" value="${actor.direccion.codigoPostal}"/>
    <br />

    <security:authorize access="hasRole('ALUMNO')">
        <label for="infoTarjeta"><spring:message code="profile.infoTarjeta" />:</label>
        <br />
    
        <label for="titular"><spring:message code="profile.titular" />:</label> 
        <input type="text" id="titular" name="titular" value="${actor.tarjetaCredito.titular}" required/> <br />
    
        <label for="marca"><spring:message code="profile.marca" />:</label> 
        <input type="text" id="marca" name="marca" value="${actor.tarjetaCredito.marca}" required/> <br />
    
        <label for="numero"><spring:message code="profile.numero" />:</label> 
        <input type="text" id="numero" name="numero" value="${actor.tarjetaCredito.numero}" pattern="\d{13,19}" required/> <br />
    
        <label for="mes"><spring:message code="profile.mes" />:</label> 
        <input type="number" id="mes" name="mes" value="${actor.tarjetaCredito.mes}" min="1" max="12" required/> <br />
    
        <label for="año"><spring:message code="profile.año" />:</label> 
        <input type="number" id="año" name="año" value="${actor.tarjetaCredito.año}" min="2024" required/> <br />
    
        <label for="codigoCVV"><spring:message code="profile.codigoCVV" />:</label> 
        <input type="text" id="codigoCVV" name="codigoCVV" value="${actor.tarjetaCredito.codigoCVV}" pattern="\d{3}" required/> <br />
    </security:authorize>
    
    <security:authorize access="hasRole('ACADEMIA')">
        <!-- Campos específicos para Academia -->
        <div id="academiaFields">
            <label for="nombreComercial"><spring:message code="register.nombreComercial" />:</label> 
            <input type="text" id="nombreComercial" name="nombreComercial" value="${actor.nombreComercial}" required/> <br />
        </div>
    </security:authorize>

    <!-- Botón para enviar el formulario -->
    <input type="submit" value="<spring:message code='profile.registrarse' />" />

</form:form>

