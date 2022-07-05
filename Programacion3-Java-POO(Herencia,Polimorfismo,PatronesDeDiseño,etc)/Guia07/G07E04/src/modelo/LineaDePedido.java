package modelo;

public class LineaDePedido implements Comparable{
	private int cantidad;
	private Producto producto;
	
	public LineaDePedido() {
		super();
	}
	public LineaDePedido(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		return this.compareTo(o);
	}
	
	public boolean equals(Object object) {
		return this.equals(object);
	}
	
	public int HashCode() {
		return cantidad;
	}
	
	@Override
	public String toString() {
		return "LineaDePedido [cantidad=" + cantidad + ", producto=" + producto + "]";
	}
	
	
}
