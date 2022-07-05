package prueba;

import java.io.IOException;

import java.util.Iterator;

import modelo.Llamado;
import modelo.OperadoraEmergencias;

import modelo.Socio;

import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;

public class PruebaLectura
{
    public static void main(String[] args)
    {
        OperadoraEmergencias lista = null;
        IPersistencia persistencia = new PersistenciaBinaria();
        Llamado aux;

        try
        {
            persistencia.abrirInput("Operadora.bin");
            lista = (OperadoraEmergencias) persistencia.leer();
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
        Iterator<Socio> socios = lista.listarSocios();
        Iterator<Llamado> llamados = lista.listarLlamadosSinAtender();
        
        System.out.println("SOCIOS");
        while (socios.hasNext())
            System.out.println(socios.next());
        System.out.println("\nLLAMADOS SIN ATENDER\n");
        System.out.println("CANTIDAD: " + lista.getCantidad());
        while (llamados.hasNext())
            System.out.println(llamados.next());
        
        llamados = lista.getLlamadosAtendidos();
        System.out.println("\nLLAMADOS ATENDIDOS\n");
        while (llamados.hasNext())
            System.out.println(llamados.next());
        
        System.out.println("El mas jugado actualmente es:\n" + lista.consultaElemento());
        
        /* ATIENDO AL RESTO */
        aux = lista.getElemento();
        while (aux != null)
        {
            System.out.println("----------------------");
            System.out.println(aux);
            System.out.println("----------------------");
            aux = lista.getElemento();
        } 
        System.out.println("Atenciones Pendientes: " + lista.getCantidad());
        System.out.println("Socio que mas jode: " + lista.getSocioMasEmergencias());
    }
}

