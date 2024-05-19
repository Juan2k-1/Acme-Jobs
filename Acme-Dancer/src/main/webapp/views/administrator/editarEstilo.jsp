<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Estilo</title>
</head>
<body>

<h1>Editar Estilo</h1>

<form:form method="post" action="/administrator/guardarEstilo" modelAttribute="estilo">
    <form:hidden path="id" />
    <label>Nombre del Estilo:</label>
    <form:input path="nombre" />
    <form:errors path="nombre" cssClass="error" />
    <br/>
    <input type="submit" value="Actualizar" />
</form:form>

</body>
</html>