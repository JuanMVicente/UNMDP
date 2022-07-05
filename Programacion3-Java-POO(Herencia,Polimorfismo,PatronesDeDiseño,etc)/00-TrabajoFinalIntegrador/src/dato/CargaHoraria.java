package dato;

public class CargaHoraria {
	
	private static double [][] cargaHoraria = {{1,-0.5,-1},{-0.5,1,-0.5},{-1,-0.5,1}};
	
	public static double enfrentar(int cargaHorariaPropuesta, int cargaHorariaPretendida) {
		return cargaHoraria[cargaHorariaPropuesta][cargaHorariaPretendida];						
	}

}