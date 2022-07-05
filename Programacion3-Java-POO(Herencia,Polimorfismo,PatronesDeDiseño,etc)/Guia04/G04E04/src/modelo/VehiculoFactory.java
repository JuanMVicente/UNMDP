package modelo;

public class VehiculoFactory {
	public static Vehiculo getVehiculo(String patente, String tipo, int plaza)
	{
		Vehiculo respuesta = null;
		if (tipo.equals("Auto"))
			respuesta = new Auto(patente, plaza);
		else if (tipo.equals("Combi"))
			respuesta = new Combi(patente, plaza);

		return respuesta;
	}
	public static Vehiculo getVehiculo(String patente, String tipo, double pesoMaximo)
	{
		Vehiculo respuesta = null;
		if (tipo.equals("Camioneta"))
			respuesta = new Camioneta(patente, pesoMaximo);
		return respuesta;
	}
	public static Vehiculo getVehiculo(String patente, String tipo)
	{
		Vehiculo respuesta = null;
		if (tipo.equals("Camion"))
			respuesta = new Camion(patente);
		return respuesta;
	}
}
