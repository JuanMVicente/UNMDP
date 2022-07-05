package dato;

public class EstudiosCursados {
	private static double [][] estudiosCursados = {{1,1.5,2},{-0.5,1,1.5},{-2,-1.5,1}};
	
	public static double enfrentar(int estudiosCursadosBuscada, int estudiosCursadosEmpleadoP) {
		return estudiosCursados[estudiosCursadosBuscada][estudiosCursadosEmpleadoP];						
	}
}
