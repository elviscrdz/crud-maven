package com.e3software.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e3software.beans.Empleados;
@Repository
public class DAOempleadosImplementacion implements DAOempleado{
	@Autowired
	private DataSource datasource;
	public void registrar(Empleados empleado) throws Exception {
		String sentenciaSql="INSERT INTO EMPLEADOS (NOMBRES, APELLIDOS, EMPRESA, CORREO) VALUES(?,?,?,?);";
		Connection conexion=null;
		try {
			conexion=datasource.getConnection();
			PreparedStatement sentencia=conexion.prepareStatement(sentenciaSql);
			sentencia.setString(1, empleado.getNombres());
			sentencia.setString(2, empleado.getApellidos());
			sentencia.setString(3, empleado.getEmpresa());
			sentencia.setString(4, empleado.getCorreo());
			sentencia.executeUpdate();
			sentencia.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(conexion !=null) {
				conexion.close();
			}
		}
	}
}
