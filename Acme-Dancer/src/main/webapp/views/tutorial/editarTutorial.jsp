<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
    <h2><spring:message code="tutorial.edit.style"/></h2>
    <form:form method="POST" action="tutorial/guardarTutorial.do" modelAttribute="tutorial">
        <form:hidden path="id"/>
        <form:hidden path="version" />
        <form:hidden path="numReproducciones"/>
        <div>
            <label for="nombre"><spring:message code="tutorial.edit.title"/></label>
            <form:input path="titulo" id="nombre"/>
        </div>
        
        <div>
            <label for="descripcion"><spring:message code="tutorial.edit.description"/></label>
            <form:input path="descripcion" id="descripcion" />
        </div>
        
         <div>
            <label for="video">URL</label>
            <form:input path="video" id="video" />
        </div>
        
        <div>
            <input type="submit" value="<spring:message code="tutorial.edit.save"/>"/>
        </div>
    </form:form>
</div>

