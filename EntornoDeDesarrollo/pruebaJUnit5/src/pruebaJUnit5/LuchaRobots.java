package pruebaJUnit5;

public class LuchaRobots {
	private String estadio;
	private Robot luchadores[];
	private String arbitro;
	private int numLuchadores;
	
	public LuchaRobots(String estadio, String arbitro) {
		try {
			this.setEstadio(estadio);
			this.setArbitro(arbitro);
			luchadores = new Robot[2];
			this.numLuchadores=0;
		}
		catch(Exception e) {
			
		}
	}
	
	public int añadeRobot(String ID, float vida, float fuerza ) {
		if (numLuchadores < 2) {
			Robot robot = new Robot(ID, vida, fuerza);
			luchadores[numLuchadores]= robot;
			numLuchadores++;
			
		}
		
		return numLuchadores;
	}
	
	public int getNumLuchadores() {
		return numLuchadores;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) throws NotAllowedChangeException{
		if (numLuchadores == 0) {
			this.estadio = estadio;
		}
		else {
			throw new NotAllowedChangeException("Ya se han añadido luchadores");
		}
	}

	public String getArbitro() {
		return arbitro;
	}

	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}
	
	
	
	

}