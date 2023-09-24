/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cersocode.dao;

import com.cersocode.model.Empleado;
import java.util.List;

/**
 *
 * @author vicec
 */
public interface EmpleadoDAO {

    // guardar empleado
    boolean guardar(Empleado empleado);

    // editar empleado
    boolean editar(Empleado empleado);

    // eliminar empleados
    boolean eliminar(int idEmpleado);

    // obtener lista de empleados
    public List<Empleado> obtenerEmpleados();

    // obtener empleado
    Empleado obtenerEmpleado(int idEmpleado);

}
