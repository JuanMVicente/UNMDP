package dato;
import java.util.HashMap;

import negocio.Ilocacion;
import negocio.locacionHomeOffice;
import negocio.locacionIndistinto;
import negocio.locacionPresencial;

public class TiposDatosTicktets {
	
																	
	private static HashMap<Integer,Ilocacion> locacion = new HashMap<Integer,Ilocacion>();
	private static HashMap<Integer,Double> remuneracion = new HashMap<Integer,Double>();
	private static HashMap<Integer,String> tipoPuesto = new HashMap<Integer,String>();
	private static HashMap<Integer,String> cargaHoraria = new HashMap<Integer,String>();
	private static HashMap<Integer,Integer> rangoEtario = new HashMap<Integer,Integer>();
	private static HashMap<Integer,String> experiencia = new HashMap<Integer,String>();
	private static HashMap<Integer,String> estudios = new HashMap<Integer,String>();
	
	public static void armarListasDatos() {
		locacion.put(0 , new locacionHomeOffice());
		locacion.put(1 , new locacionPresencial());
		locacion.put(2 , new locacionIndistinto());
		remuneracion.put(0,  40000.0);
		remuneracion.put(1,  80000.0);
		remuneracion.put(2,  120000.0);
		tipoPuesto.put(0, "junior");
		tipoPuesto.put(1, "senior");
		tipoPuesto.put(2, "managment");
		rangoEtario.put(0, 20);
		rangoEtario.put(1, 45);
		rangoEtario.put(2, 60);
		experiencia.put(0, "nada");
		experiencia.put(1, "media");
		experiencia.put(2, "mucha");
		estudios.put(0, "primario");
		estudios.put(1, "secundario");
		estudios.put(2, "terciario");
		cargaHoraria.put(0, "media");
		cargaHoraria.put(1, "completa");
		cargaHoraria.put(2, "extendida");
		
	}
	
	
	public static HashMap<Integer, Ilocacion> getLocacion() {
		return locacion;
	}

	public static HashMap<Integer, Double> getRemuneracion() {
		return remuneracion;
	}
	public static HashMap<Integer, String> getTipoPuesto() {
		
		return tipoPuesto;
	}
	public static HashMap<Integer, Integer> getRangoEtario() {
	
		
		return rangoEtario;
	}
	public static HashMap<Integer, String> getExperiencia() {
		
		
		return experiencia;
	}
	public static HashMap<Integer, String> getEstudios() {
		
		
		return estudios;
	}
	public static HashMap<Integer,String> getCargaHoraria() {
		
		
		return cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "TiposDatosTicktets [locacion=" + locacion + ", remuneracion=" + remuneracion + ", tipoPuesto="
				+ tipoPuesto + ", cargaHoraria=" + cargaHoraria + ", rangoEtario=" + rangoEtario + ", experiencia="
				+ experiencia + ", estudios=" + estudios + "]";
	}
	
	
} 