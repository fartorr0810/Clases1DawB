package v2;

public class TareaCliente extends Tarea{
	private String nombrecliente;
	private String ciudad;
	
	public TareaCliente(String descripcion, String prioridad, String nombrecliente, String ciudad) {
		super(descripcion, prioridad);
		this.nombrecliente=nombrecliente;
		this.ciudad=ciudad;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	

}
