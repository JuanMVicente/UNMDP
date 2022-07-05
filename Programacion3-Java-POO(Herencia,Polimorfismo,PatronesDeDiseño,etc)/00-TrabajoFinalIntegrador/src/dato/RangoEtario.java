package dato;

public class RangoEtario {
	
	private static double [][] rangoEtario = {{1,-0.5,-1},{-0.5,1,-0.5},{-1,-0.5,1}};
	
	public static double enfrentar(int rangoEtarioPropuesta, int rangoEtarioPretendida) {
		return rangoEtario[rangoEtarioPropuesta][rangoEtarioPretendida];						
	}

}