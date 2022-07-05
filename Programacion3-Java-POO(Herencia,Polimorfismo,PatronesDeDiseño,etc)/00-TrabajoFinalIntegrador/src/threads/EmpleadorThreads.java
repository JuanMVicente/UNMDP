package threads;

import java.util.ArrayList;

public class EmpleadorThreads extends Thread {
	private String nombre;
	private String rubro;
	private BolsaDeTrabajo agencia;
	
	public EmpleadorThreads(String nombre) {
		super();
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.rubro = Tipos.tipoPuesto(Util.random());;
		this.agencia = BolsaDeTrabajo.getInstance();
	}

	public String getNombre() {
		return nombre;
	}

	public String getRubro() {
		return rubro;
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 3; i++)
		{
			Util.esperaExtendida();
			this.agencia.agregaTicket(new TicketSimplificado(Util.random(), this));
			Util.espera();
		}
	}

}



