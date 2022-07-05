package dato;

public class Remuneracion {
	private static double [][] remuneracion = {{1,-0.5,-1},{1,1,-0.5},{1,1,1}};
	
	public static double enfrentar(int remuneracionPropuesta, int remuneracionPretendida) {
		return remuneracion[remuneracionPropuesta][remuneracionPretendida];						
	}

}

