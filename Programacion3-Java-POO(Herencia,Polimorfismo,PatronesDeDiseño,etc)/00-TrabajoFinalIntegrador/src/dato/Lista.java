package dato;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * @author Grupo 9
 * Clase que contiene el objeto lista que servira para almacenar los resultados de la ronda de encuentros con todos sus tipos de datos.
 */
public class Lista {

	private LocalDateTime fecha;
	private ArrayList<StructListadoResultado> arrayResultadosRondaEncuentros = new ArrayList<StructListadoResultado>();

	public Lista() {
		super();
		this.fecha = LocalDateTime.now();
	}
	
	public LocalDateTime getFecha() 
	{
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<StructListadoResultado> getArrayResultadosRondaEncuentros() 
	{
		return arrayResultadosRondaEncuentros;
	}
	/**
	 * Funcion que ordena el arreglo que contiene un struct con con los usuarios y los puntajes con dichos usuarios, los coloca en en la lista y establece la hora exacta de la colocacion.
	 * @param arreglo contiene la referencia a un usuario y el puntaje con dicho usuario pero se encuentra desordenada con respecto al puntaje.
	 */	
	public void setArrayResultadosRondaEncuentros(ArrayList<StructListadoResultado> arreglo) 
	{
		
		
		Collections.sort(arreglo, new Comparator<StructListadoResultado>()
		{
			@SuppressWarnings("removal")
			@Override
			public int compare(StructListadoResultado res1, StructListadoResultado res2) 
			{
				return new Double(res2.getPuntuacion()).compareTo(res1.getPuntuacion());
			}
		});
		this.arrayResultadosRondaEncuentros = arreglo;
		this.fecha = LocalDateTime.now();
	}


	@Override
	public String toString() {
		return "Lista [fecha=" + fecha + ", arrayResultadosRondaEncuentros=" + arrayResultadosRondaEncuentros + "]";
	}
	
	
}
