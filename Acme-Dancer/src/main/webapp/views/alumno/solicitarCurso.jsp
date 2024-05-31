<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="alumn.requestCourse.title" /></title>
</head>
<body>
    <form:form modelAttribute="registeredFor" action="alumno/solicitarCurso.do" method="post">
        <table>
            <tr>
                <td><spring:message code="alumn.requestCourse.course" /></td>
                <td>
                    <form:select path="curso.id">
                        <form:options items="${cursos}" itemValue="id" itemLabel="titulo" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="alumn.requestCourse.button" />" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
