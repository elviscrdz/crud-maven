package com.e3software.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3software.beans.Empleados;
import com.e3software.dao.DAOempleado;
@Service
public class ServiceEmpleadoImplement implements ServiceEmpleado{
	@Autowired
	private DAOempleado empleadodao;

	public void registrar(Empleados empleado) throws Exception {
		try {
			empleadodao.registrar(empleado);
		}catch(Exception e) {
			throw e;
		}
		
	}

}
