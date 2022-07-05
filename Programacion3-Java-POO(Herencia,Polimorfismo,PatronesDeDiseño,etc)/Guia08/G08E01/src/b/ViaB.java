package b;

import Interface.IVia;
import a.Tren;

public class ViaB implements IVia
{
    private String direccionActual;
    private boolean ocupado;
    private int cantEsperaDer, cantEsperaIzq;
    public static final String derecha   = "DERECHA"; 
    public static final String izquierda = "IZQUIERDA"; 
    
    public ViaB()
    {
        this.direccionActual = null;
        this.ocupado = false;
        this.cantEsperaDer = 0;
        this.cantEsperaIzq = 0;
    }

    @Override
    public synchronized void entrar(Tren tren)
    {        
        boolean hayTrenesContra;
        
        if (tren.getDireccion().equalsIgnoreCase(ViaB.derecha))
            this.cantEsperaDer++;
        else
            this.cantEsperaIzq++;
        hayTrenesContra = (tren.getDireccion().equalsIgnoreCase(ViaB.derecha) && (this.cantEsperaIzq > 0)) 
                          || ((tren.getDireccion().equalsIgnoreCase(ViaB.izquierda) && (this.cantEsperaDer > 0)));   
        while (this.ocupado || (tren.getDireccion().equalsIgnoreCase(this.direccionActual) && hayTrenesContra)) 
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
            hayTrenesContra = (tren.getDireccion().equalsIgnoreCase(ViaB.derecha) && (this.cantEsperaIzq > 0)) 
                              || ((tren.getDireccion().equalsIgnoreCase(ViaB.izquierda) && (this.cantEsperaDer > 0)));
        }
        this.ocupado = true;
        this.direccionActual = tren.getDireccion();
        System.out.println(tren.getNombre() + " entró a la via, hacia la " + this.direccionActual);
        if (tren.getDireccion().equalsIgnoreCase(ViaB.derecha))
            this.cantEsperaDer--;
        else
            this.cantEsperaIzq--;
    }

    @Override
    public synchronized void salir(Tren tren)
    {
        System.out.println(tren.getNombre() + " salió de la via, en direccion " + this.direccionActual);
        this.ocupado = false;
        notifyAll();
    }
}