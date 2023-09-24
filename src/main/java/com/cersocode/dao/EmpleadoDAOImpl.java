/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cersocode.dao;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cersocode.conexion.Conexion;
import com.cersocode.model.Empleado;


/**
 *
 * @author vicec
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {
    
    private Connection connection;
    private PreparedStatement statement;
    private boolean estadoOperacion;

    // obtener conexion pool
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
    
    @Override
    public boolean guardar(Empleado empleado) {
        String sql = null;
        estadoOperacion = false;
        
        try {
            connection = obtenerConexion();
            connection.setAutoCommit(false);
            sql = "INSERT INTO empleados (id, nombre, dpto)VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getDepartamento());
            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            e.printStackTrace();
        }
        return estadoOperacion;
        
    }
    
    @Override
    public boolean editar(Empleado empleado) {
        String sql = null;
        estadoOperacion = false;
        
        try {
            connection = obtenerConexion();
            connection.setAutoCommit(false);
            sql = "UPDATE empleados SET nombre=?, dpto=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getDepartamento());
            statement.setInt(3, empleado.getId());
            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
               
            }
            e.printStackTrace();
        }
        
        return estadoOperacion;
    }
    
    @Override
    public boolean eliminar(int idEmpleado) {
        String sql = null;
        estadoOperacion = false;
        
        try {
            connection = obtenerConexion();
            connection.setAutoCommit(false);
            sql = "DELETE FROM empleados WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idEmpleado);
            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            e.printStackTrace();
        }
        
        return estadoOperacion;
    }
    
    @Override
    public List<Empleado> obtenerEmpleados() {
        ResultSet resultSet = null;
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = null;
        estadoOperacion = false;
        
        try {
            sql = "SELECT * FROM empleados";
            connection = obtenerConexion();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado e = new Empleado();
                e.setId(resultSet.getInt(1));
                e.setNombre(resultSet.getString(2));
                e.setDepartamento(resultSet.getString(3));
                
                listaEmpleados.add(e);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaEmpleados;
    }
    
    @Override
    public Empleado obtenerEmpleado(int idEmpleado) {
        ResultSet resultSet = null;
        Empleado emp = new Empleado();
        
        String sql = null;
        estadoOperacion = false;
        
        try {
            sql = "SELECT * FROM empleados WHERE id =?";
            connection = obtenerConexion();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idEmpleado);
            
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                emp.setId(resultSet.getInt(1));
                emp.setNombre(resultSet.getString(2));
                emp.setDepartamento(resultSet.getString(3));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return emp;
    }
        
}
