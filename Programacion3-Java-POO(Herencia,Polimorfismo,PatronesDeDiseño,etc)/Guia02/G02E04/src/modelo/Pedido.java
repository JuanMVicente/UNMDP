package modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Pedido {
	private Proveedor proveedor;
	private Calendar fecha;
	private ArrayList<LineaDePedido> lineasPedido = new ArrayList<LineaDePedido>();
		
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public ArrayList<LineaDePedido> getPedidos() {
		return lineasPedido;
	}
	public void setPedidos(ArrayList<LineaDePedido> pedidos) {
		this.lineasPedido = pedidos;
	}
	public void agregarLineaDePedido(LineaDePedido LineaDePedido) {
		this.lineasPedido.add(LineaDePedido);
	}
	
	public int cantidadLineas() {
		return lineasPedido.size();
	}
}
