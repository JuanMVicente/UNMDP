package dato;

public class ExperienciaPrevia {
	private static double [][] experienciaPrevia = {{1,-0.5,-1},{-0.5,1,-0.5},{-1,-0.5,1}};
	
	public static double enfrentar(int experienciaPreviaBuscada, int experienciaPreviaEmpleadoP) {
		return experienciaPrevia[experienciaPreviaBuscada][experienciaPreviaEmpleadoP];						
	}

}
