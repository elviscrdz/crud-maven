package com.e3software.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.e3software.beans.Empleados;
import com.e3software.services.ServiceEmpleado;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Empleados empleado0=new Empleados();
        empleado0.setNombres("Pedro");
        empleado0.setApellidos("Perez");
        empleado0.setEmpresa("Empresa");
        empleado0.setCorreo("ejemplo@hotmail.com");
        ApplicationContext appcontext=new ClassPathXmlApplicationContext("com/e3software/beans.xml");
        ServiceEmpleado servicioEmpleado=(ServiceEmpleado)appcontext.getBean("serviceEmpleadoImplement");
        try {
        	servicioEmpleado.registrar(empleado0);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
