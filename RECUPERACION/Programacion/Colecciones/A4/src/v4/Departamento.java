package v4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Departamento {
	private String nombre;
	private ArrayList<Empleado> lista;
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
		lista=new ArrayList<Empleado>();
	}

	public String getNombre() {
		return nombre;
	}
//	addEmpleado, debe recibir un empleado y añadirlo a la lista. Devolverá true si se ha 
//	podidoañadir y false si no se ha podido añadir porque ya estaba en ese departamento o 
//	porque elempleado que recibe como argumento es un jefe
	
	//La ultima parte no la entiendo,porque el siguiente metodo es el de anadirjefe.
	//Yo entiendo que este metodo sirve para anadir un empleadobase sin mas a la lista.
	
	public boolean addEmpleado(String dni, String nombre,String puesto) throws Exception {
		boolean result=false;
		EmpleadoBase nb=new EmpleadoBase(dni, nombre, puesto);
		
		if (lista.contains(nb)) {
			result=false;
		}else {
			lista.add(nb);
		}
		return result;
	}
//	addJefe,   deber   recibir   como   argumento   un   empleado   que   debe   ser   del   tipo   
//	jefe   dedepartamento y devolverá true si se ha podido añadir y false en caso contrario. Sólo se
//	podráañadir un jefe de departamento, sea cual sea.
	public boolean addJefe(String dni, String nombre, double sueldo,int antiguedad) throws Exception {
		boolean result=false;
		boolean encontrado=false;
		Jefe j=new Jefe(dni, nombre, sueldo, antiguedad);
		Iterator<Empleado> sig = lista.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Empleado j1 = (Empleado) sig.next();
			if (j1 instanceof Jefe) {
				encontrado=true;
				result=false;
				throw new Exception("Solo se permite un jefe por departamento");
				}
			}
		if (encontrado==false) {
			lista.add(j);
		}
		return result;
	}
	//obtenerSueldo(), el método no recibe nada y devolverá la suma de todos los sueldos de todoslos empleados.
	public double obtenerSueldo() {
		double totalsueldo=0;
		for (Empleado empleado : lista) {
			totalsueldo+=empleado.getSueldo();
		}
		return totalsueldo;
	}
	//toString(), devuelve una cadena con el nombre del departamento y todos los empleados
//	(jefes   y   empleados   base).   Los   nombres   de   empleados   deben   mostrarse 
//	ordenados   pornombre.
	public String toString() {
		String mensaje="";
		Collections.sort(lista);
		for (Empleado empleado : lista) {
			if (empleado instanceof Jefe) {
				mensaje+=((Jefe) empleado).toString()+"\n";
			}
			else if (empleado instanceof EmpleadoBase) {
				mensaje+=((EmpleadoBase) empleado).toString()+"\n";
				}
		}
		return mensaje;
	}
//	toStringSueldo(),   devuelve   una   cadena   con   el   nombre   del   departamento  
//	y   todos   losempleados (jefes y empleados base). Los nombres de empleados deben mostrarse 
//	ordenadospor sueldo de forma que aparezcan primero los que más cobran. 
	public String toStringSueldo() {
		String mensaje="";
		Collections.sort(lista, new OrdenarPorSueldoYnombre());
		for (Empleado empleado : lista) {
			if (empleado instanceof Jefe) {
				mensaje+=((Jefe) empleado).toString()+"\n";
			}
			else if (empleado instanceof EmpleadoBase) {
				mensaje+=((EmpleadoBase) empleado).toString()+"\n";
				}
		}
		return mensaje;
	}
}
