package presentacion;

import controladores.ControladorSimulacion;
import dato.TiposDatosTicktets;
import threads.BolsaDeTrabajo;
import threads.EmpleadoPretensoThreads;
import threads.EmpleadorThreads;
import threads.Tipos;
import threads.Util;

public class PruebaThreads {

	public static void PruebaConcurrencia(){
		// TODO Auto-generated method stub
		
		
		TiposDatosTicktets.armarListasDatos();
		
		
		
		EmpleadorThreads e1 = new EmpleadorThreads("Lopez");
		EmpleadorThreads e2 = new EmpleadorThreads("Perez");
		EmpleadorThreads e3 = new EmpleadorThreads("Garcia");
		EmpleadorThreads e4 = new EmpleadorThreads("Fernandez");
		EmpleadorThreads e5 = new EmpleadorThreads("Montoya");
		EmpleadorThreads e6 = new EmpleadorThreads("Chilavert");
		EmpleadorThreads e7 = new EmpleadorThreads("Goicochea");
		
		EmpleadoPretensoThreads ep1 = new EmpleadoPretensoThreads("Jose");
		EmpleadoPretensoThreads ep2 = new EmpleadoPretensoThreads("Luis");
		EmpleadoPretensoThreads ep3 = new EmpleadoPretensoThreads("Ana");
		EmpleadoPretensoThreads ep4 = new EmpleadoPretensoThreads("Pedro");
		EmpleadoPretensoThreads ep5 = new EmpleadoPretensoThreads("Maria");
		EmpleadoPretensoThreads ep6 = new EmpleadoPretensoThreads("Analia");
		EmpleadoPretensoThreads ep7 = new EmpleadoPretensoThreads("Emilio");
		EmpleadoPretensoThreads ep8 = new EmpleadoPretensoThreads("Anabella");
		EmpleadoPretensoThreads ep9 = new EmpleadoPretensoThreads("Miguel");
		EmpleadoPretensoThreads ep10 = new EmpleadoPretensoThreads("Jorge");
		
		
	
		
		
		/*for(int i=0; i<20;i++)
			System.out.println(Util.random());*/
		
		e1.start();
		e2.start();
		e3.start();
		e4.start();
		e5.start();
		e6.start();
		e7.start();
		
		ep1.start();
		ep2.start();
		ep3.start();
		ep4.start();
		ep5.start();
		ep6.start();
		ep7.start();
		ep8.start();
		ep9.start();
		ep10.start();
		

	}

}
