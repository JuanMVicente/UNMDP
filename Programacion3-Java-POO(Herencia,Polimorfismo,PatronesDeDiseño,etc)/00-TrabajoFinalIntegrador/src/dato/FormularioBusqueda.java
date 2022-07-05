package dato;

import negocio.Ilocacion;

public class FormularioBusqueda {

	private Ilocacion locacion;
	private int locacionInt;
	private int remuneracion;
	private int cargaHoraria;
	private int tipoPuesto;
	private int rangoEtario;
	private int experienciaPrevia;
	private int estudios;
	
	public FormularioBusqueda(Ilocacion locacion, int locacionInt, int remuneracion, int cargaHoraria, int tipoPuesto, 
							  int rangoEtario, int experienciaPrevia, int estudios) 
	
	{ 
		super();
		this.locacion = locacion;
		this.locacionInt = locacionInt;
		this.remuneracion = remuneracion;
		this.cargaHoraria = cargaHoraria;
		this.tipoPuesto = tipoPuesto;
		this.rangoEtario = rangoEtario;
		this.experienciaPrevia = experienciaPrevia;
		this.estudios = estudios;
	}
	
	
	public Ilocacion getLocacion() {
		return locacion;
	}

	public int getLocacionInt() {
		return locacionInt;
	}

	public int getRemuneracion() {
		return remuneracion;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public int getTipoPuesto() {
		return tipoPuesto;
	}

	public int getRangoEtario() {
		return rangoEtario;
	}

	public int getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public int getEstudios() {
		return estudios;
	}

	
	
	//poner el to String (agregar el int de locacion para visualizar)
	
	
	@Override
	public String toString() {
		return "FormularioBusqueda :"
				+ "  locacion=" + locacion 
				+ ", remuneracion= "+ TiposDatosTicktets.getRemuneracion().get(remuneracion) 
				+ ", cargaHoraria= " + TiposDatosTicktets.getCargaHoraria().get(cargaHoraria) 
				+ ", tipoPuesto= " + TiposDatosTicktets.getTipoPuesto().get(tipoPuesto)
				+ ", rangoEtario= "+ TiposDatosTicktets.getRangoEtario().get(rangoEtario)
				+ ", experienciaPrevia= " + TiposDatosTicktets.getExperiencia().get(experienciaPrevia)
				+ ", estudios= " + TiposDatosTicktets.getEstudios().get(estudios);
	}
	
		
} 

