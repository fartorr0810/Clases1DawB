package v2;

public class TareaEmpresa extends Tarea{
	private String departamento;
	
	public TareaEmpresa(String descripcion, String prioridad,String departamento) throws Exception {
		super(descripcion, prioridad);
		this.departamento=departamento;
	}
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
