package prueba;

import java.io.IOException;

import modelo.Llamado;
import modelo.OperadoraEmergencias;
import modelo.Socio;

import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;

public class Prueba
{
    public static void main(String[] args)
    {
        OperadoraEmergencias lista = new OperadoraEmergencias();                                               
        int i;
        IPersistencia persistencia = new PersistenciaBinaria();
        
        /* CREO SOCIOS */
        Socio socio1 = new Socio("Marito", "Baracus", 1234);
        Socio socio2 = new Socio("El", "Bananero", 5678);
        Socio socio3 = new Socio("ASD", "ASD", 8888);
        
        lista.nuevoSocio(socio1);
        lista.nuevoSocio(socio2);
        lista.nuevoSocio(socio3);
        
        /* CREO Y AGREGO LLAMADOS */
        lista.agrega(new Llamado(9, socio1));
        for(i = 0; i < 100000000; i++);
        lista.agrega(new Llamado(10, socio2));
        for(i = 0; i < 100000000; i++);
        lista.agrega(new Llamado(3, socio3));
        for(i = 0; i < 100000000; i++);
        lista.agrega(new Llamado(5, socio2));
        for(i = 0; i < 100000000; i++);
        lista.agrega(new Llamado(3, socio1));
        for(i = 0; i < 1500000000; i++);
        lista.agrega(new Llamado(7, socio1));
        
        /* ATIENDO ALGUNOS LLAMADOS */
        
        for (i = 0; i < 6; i++)
        {
            System.out.println("----------------------");
            System.out.println(lista.getElemento());
            System.out.println("----------------------");
        }
        
        /* PERSISTO DATOS */
        try
        {
            persistencia.abrirOutput("Operadora.bin");
            persistencia.escribir(lista);
        } 
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}