package logicaJuego;

public class ImprimirMatrices {

	public static final String CORCHETE_APERTURA = "|";
	public static final String CORCHETE_CIERRE = "|";
	public static final String SEPARADOR = "|";
	public static final String SALTO_DE_LINEA = "\n";

	public static String printMatrix(char [][] matrix) {
		
		StringBuilder sb = new StringBuilder();
		
		if(matrix.length>0) {
			for(int i=0; i< matrix.length; i++) {
				for(int j = 0; j<matrix[i].length; j++) {
					if(j==0) {
						sb.append(CORCHETE_APERTURA);
					}
					sb.append(matrix[i][j]);
					
					if(j==matrix[i].length-1) {
						sb.append(CORCHETE_CIERRE);
					}else {
						sb.append(SEPARADOR);
					}
				}
				sb.append(SALTO_DE_LINEA);
			}
		}
	
		return sb.toString();
	}


	public static String printMatrix(char[] vector) {
		return printMatrix(new char[][] {vector});
		
	}
}
