package v1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MuchosPaises mc=new MuchosPaises();
		mc.cargarPaises();
		System.out.println(mc.toStringPaises());
		mc.cargarCiudades();
		mc.cargarDirecciones();
		System.out.println(mc.toString());
		}

}
