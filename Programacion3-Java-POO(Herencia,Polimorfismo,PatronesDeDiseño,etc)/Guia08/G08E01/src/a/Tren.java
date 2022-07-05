package a;

import util.Util;

import Interface.IVia;

public class Tren extends Thread
{
    private String nombre, direccion;
    private IVia via;

    public Tren(String nombre, String direccion, IVia via)
    {
        super();
        this.nombre = nombre;
        this.direccion = direccion;
        this.via = via;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }
    
    @Override
    public void run()
    {
        int i;

        for (i = 1; i <= 3; i++)
        {
            Util.espera(); /* PARA SIMULAR CUANTO TARDA HASTA LLEGAR AL TRAMO */
            this.via.entrar(this);
            Util.espera(); /* SIMULA CUANTO TARDA CIRUCLANDO POR LA VIA */
            this.via.salir(this);
        }
    }
}

