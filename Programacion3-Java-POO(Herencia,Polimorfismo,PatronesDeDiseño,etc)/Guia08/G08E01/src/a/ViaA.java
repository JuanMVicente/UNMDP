package a;

import Interface.IVia;

public class ViaA implements IVia
{
    private boolean ocupado;
  
    public ViaA() {
		super();
		this.ocupado = false;
	}

	@Override
    public synchronized void entrar(Tren tren)
    {
        while (this.ocupado)
        {
            try
            {
                System.out.println(tren.getNombre() + " esta esperando a que la v�a se libere.");
                wait();
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.ocupado = true;
        System.out.println(tren.getNombre() + " entr� a la via");
    }

    @Override
    public synchronized void salir(Tren tren)
    {
        System.out.println(tren.getNombre() + " sali� de la via");
        this.ocupado = false;
        notifyAll();
    }
}