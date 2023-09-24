<%-- 
    Document   : listar
    Created on : 24 sep. 2023, 16:48:46
    Author     : vicec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Empleados</title>
    </head>
    <body>
        <h1>Listar Empleados</h1>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Departamento</td>
                <td>Accion</td>
            </tr>
            <c:forEach var="empleado" items="${lista}">
                <tr>
                    <td>
                        <a href="EmpleadoController?opcion=editar&id=<c:out value="${empleado.id}"></c:out>">
                            <c:out value="${empleado.id}"></c:out>
                        </a>
                    </td>
                    <td><c:out value="${empleado.nombre}"></c:out></td>
                <td><c:out value="${empleado.departamento}"></c:out></td>
                <td>
                    <a href="EmpleadoController?opcion=eliminar&id=<c:out value="${empleado.id}"></c:out>">
                        Eliminar 
                    </a>
                </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
