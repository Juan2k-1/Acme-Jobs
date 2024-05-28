<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="alumn.myRequest.title" /></title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th><spring:message code="alumn.myRequest.course" /></th>
                <th><spring:message code="alumn.myRequest.date" /></th>
                <th><spring:message code="alumn.myRequest.state" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="solicitud" items="${solicitudes}">
                <tr>
                    <td>${solicitud.curso.titulo}</td>
                    <td>${solicitud.momento}</td>
                    <td>${solicitud.estado}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
