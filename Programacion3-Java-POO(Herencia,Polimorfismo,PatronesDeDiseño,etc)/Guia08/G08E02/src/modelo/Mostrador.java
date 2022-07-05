package modelo;

public class Mostrador {
	private boolean turno = true;
	private int num=0;
	
    
	public synchronized void tomaturno(Persona pers){
		
		while (this.turno == false || pers.getNumero() != this.num+1)
		{
			try
			{
				System.out.println("*******"+pers.getNombre()+" quiere que tomen su turno pero debe esperar");
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.num++;
		this.turno = true;
		System.out.println(pers.getNombre() + " entrego su turno , numero " + pers.getNumero());
		notifyAll();
		
	}
}
