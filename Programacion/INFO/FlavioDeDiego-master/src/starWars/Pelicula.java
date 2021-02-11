package starWars;

public class Pelicula {

	
		private String nombre;
		private int year;
		private Personaje p1;
		private Personaje p2;
		private Personaje p3;
		
	

		
		
		public Pelicula() {
			
		}
		
		public Pelicula(String nombre, int year, Personaje p1, Personaje p2, Personaje p3) {
			this.nombre=nombre;
			this.year=year;
			this.p1=p1;
			this.p2=p2;
			this.p3=p3;
			
			
		}
		
		
		public String compararFecha(Pelicula peli) {
				
			String result="";
			
			if (this.year == peli.getYear()) {
				
				result = "Son iguales";
			}else if(this.year>peli.getYear()) {
				result="La pelicula más reciente es " + peli.getNombre();
			}else {
				result="La pelicula más reciente es " + this.getNombre();
			}

			return result;
		}
		
		public int poderMaximo(Pelicula peli) {
			
			
			
			return peli.getP1().getPoder() + peli.getP2().getPoder() + peli.getP3().getPoder();
		}
		
		
		@Override
		public String toString() {
			return "";
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public Personaje getP1() {
			return p1;
		}

		public void setP1(Personaje p1) {
			this.p1 = p1;
		}

		public Personaje getP2() {
			return p2;
		}

		public void setP2(Personaje p2) {
			this.p2 = p2;
		}

		public Personaje getP3() {
			return p3;
		}

		public void setP3(Personaje p3) {
			this.p3 = p3;
		}
		
}
