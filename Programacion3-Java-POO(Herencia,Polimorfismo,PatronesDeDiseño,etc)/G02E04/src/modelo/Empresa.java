package modelo;

import java.util.ArrayList;

public class Empresa {
	public ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	public ArrayList<Producto> productos = new ArrayList<Producto>();
	public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public void agregarProveedor(Proveedor proveedor) {
			this.proveedores.add(proveedor);
	}
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	public int cantidadProductos() {
		return productos.size();
	}
	public int cantidadProveedores() {
		return proveedores.size();
	}
	public int cantidadPedido() {
		return pedidos.size();
	}
}
