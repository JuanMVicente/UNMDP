package dato;

public class TipoPuesto {
	
	private static double [][] tipoPuesto = {{1,-0.5,-1},{-0.5,1,-0.5},{-1,-0.5,1}};
	
	public static double enfrentar(int tipoPuestoPropuesta, int tipoPuestoPretendida) {
		return tipoPuesto[tipoPuestoPropuesta][tipoPuestoPretendida];						
	}

}