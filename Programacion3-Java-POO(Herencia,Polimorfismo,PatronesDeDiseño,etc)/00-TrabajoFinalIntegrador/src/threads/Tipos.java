package threads;


import dato.TiposRubro;
import negocio.Ilocacion;
import negocio.locacionHomeOffice;
import negocio.locacionIndistinto;
import negocio.locacionPresencial;

public abstract class Tipos {
	
	
	private static String [] rubro = {TiposRubro.salud, TiposRubro.comercioLocal, TiposRubro.comercioInternacional};

	public static String tipoPuesto(int i){
		return rubro[i];
	}
	
} 
