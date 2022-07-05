package c;

import Interface.IVia;
import a.Tren;

public class ViaC implements IVia
{
    private String direccionActual;
    private int cantCirculando;
    
    public ViaC()
    {
        this.direccionActual = null;
        this.cantCirculando = 0;
    }

    @Override
    public synchronized void entrar(Tren tren)
    {        
        while ((this.cantCirculando != 0) && (! this.direccionActual.equals(tren.getDireccion())))
        {
            try
            {
                System.out.println(tren.getNombre() + " esta esperando a que la vía se libere, se dirige en direccion " 
                                   + tren.getDireccion());
                wait();
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.direccionActual = tren.getDireccion();
        this.cantCirculando++;
        System.out.println(tren.getNombre() + " entró a la via, hacia la " + this.direccionActual);
    }

    @Override
    public synchronized void salir(Tren tren)
    {
        System.out.println(tren.getNombre() + " salió de la via, en direccion " + this.direccionActual);
        this.cantCirculando--;
        notifyAll();
    }
}
