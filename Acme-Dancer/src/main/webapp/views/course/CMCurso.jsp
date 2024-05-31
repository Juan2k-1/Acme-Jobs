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
                 
                <td><a href="course/editarCurso.do?id=${cursos.id}">Editar</a>|
                <a href="course/eliminarCurso.do?id=${cursos.id}">Eliminar</a></td>
                   
            </tr>
            </jstl:forEach>
    </tbody>
</table>

<!-- Formulario para crear un nuevo estilo -->
<h2>
	<spring:message code="course.create.new.course" />
</h2>
<form:form method="POST" action="course/crearCurso.do" modelAttribute="nuevoCurso">
		<div>
			<label for="titulo"><spring:message code="curso.create.title" /></label>
			<input type="text" id="titulo" name="titulo" required />
		</div>
		
		<div>			
			<label for="nivel"><spring:message code="curso.create.nivel" /></label>
			<select id="nivel" name="nivel">
				<option value="PRINCIPIANTE">PRINCIPIANTE</option>
				<option value="INTERMEDIO">INTERMEDIO</option>
				<option value="AVANZADO">AVANZADO</option>
				<option value="PROFESIONAL">PROFESIONAL</option>
			</select>
		</div>

		<div>
			<label for="fechaInicio" ><spring:message code="curso.create.fechini" /></label>
			<input type="date" id="fechaInicio" name="fechaInicio" required />
		</div>
		
		<div>
			<label for="fechaFin"><spring:message code="curso.create.fechaFin" /></label>
			<input type="date" id="fechaFin" name="fechaFin" required />
		</div>
		
		<div>
			<label for="hora"><spring:message code="curso.create.hora" /></label>
			<input type="text" id="hora" name="hora" required />
		</div>
		
		<div>
			<label for="estilo"><spring:message code="curso.create.estilo" />:</label>
			<select id="estilo" name="estilo">
				<jstl:forEach var="estilo" items="${estilos}">
						<option value="${estilo.nombre}">${estilo.nombre}</option>
				</jstl:forEach>
			</select>
		</div>

		<div>
			<input type="submit" value="<spring:message code="curso.create.save"/>" />
		</div>
	</form:form>
