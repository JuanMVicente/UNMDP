package modelo;

import java.util.ArrayList;

public class Estacion {
    private String nombre;
    private ArrayList<Surtidor> surtidores = new ArrayList<Surtidor>();
    
    
    public void agregarSurtidor (Surtidor surtidor)
    {
        this.surtidores.add(surtidor);
    }
    
    public int cantidadSurtidores(){
        return this.surtidores.size();
    }
    
    public int cantidadGasoil(){
        int aux=0;
        for(int i=0; i<surtidores.size();i++)
            aux += surtidores[i].getCantGasoil();
        return aux;
    }
    
    
    
}
