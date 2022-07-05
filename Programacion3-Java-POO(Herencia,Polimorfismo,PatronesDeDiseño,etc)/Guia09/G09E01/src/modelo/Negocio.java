package modelo;

import excepciones.OperacionConjuntosException;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Negocio implements Serializable
{
    private TreeSet<Proveedor> proveedores;
    private TreeSet<Producto> productos;
    private ArrayList<Pedido> entregados, noEntregados;
    
    public Negocio()
    {
        super();
        this.proveedores = new TreeSet<Proveedor>();
        this.productos = new TreeSet<Producto>();
        this.noEntregados = new ArrayList<Pedido>();
        this.entregados = new ArrayList<Pedido>();
    }
    
    public void agregarProveedor(Proveedor proveedor)
    {
        this.proveedores.add(proveedor);
    }
    
    public void eliminarProveedor(Proveedor proveedor)
    {
        this.proveedores.remove(proveedor);
    }    
    
    public void agregarProducto(Producto producto)
    {
        this.productos.add(producto);
    }
    
    public void eliminarProducto(Producto producto)
    {
        this.productos.remove(producto);
    }
    
    public void agregarPedido(Pedido pedido)
    {
        this.noEntregados.add(pedido);
    }
    
    public void eliminarPedido(Pedido pedido)
    {
        this.noEntregados.remove(pedido);
    }
    
    public void agregarLineaDePedido(Pedido pedido, LineaDePedido linea) throws OperacionConjuntosException
    {
        pedido.agrega(linea);
    }
    
    public void eliminarLineaDePedido(Pedido pedido, LineaDePedido linea) throws OperacionConjuntosException
    {
        pedido.elimina(linea);
    }
    
    public void recibePedido(Pedido pedido)
    {
        if (! pedido.isEntregado())
        {
            pedido.entregar();
            this.noEntregados.remove(pedido);
            this.entregados.add(pedido);
        }
    }
    
    public Iterator<Proveedor> listarProveedores()
    {
        return this.proveedores.iterator();
    }
    
    public Iterator<Producto> listarProductos()
    {
        return this.productos.iterator();         
    }
    
    public Iterator<Pedido> listarPedidosEntregados()
    {   
        return this.entregados.iterator();
    }
    
    public Iterator<Pedido> listarPedidosNoEntregados()
    {   
        return this.noEntregados.iterator();
    }
    
    public Iterator<Proveedor> listarProveedoresPendientes()
    {
        Iterator<Pedido> iter = this.noEntregados.iterator();
        TreeSet<Proveedor> pendientes = new TreeSet<Proveedor>();
        Pedido aux;
        
        while (iter.hasNext())
        {
            aux = iter.next();
            if (! aux.isEntregado())
                pendientes.add(aux.getProveedor());
        }
        
        return pendientes.iterator();
    }
    
    public String detallePedido(Pedido pedido)
    {
        return pedido.detalle();
    }
    
    public double totalPedido(Pedido pedido)
    {
        return pedido.totalPedido();
    }

    public void setProveedores(TreeSet<Proveedor> proveedores)
    {
        this.proveedores = proveedores;
    }

    public TreeSet<Proveedor> getProveedores()
    {
        return proveedores;
    }

    public void setProductos(TreeSet<Producto> productos)
    {
        this.productos = productos;
    }

    public TreeSet<Producto> getProductos()
    {
        return productos;
    }

    public void setEntregados(ArrayList<Pedido> entregados)
    {
        this.entregados = entregados;
    }

    public ArrayList<Pedido> getEntregados()
    {
        return entregados;
    }

    public void setNoEntregados(ArrayList<Pedido> noEntregados)
    {
        this.noEntregados = noEntregados;
    }

    public ArrayList<Pedido> getNoEntregados()
    {
        return noEntregados;
    }
}
