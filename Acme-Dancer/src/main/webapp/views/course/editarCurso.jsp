<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
    <h2><spring:message code="curso.edit"/></h2>
    <form:form method="POST" action="course/guardarCurso.do" modelAttribute="curso">
        <form:hidden path="id"/>
        <form:hidden path="version" />
        <div>
            <label for="titulo"><spring:message code="curso.edit.title"/></label>
            <form:input path="titulo" id="nombre"/>
        </div>
        <div>
            <label for="nivel"><spring:message code="curso.edit.nivel"/></label>
            <form:input path="nivel" id="nivel" />
        </div>
        
         <div>
            <label for="fechaInicio"><spring:message code="curso.edit.fechini"/></label>
            <form:input path="fechaInicio" id="fechaInicio" />
        </div>
        <div>
            <label for="fechaFin"><spring:message code="curso.edit.fechfin"/></label>
            <form:input path="fechaFin" id="fechaFin" />
        </div>
        <div>
            <label for="hora"><spring:message code="curso.edit.hora"/></label>
            <form:input path="hora" id="hora" />
        </div>
        <div>
            <label for="estilo"><spring:message code="curso.edit.estilo"/></label>
            <form:input path="estilo" id="estilo" />
        </div>
        <div>
            <label for="academia"><spring:message code="curso.edit.academia"/></label>
            <form:input path="academia" id="academia" />
        </div>
        
        <div>
            <input type="submit" value="<spring:message code="curso.edit.save"/>"/>
        </div>
    </form:form>
</div>

