package prueba;

import modelo.Empresa;
import modelo.LineaDePedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.Proveedor;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proveedor proveedor1 = new Proveedor();
		Producto producto1 = new Producto();
		Pedido pedido1 = new Pedido();
		Empresa empresa = new Empresa();
		LineaDePedido linea1 =  new LineaDePedido();
		
		proveedor1.setNombre("Pepe");
		empresa.agregarProveedor(proveedor1);
		proveedor1 = new Proveedor();
		proveedor1.setNombre("Cacho");
		empresa.agregarProveedor(proveedor1);
		proveedor1 = new Proveedor();
		proveedor1.setNombre("Carlo");
		empresa.agregarProveedor(proveedor1);
		
		producto1.setDescripcion("galletitas");
		empresa.agregarProducto(producto1);
		producto1 = new Producto();
		producto1.setDescripcion("queso");
		empresa.agregarProducto(producto1);
		producto1 = new Producto();
		producto1.setDescripcion("leche");
		empresa.agregarProducto(producto1);
		
		for(int i = 0; i < empresa.cantidadProveedores(); i++)
			System.out.println(empresa.proveedores.get(i).getNombre());
		for(int i = 0; i < empresa.cantidadProductos(); i++)
			System.out.println(empresa.productos.get(i).getDescripcion());
		
		
		linea1.setProducto(empresa.productos.get(0));
		linea1.setCantidad(2);
		pedido1.agregarLineaDePedido(linea1);
		linea1 = new LineaDePedido();
		linea1.setProducto(empresa.productos.get(2));
		linea1.setCantidad(2);
		pedido1.agregarLineaDePedido(linea1);
		
		pedido1.setProveedor(empresa.proveedores.get(0));
		
		empresa.agregarPedido(pedido1);
		for(int i = 0; i < empresa.cantidadProductos(); i++)
			System.out.println(empresa.productos.get(i).getDescripcion());
		
	}

}
