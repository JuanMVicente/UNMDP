package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class OperadoraEmergencias extends ListaConPrioridades<Llamado>
{
    private ArrayList<Socio> socios = new ArrayList<Socio>();
    private ArrayList<Llamado> llamadosAtendidos = new ArrayList<Llamado>();
    private HashMap<Integer, Integer> llamadosSocios = new HashMap<Integer, Integer>();
    
    public OperadoraEmergencias()
    {
        super();
    }
    
    public void nuevoSocio(Socio socio)
    {
        if (! this.socios.contains(socio))
        {
            this.socios.add(socio);
            this.llamadosSocios.put(socio.getDni(), 0);
        }
    }
    
    public void eliminarSocio(Socio socio)
    {
        this.socios.remove(socio);
        this.llamadosSocios.remove(socio.getDni());
    }
    
    public int cantidadLlamados(Socio socio)
    {
        int cant = 0;
        
        if (this.llamadosSocios.containsKey(socio.getDni()))
            cant = this.llamadosSocios.get(socio.getDni());
        
        return cant;
    }

    public Iterator<Llamado> getLlamadosAtendidos()
    {
        return this.llamadosAtendidos.iterator();
    }

    public Socio getSocioMasEmergencias()
    {
        Socio socioMax = null, aux;
        int cantMax = -99, cant;
        Iterator<Socio> iter = this.socios.iterator();
        
        while (iter.hasNext())
        {
            aux = iter.next();
            cant = this.cantidadLlamados(aux);
            if (cant > cantMax)
            {
                cantMax = cant;
                socioMax = aux;
            }
        }
        
        return socioMax;
    }

    @Override
    public Llamado getElemento()
    {
        Llamado aux = super.getElemento();
        int cant;
        
        if (aux != null)
        {
            aux.setFechaHoraAtendido(new GregorianCalendar());
            this.llamadosAtendidos.add(aux);
            cant = this.llamadosSocios.get(aux.getSocio().getDni());
            cant++;
            this.llamadosSocios.put(aux.getSocio().getDni(), cant);
        }
        
        return aux;
    }
    
    public Iterator<Socio> listarSocios()
    {
        return this.socios.iterator();
    }
    
    public Iterator<Llamado> listarLlamadosSinAtender()
    {
        TreeSet<Llamado> tset = new TreeSet<Llamado>();
        Iterator<Llamado> iter = this.getIterator();
        
        while(iter.hasNext())
            tset.add(iter.next());        
        
        return tset.iterator();
    }
}
