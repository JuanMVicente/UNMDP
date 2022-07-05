package presentacion;

import exceptions.EstadoTicketException;

public class PruebaPersEscritura {

	public static void main(String[] args) throws EstadoTicketException {

	/*	Sistema sistema = Sistema.getInstance();

		AdministradorAgencia administrador = new AdministradorAgencia("LMessi","Campeones2021","wfdw");
		AdministradorAgencia adm2 = new AdministradorAgencia("Ronaldo_Cr7", "siuuu", "Cristiano");
						
		FuncionesAdministrador funcadmin = new FuncionesAdministrador();
		FuncionesEmpleador funcEmpleador = new FuncionesEmpleador();
		FuncionesEmpleadoPretenso funcEmpleado = new FuncionesEmpleadoPretenso();

													//NombreUsuario - contra - Rubro - RazonSocial
		Empleador empleador1 = new EmpleadorFisico("aguero","12789","CityCorp",TiposRubro.salud);  
		Empleador empleador2 = new EmpleadorJuridico("tevez","456123","ApacheCorp",TiposRubro.comercioLocal);
		Empleador empleador3 = new EmpleadorFisico("pipita","12345","ErroresCorp",TiposRubro.comercioInternacional);
		
														  //NombreUsuario - contra  - NombreEmpleado - telefono - fecha nac - dni 
		EmpleadoPretenso empleado1 = new EmpleadoPretenso("E1","4","fran","223456789",LocalDate.of(2020,2, 8) ,"789456456");
		EmpleadoPretenso empleado2 = new EmpleadoPretenso("E2","5","ion","223456456",LocalDate.of(2020,8, 8) ,"789456456");
		EmpleadoPretenso empleado3 = new EmpleadoPretenso("E3","6","eze","22345233",LocalDate.of(2020,4, 8) ,"789456456");
		EmpleadoPretenso empleado4 = new EmpleadoPretenso("E3","78","messi","223457899",LocalDate.of(2020,4, 8) ,"78945456");
		
		TiposDatosTicktets.armarListasDatos();

		
		//REGISTRO ADMINISTRADOR (Solo toma al primer administrador que se registre. No deja que se registre otro)
		try {
			sistema.registrarAdministrador("Ronaldo_Cr7", "siuuu", "Cristiano");
		} catch (ContraseniaIncorrectaException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		} catch (NombreUsuarioIncorrectoException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		} catch (UsuarioDuplicado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// ============================= REGISTRO EMPLEADOS ===================================
		
			try {
				sistema.registrarEmpleadoPretenso("E1","44444","fran","223456789","0505" ,"789456456");
			} catch (ContraseniaIncorrectaException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			} catch (NombreUsuarioIncorrectoException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			} catch (UsuarioRepetidoException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}
		
			
			try {
				sistema.registrarEmpleadoPretenso("E2","55555","ion","223456456","2001" ,"789456456");
			} catch (ContraseniaIncorrectaException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			} catch (NombreUsuarioIncorrectoException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			} catch (UsuarioRepetidoException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}
		
			
			try {
				sistema.registrarEmpleadoPretenso("E3","6666","eze","22345233","2000","789456456");
			} catch (ContraseniaIncorrectaException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			} catch (NombreUsuarioIncorrectoException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			} catch (UsuarioRepetidoException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}
			
		
		
		
		// ======================== REGISTRO EMPLEADORES ==================================		
			
			try {
				sistema.registrarEmpleador("aguero","12789","FISICA",TiposRubro.salud,"CityCorp");
			} catch (ContraseniaIncorrectaException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			} catch (NombreUsuarioIncorrectoException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			} catch (UsuarioRepetidoException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
		
			try {
				sistema.registrarEmpleador("tevez","456123","JURIDICA",TiposRubro.comercioLocal,"ApacheCorp");
			} catch (ContraseniaIncorrectaException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			} catch (NombreUsuarioIncorrectoException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			} catch (UsuarioRepetidoException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
			
			try {
				sistema.registrarEmpleador("pipita","12345","FISICA",TiposRubro.comercioInternacional,"ErroresCorp");
			} catch (ContraseniaIncorrectaException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			} catch (NombreUsuarioIncorrectoException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			} catch (UsuarioRepetidoException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
		
		

		
		//================== GENERACION TICKETS EMPLEADORES ==========================
		try {
			funcEmpleador.generarTicket(sistema.getEmpleadores().get(0), 5, 1, 1, 1, 2, 1, 1, 0);
		} catch (ObjetoNoEstaEnLaListaException e) {
			e.printStackTrace();
		} catch (ParametroFormularioFactoryException e) {
			e.printStackTrace();
		} catch (ParametroInvalidoException e) {
			e.printStackTrace();
		} 
		
		
		try {
			funcEmpleador.generarTicket(sistema.getEmpleadores().get(1), 4, 0, 0, 0, 0, 0, 0, 0);
		} catch (ObjetoNoEstaEnLaListaException e) {
			e.printStackTrace();
		} catch (ParametroFormularioFactoryException e) {
			e.printStackTrace();
		} catch (ParametroInvalidoException e) {
			e.printStackTrace();
		}
		
		
		//GENERACION TICKETS EMPLEADOS
		
		try {
			funcEmpleado.generarTicket(sistema.getEmpleados().get(0), 0, 2, 2, 2, 2, 2, 2);
		} catch (ObjetoNoEstaEnLaListaException e) {
			e.printStackTrace();
		} catch (ParametroFormularioFactoryException e) {
			e.printStackTrace();
		} 
		
		
		try {
			funcEmpleado.generarTicket(sistema.getEmpleados().get(1), 0, 0, 0, 0, 0, 0, 0);
		} catch (ObjetoNoEstaEnLaListaException e) {
			e.printStackTrace();
		} catch (ParametroFormularioFactoryException e) {
			e.printStackTrace();
		} 
		
		
		
		funcadmin.RondaEncuentrosLaborales();
		
		
		/*	
		

		
		try {
			funcEmpleado.visualizacionResultadoRondaEncuentros(empleado1);
		} catch (ArrayVacioException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FechaExpiradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("==============================================");
		try {
			funcEmpleado.visualizacionResultadoRondaEncuentros(empleado3);
		} catch (ArrayVacioException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FechaExpiradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("==============================================");
		
		
		//VISUALIZACION DE LOS RESULTADOS DE LA RONDA DE ENCUENTROS DE EMPLEADORES

		try {
			funcEmpleador.visualizacionResultadoRondaEncuentros(empleador2);
		} catch (ArrayVacioException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (FechaExpiradaException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("==============================================");
	
		try {
			funcEmpleador.visualizacionResultadoRondaEncuentros(empleador1);
		} catch (ArrayVacioException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (FechaExpiradaException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
/*		IPersistencia persistencia = new PersistenciaBIN();
        try
        {
            persistencia.abrirOutput("Sistema.bin");
            System.out.println("Crea archivo escritura");
            SistemaDTO sdto=UtilSistema.sistemaDTOFromSistema(sistema);
            persistencia.escribir(sdto);
            System.out.println("Sistema grabado exitosamente");
            persistencia.cerrarOutput();
            System.out.println("Archivo cerrado");
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            System.out.println(e.getLocalizedMessage());
        }

	
		
*/	}

}
