package modelo;

public class Categoria {
	protected String nombreCategoria;
	protected double sueldo;
	private boolean habilitaColectivoLinea;
	private boolean habilitaColectivoLarga;
	private boolean habilitaCamion;
	
	
	
	public Categoria(String nombreCategoria, double sueldo, boolean habilitaColectivoLinea,
			boolean habilitaColectivoLarga, boolean habilitaCamion) {
		super();
		this.nombreCategoria = nombreCategoria;
		this.sueldo = sueldo;
		this.habilitaColectivoLinea = habilitaColectivoLinea;
		this.habilitaColectivoLarga = habilitaColectivoLarga;
		this.habilitaCamion = habilitaCamion;
	}
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public double getSueldo() {
		return sueldo;
	}
	public boolean isHabilitaColectivoLinea() {
		return habilitaColectivoLinea;
	}
	public boolean isHabilitaColectivoLarga() {
		return habilitaColectivoLarga;
	}
	public boolean isHabilitaCamion() {
		return habilitaCamion;
	}
	
}
