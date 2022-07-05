package modelo;

public class Producto {
	
	private String descripcion;
	private int codigo;
	private double precioUnitario;
	
	public Producto() {
		super();
	};
	public Producto(String descripcion, int codigo, double precioUnitario) {
		super();
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.precioUnitario = precioUnitario;
	}
	
	public boolean equals(Object object) {
		return this.equals(object);
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", codigo=" + codigo + ", precioUnitario=" + precioUnitario
				+ "]";
	}
	
	public int HashCode() {
		return codigo;	
	}
	
	
	
}
