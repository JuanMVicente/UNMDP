package modelo;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Cuidador implements Observer
{
    private HashMap<String, Mascota> mascotas;
    
    public Cuidador()
    {
        this.mascotas = new HashMap<String, Mascota>();
    }
    
    public void agregarMascota(Mascota mascota) //ESTA BN AGREGAR OBSERVABLES X ACA, XQ PUEDE SER MAS DE 1 ??
    {
        if ( ! this.mascotas.containsKey(mascota.getNombre()))
        {
            this.mascotas.put(mascota.getNombre(), mascota);
            mascota.addObserver(this);
        }
    }

    @Override
    public void update(Observable obj, Object estado)
    {
        if (this.mascotas.containsValue(obj))  
            System.out.println((String) estado);
        else
            throw new IllegalArgumentException();
    }
}

