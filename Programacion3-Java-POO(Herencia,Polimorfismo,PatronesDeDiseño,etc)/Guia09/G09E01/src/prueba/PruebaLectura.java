package prueba;

import java.io.IOException;

import java.util.Iterator;

import modelo.Negocio;

import modelo.Pedido;
import modelo.Producto;
import modelo.Proveedor;

import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.PersistenciaXML;

public class PruebaLectura
{
    public static void main(String[] args)
    {
        Negocio negocio = null;
        IPersistencia persistencia = new PersistenciaBinaria();
        //IPersistencia persistencia = new PersistenciaXML();
        
        /* RECUPERO DATOS */
        try
        {
            persistencia.abrirInput("Negocio.bin");
            negocio = (Negocio) persistencia.leer();
            persistencia.cerrarInput();
        } 
        catch (IOException e)
        {
            System.out.println(e.getMessage()); 
        } 
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
        /* MUESTRO */
        System.out.println("PROVEEDORES");
        Iterator<Proveedor> proveedores = negocio.listarProveedores();
        while (proveedores.hasNext())
            System.out.println(proveedores.next());
        
        System.out.println("PRODUCTOS");
        Iterator<Producto> productos = negocio.listarProductos();
        while (productos.hasNext())
            System.out.println(productos.next());
        
        System.out.println("PEDIDOS ENTREGADOS");
        Iterator<Pedido> entregados = negocio.listarPedidosEntregados();
        while (entregados.hasNext())
            System.out.println(entregados.next().detalle());
        
        System.out.println("PEDIDOS NO ENTREGADOS");
        Iterator<Pedido> noEntregados = negocio.listarPedidosNoEntregados();
        while (noEntregados.hasNext())
            System.out.println(noEntregados.next().detalle());
        
        System.out.println("PROVEEDORES PENDIENTES");
        proveedores = negocio.listarProveedoresPendientes();
        while (proveedores.hasNext())
            System.out.println(proveedores.next());
        
         //System.out.println("RELACIONES DE AGREGACION");
        //System.out.println(negocio.getPedidos().get(0).getProveedor() == negocio.getPedidos().get(2).getProveedor());  
    }
}
