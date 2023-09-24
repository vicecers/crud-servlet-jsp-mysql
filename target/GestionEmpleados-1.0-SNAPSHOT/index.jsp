<%-- 
    Document   : index
    Created on : 24 sep. 2023, 11:50:45
    Author     : vicec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú de Opciones</title>
    </head>
    <body>
        <h1>Menu de opciones Empleados</h1>
        <table border="1">
            <tr>
                <td><a href="EmpleadoController?opcion=crear"> Crear un Empleado</a></td>
            </tr>
            <tr>
                <td><a href="EmpleadoController?opcion=listar"> Listar Empleados</a></td>
            </tr>
        </table>
    </body>
</html>
