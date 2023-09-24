/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cersocode.controller;

import com.cersocode.dao.EmpleadoDAO;
import com.cersocode.dao.EmpleadoDAOImpl;
import com.cersocode.model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vicec
 */
@WebServlet(name = "EmpleadoController", urlPatterns = {"/EmpleadoController"})
public class EmpleadoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if (opcion.equals("crear")) {
            System.out.println("Usted a presionado la opcion crear");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
            requestDispatcher.forward(request, response);

        } else if (opcion.equals("listar")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
            List<Empleado> lista = new ArrayList<>();
            lista = empleadoDAO.obtenerEmpleados(); 
            for (Empleado empleado : lista) {
                System.out.println(empleado);
            }
            request.setAttribute("lista", lista);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
            requestDispatcher.forward(request, response);

            System.out.println("Usted a presionado la opcion listar");

        } else if (opcion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Editar id: " + id);
            EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
            Empleado emp = new Empleado();
            emp = empleadoDAO.obtenerEmpleado(id); 
            System.out.println(emp);
            request.setAttribute("empleado", emp);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
            requestDispatcher.forward(request, response);

        } else if (opcion.equals("eliminar")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
            int id = Integer.parseInt(request.getParameter("id"));

            empleadoDAO.eliminar(id); // TODO Auto-generated catch block
            System.out.println("Registro eliminado satisfactoriamente...");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        }
        // response.getWriter().append("Served at: ").append(request.getContextPath())
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");
      

        if (opcion.equals("guardar")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
            Empleado empleado = new Empleado();
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setDepartamento(request.getParameter("departamento"));
      
            empleadoDAO.guardar(empleado); // TODO Auto-generated catch block
            System.out.println("Registro guardado satisfactoriamente...");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
            
        } else if (opcion.equals("editar")) {
            Empleado empleado = new Empleado();
            EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

            empleado.setId(Integer.parseInt(request.getParameter("id")));
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setDepartamento(request.getParameter("departamento"));

            empleadoDAO.editar(empleado); // TODO Auto-generated catch block
            System.out.println("Registro editado satisfactoriamente...");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }

        // doGet(request, response);
    }

}
