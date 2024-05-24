<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
    <h2><spring:message code="administrator.edit.style"/></h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/administrator/guardarEstilo.do" modelAttribute="estilo">
        <form:hidden path="id"/>
        <div>
            <label for="nombre"><spring:message code="administrator.name"/></label>
            <form:input path="nombre" id="nombre"/>
        </div>
        
        <div>
            <label for="descripcion"><spring:message code="administrator.description"/></label>
            <form:input path="descripcion" id="descripcion" />
        </div>
        
        <div>
            <input type="submit" value="<spring:message code='administrator.save.changes'/>"/>
        </div>
    </form:form>
</div>

