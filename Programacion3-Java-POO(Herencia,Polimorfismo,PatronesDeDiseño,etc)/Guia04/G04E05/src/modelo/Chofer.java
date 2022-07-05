package modelo;

public class Chofer {
	private String nombre;
	private Categoria categoria;
	private Vehiculo vehiculoAsignado;
	
	public Chofer(String nombre, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Vehiculo getVehiculoAsignado() {
		return vehiculoAsignado;
	}

	public void setVehiculo(ColectivoLinea v) {
		if(this.categoria.isHabilitaColectivoLinea())
			this.vehiculoAsignado = v;
	}
	
	public void setVehiculo(ColectivoLarga v) {
		if(this.categoria.isHabilitaColectivoLarga())
			this.vehiculoAsignado = v;
	}
	
	public void setVehiculo(Camion v) {
	if(this.categoria.isHabilitaCamion())
		this.vehiculoAsignado = v;
	}
	
	public void setVehiculo() {
		this.vehiculoAsignado = null;
	}
}
