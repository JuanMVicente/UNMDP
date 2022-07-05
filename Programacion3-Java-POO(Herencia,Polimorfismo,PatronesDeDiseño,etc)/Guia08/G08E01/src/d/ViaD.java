package d;

import Interface.IVia;
import a.Tren;

public class ViaD implements IVia
{
    private String direccionActual;
    private int cantEsperaDer, cantEsperaIzq, cantEnVia;
    public static final String derecha   = "DERECHA"; 
    public static final String izquierda = "IZQUIERDA"; 
    
    public ViaD()
    {
        this.direccionActual = null;
        this.cantEnVia = 0;
        this.cantEsperaDer = 0;
        this.cantEsperaIzq = 0;
    }

    @Override
    public synchronized void entrar(Tren tren)
    {        
        boolean hayTrenesContra;
        
        if (tren.getDireccion().equalsIgnoreCase(ViaD.derecha))
            this.cantEsperaDer++;
        else
            this.cantEsperaIzq++;
        hayTrenesContra = (tren.getDireccion().equalsIgnoreCase(ViaD.derecha) && (this.cantEsperaIzq > 0)) 
                          || ((tren.getDireccion().equalsIgnoreCase(ViaD.izquierda) && (this.cantEsperaDer > 0)));   
        while (((this.cantEnVia != 0) && ! (tren.getDireccion().equalsIgnoreCase(this.direccionActual))) 
        || (tren.getDireccion().equalsIgnoreCase(this.direccionActual) && hayTrenesContra && (this.cantEnVia == 0))) 
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
            hayTrenesContra = (tren.getDireccion().equalsIgnoreCase(ViaD.derecha) && (this.cantEsperaIzq > 0)) 
                              || ((tren.getDireccion().equalsIgnoreCase(ViaD.izquierda) && (this.cantEsperaDer > 0)));
        }
        this.cantEnVia++;
        this.direccionActual = tren.getDireccion();
        System.out.println(tren.getNombre() + " entró a la via, hacia la " + this.direccionActual);
        if (tren.getDireccion().equalsIgnoreCase(ViaD.derecha))
            this.cantEsperaDer--;
        else
            this.cantEsperaIzq--;
    }

    @Override
    public synchronized void salir(Tren tren)
    {
        System.out.println(tren.getNombre() + " salió de la via, en direccion " + this.direccionActual);
        this.cantEnVia--;
        notifyAll();
    }
}