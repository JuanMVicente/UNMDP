package controladores;

import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.Usuario;
import threads.BolsaDeTrabajo;

public  class Controladorbase  {

	private static ControladorFuncionesEmpleadoP c = null;
	private static ControladorFuncionesEmpleador d = null;
	private static ControladorVistaAdmin a = null;
	//private static HashMap<ControladorFuncionesEmpleadoP, VistaEmpleadoP> controladoresEmpleados = new HashMap<ControladorFuncionesEmpleadoP, VistaEmpleadoP> ();
	//private static HashMap<ControladorFuncionesEmpleador, VistaEmpleador> controladoresEmpleadores = new HashMap<ControladorFuncionesEmpleador, VistaEmpleador>();
	
	public static void Ventanamain() {

		ControladorMain c = new ControladorMain();
	}
	
	public static void VentanaSimulacion() {
		ControladorSimulacion c = new ControladorSimulacion();
		BolsaDeTrabajo bolsa = BolsaDeTrabajo.getInstance();
		c.agregarObservable(bolsa);
	}

	public static void ventanaregistroempleado() {
		ControladorRegistroEmpleado c = new ControladorRegistroEmpleado();
	}

	public static void ventanaregistroempleador() {

		ControladorRegistroEmpleador c = new ControladorRegistroEmpleador();
	}

	public static void ventanregistroadmin() {
		ControladorRegistroAdmin c = new ControladorRegistroAdmin();
	}

	public static void ventanafuncionesempleadop(Usuario u) {
		
		EmpleadoPretenso e = (EmpleadoPretenso) u;
		if(c == null ) {
			c = new ControladorFuncionesEmpleadoP(e);
			c.actualizar();
			//controladoresEmpleados.put(c,ControladorFuncionesEmpleadoP.getVista());
			//c.agregarObservable();
		}
		else {	
			c.setEmpleado(e);
			c.actualizar();
			ControladorFuncionesEmpleadoP.mostrarVista();
		}
	}

	public static void ventanaFuncionesEmpleador(Usuario usuario) 
	{
		Empleador e = (Empleador) usuario;
		if(d == null) { //&& (controladoresEmpleadores==null || controladoresEmpleadores.containsValue(e))) {
			d = new ControladorFuncionesEmpleador(e);
			d.actualizar();
			
			//controladoresEmpleadores.put(d, ControladorFuncionesEmpleador.getVista());
			//d.agregarObservable();
		}
		else {
			d.setEmpleador(e);
			d.actualizar();
			ControladorFuncionesEmpleador.mostrarVista();
		}
	}
	public static void ventanaFuncionesAdministrador() {
		
		if(a == null)
		 a = new ControladorVistaAdmin();
		else {	
		a.mostrarVista();	
		
		}
	}
	 
}