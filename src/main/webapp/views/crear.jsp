<%-- 
    Document   : crear
    Created on : 24 sep. 2023, 16:48:19
    Author     : vicec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Empleado</h1>
        <form action="EmpleadoController" method="post">
            <input type="hidden" name="opcion" value="guardar">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" size="50"></td>
                </tr>
                <tr>
                    <td>Departamento:</td>
                    <td><input type="text" name="departamento" size="50"></td>
                </tr>
            </table>
            <input type="submit" value="Guardar">
        </form>
    </body>
</html>
