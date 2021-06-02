package v2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;



public class Empresa {
	private LinkedList<Tarea>tareasprogreso;
	private HashSet<Tarea>tareasterminadas;
	
	public Empresa() {
		tareasprogreso =new LinkedList<Tarea>();
		tareasterminadas =new HashSet<Tarea>();
	}
	public boolean addTareaEmpresa(String descripcion,String prioridad, String departamento) throws Exception {
		boolean result=false;
		boolean encontrado=true;
		TareaEmpresa t=new TareaEmpresa(descripcion, prioridad, departamento);
		Iterator<Tarea> sig = tareasprogreso.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Tarea tarea = (Tarea) sig.next();
			if (tarea instanceof TareaEmpresa) {
				if (tarea.equals(t)) {
					encontrado=true;
					throw new Exception("Esa tarea ya existe");
					}
				else {
					tareasprogreso.add(t);
					result=true;
				}
			}
		}
		return result;
		}

	public boolean addTareaCliente(String descripcion,String prioridad, String nombrecliente, String ciudad) 
			throws Exception {
		boolean result=false;
		boolean encontrado=true;
		TareaCliente t=new TareaCliente(descripcion, prioridad, nombrecliente, ciudad);
		Iterator<Tarea> sig = tareasprogreso.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Tarea tarea = (Tarea) sig.next();
			if (tarea instanceof TareaCliente) {
				if (tarea.equals(t)) {
					encontrado=true;
					throw new Exception("Esa tarea ya existe");
					}
				else {
					tareasprogreso.add(t);
					result=true;
				}
			}
		}
		return result;
		}
	//mostratTareas():   devolverá   un   String   con   el   listado   de   tareas   pendientes   
	//de  realizarordenados de forma ascendente por la fecha de creación
	public String mostrarTareas() {
		String sb=new String();
		Collections.sort(tareasprogreso);
		for (Tarea tarea :tareasprogreso) {
			sb+=""+tarea.toString()+"\n";
		}
		return sb.toString();
	}
}

