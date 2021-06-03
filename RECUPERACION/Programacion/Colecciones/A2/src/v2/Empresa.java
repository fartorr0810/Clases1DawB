package v2;

import java.time.LocalDate;
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
	public boolean AddTareaEmpresa(String descripcion,String departamento,String prioridad) throws Exception {
		boolean anadido=false;
		TareaEmpresa t1=new TareaEmpresa(descripcion,departamento,prioridad);
		if(tareasprogreso.contains(t1)) {
			anadido=false;
		}else {
			tareasprogreso.add(t1);
			anadido=true;
		}
		return anadido;
	}

	public boolean AddTareaCliente(String descripcion,String prioridad,String nombrecliente, String localidad) throws Exception {
		boolean anadido=false;
		TareaCliente t1=new TareaCliente(descripcion, prioridad,nombrecliente, localidad);
		if(tareasprogreso.contains(t1)) {
			anadido=false;
		}else {
			tareasprogreso.add(t1);
			anadido=true;
		}
		return anadido;
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
//	mostrarTareasPrioridad(): devolverá un String con el listado de tareas existentes ordenadosde 
//	forma que salgan primero las tareas de prioridad Alta, luego las medias y luego las bajas.Para
//	las tareas con la misma prioridad se ordenarán de forma alfabética por la descripción.
	public String mostrarTareasPrioridad() {
		String sb=new String();
		Collections.sort(tareasprogreso,new OrdenarTareaPorPrioridadAlfabeto());
		for (Tarea tarea :tareasprogreso) {
			sb+=""+tarea.toString()+"\n";
		}
		return sb.toString();
	}
//	numTareasPendientes()   devolverá   un   String   en   el   que   se   muestre   el   número  
//	de   tareaspendientes de cada tipo, es decir, algo así como : “Alta- 3, Media-10, Baja-2” si tenemospendiente 
//	3 tareas de prioridad alta, 10 de prioridad media y 2 de prioridad baja.
	public String numTareasPendientes() {
		int alta=0,media=0,baja=0;
		for (Tarea tarea : tareasprogreso) {
			if (tarea.getPrioridad().equals(Prioridad.valueOf("ALTA")) && tarea.isResulta()==false) {
				alta++;
			}else if (tarea.getPrioridad().equals(Prioridad.valueOf("MEDIA")) && tarea.isResulta()==false) {
				media++;
			}
			else if (tarea.getPrioridad().equals(Prioridad.valueOf("BAJA")) && tarea.isResulta()==false) {
				baja++;
			}
		}
		return "Tareas altas: "+alta+" Tareas medias: "+media+" Tareas bajas: "+baja;
	}
//	resolverTarea(descripcion String, fechaCreacion fecha, fechaSolucion fecha): este métodono
//	debe devolver nada y debe añadir la tarea que tiene la descripción y la fecha de creaciónque recibe 
//	como argumento a la lista de tareas resueltas y asignarle la fechad de soluciónque se le pasa por 
//	parámetros. Si la fecha de solución que recibe como parámetro es menorque la fecha de creación o 
//	no existe la tarea se deberá lanzar la correspondiente excepción.
	public void resolverTarea(String descripcion,LocalDate fechacreacion,LocalDate fechasolucion) throws Exception {
		boolean encontrado=false;
		Iterator<Tarea> sig = tareasprogreso.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Tarea t1 = (Tarea) sig.next();
			if (t1.getDescripcion().equals(descripcion) && t1.getFechaalta().isEqual(fechacreacion)) {
				if (fechasolucion.isBefore(fechacreacion)) {
					throw new Exception("La fecha de solucion no puede ser menor a la fecha creacion");
				}
				else {
					t1.resolverTarea();
					tareasterminadas.add(t1);
				}
				
				}
			}
	}
}
