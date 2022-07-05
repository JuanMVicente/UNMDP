package prueba;

import excepciones.OperacionConjuntosException;

import java.io.IOException;

import modelo.LineaDePedido;
import modelo.Negocio;
import modelo.Pedido;
import modelo.Producto;
import modelo.Proveedor;

import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.PersistenciaXML;


public class Prueba
{
    public static void main(String[] args)
    {
        Negocio negocio = new Negocio();
        Proveedor p1, p2, p3;
        Producto pd1, pd2, pd3;
        Pedido pedido;
        LineaDePedido lp1, lp2, lp3;
        IPersistencia persistencia = new PersistenciaBinaria();
        //IPersistencia persistencia = new PersistenciaXML();
        
        /* CREO PROVEEDORES */
        p1 = new Proveedor("aaa@aa", "AAA", "1111");
        p2 = new Proveedor("bbb@bb", "BBB", "2222");
        p3 = new Proveedor("ccc@cc", "CCC", "3333");
        
        negocio.agregarProveedor(p1);
        negocio.agregarProveedor(p2);
        negocio.agregarProveedor(p3);
        
        /* CREO PRODUCTOS */
        pd1 = new Producto(1234, "Coca-Cola", 100);
        pd2 = new Producto(5678, "Terrabusi", 50);
        pd3 = new Producto(9101, "Bay Biscuit", 200);
        
        negocio.agregarProducto(pd1);
        negocio.agregarProducto(pd2);
        negocio.agregarProducto(pd3);
        
        /* ARMO LINEAS DE PEDIDO */        
        lp1 = new LineaDePedido(10, pd1);
        lp2 = new LineaDePedido( 2, pd2);
        lp3 = new LineaDePedido(20, pd3);
        
        /* ARMO PEDIDO 1 */
        pedido = new Pedido(p1);
        negocio.agregarPedido(pedido);
        try
        {
            negocio.agregarLineaDePedido(pedido, lp1);
            negocio.agregarLineaDePedido(pedido, lp2);
            negocio.agregarLineaDePedido(pedido, lp3);
            //negocio.eliminarLineaDePedido(pedido, lp1);
        } 
        catch (OperacionConjuntosException e)
        {
            System.out.println(e.getMessage() + " Elemento: " + e.getElemento());
        }
        negocio.recibePedido(pedido);
        System.out.println("PEDIDO 1");
        System.out.println(negocio.detallePedido(pedido));
        System.out.println("TOTAL:" + negocio.totalPedido(pedido));
        
        /* ARMO PEDIDO 2 */
        Pedido pedido2 =  new Pedido(p3);
        negocio.agregarPedido(pedido2);
        try
        {
            negocio.agregarLineaDePedido(pedido2, lp1);
            negocio.agregarLineaDePedido(pedido2, lp3);
            negocio.agregarLineaDePedido(pedido2, lp3);
        } 
        catch (OperacionConjuntosException e)
        {
            System.out.println(e.getMessage() + " Elemento: " + e.getElemento());
        }
        System.out.println("PEDIDO 2");
        System.out.println(negocio.detallePedido(pedido2));
        
        /* ARMO PEDIDO 3 */
        Pedido pedido3 =  new Pedido(p2);
        negocio.agregarPedido(pedido3);
        try
        {
            negocio.agregarLineaDePedido(pedido3, lp2);
            negocio.agregarLineaDePedido(pedido3, lp3);
            negocio.eliminarLineaDePedido(pedido3, lp1);
        } 
        catch (OperacionConjuntosException e)
        {
            System.out.println(e.getMessage() + " Elemento: " + e.getElemento());
        }
        System.out.println("PEDIDO 3");
        System.out.println(negocio.detallePedido(pedido3));
        
        /* PERSISTO DATOS */
        try
        {
            persistencia.abrirOutput("Negocio.bin");
            persistencia.escribir(negocio);
            persistencia.cerrarOutput();
        } 
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
