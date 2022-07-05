package dato;
import exceptions.ParametroFormularioFactoryException;
import negocio.Ilocacion;

/**
 * Clase que solo tiene como funcion retornar (mediante un getter), un nuevo formulario creado a partir de los datos ingresados.
 * pre: ninguno
 * post: Si los datos fueron admitidos (segun la clase tipodedatosticket), devolvera dicho formulario , de lo contrario lanza excepcion.
 * @author Grupo 9
 */
public class GeneradorFormulario {
	/**
	 * Esta clase solo contiene un getter del formulario de busqueda. Busca el valor de los parametros en la clase TiposDatosTicktets y en caso
	 * de que exista algun parametro mal ingresado (no existe en TiposDatosTicktets), lanza una excepcion.
	 * pre: Cualquier valor int es aceptado como parametro.
	 * post: retorna el formulario creado con los datos en caso de ser correctos , si estos datos no pertenecen al tipodedatosticket, lanza excepcion.
	 * @param locacion (0,1,2): <br>0 = HomeOffice <br> 1 = Presencial  <br> 2=indistinto
	 * @param remuneracion (0,1,2): <br>0 = 4000 <br> 1= 80000 <br> 2=120000. 
	 * @param cargaHoraria (0,1,2): <br>0 = media <br> 1 = completa  <br> 2 = extendida
	 * @param tipoPuesto (0,1,2): <br>0 = junior <br> 1 = senior <br> 2=managment
	 * @param rangoEtario (0,1,2):<br> 0 = 18 <br> 1 = 35 <br> 2= 50
	 * @param experiencia (0,1,2):<br> 0 = nada <br> 1 = media  <br> 2 = mucha
	 * @param estudios (0,1,2):<br> 0 = nada <br> 1 = media  <br> 2 = mucha <br>
	 * @throws ParametroFormularioFactoryException Excepcion con mensaje que indica que parametro se ingreso mal o en caso que haya mas de uno se enviara uno de ellos.
	 */
	public FormularioBusqueda getFormulario(int locacion, int remuneracion, int cargaHoraria, int tipoPuesto, int rangoEtario, int experiencia, int estudios) throws ParametroFormularioFactoryException 
	{	   
		 			
		 	if(TiposDatosTicktets.getLocacion().containsKey(locacion)) 
			{
			 	Ilocacion loc = TiposDatosTicktets.getLocacion().get(locacion);
			 	
			 	if(TiposDatosTicktets.getRemuneracion().containsKey(remuneracion)) 
				{
					if(TiposDatosTicktets.getTipoPuesto().containsKey(tipoPuesto)) 
					{	
						if(TiposDatosTicktets.getCargaHoraria().containsKey(cargaHoraria)) 
						{
							if(TiposDatosTicktets.getRangoEtario().containsKey(rangoEtario)) 
							{
								if(TiposDatosTicktets.getExperiencia().containsKey(experiencia)) 
								{
									if(TiposDatosTicktets.getEstudios().containsKey(estudios)) 
									{
										return new FormularioBusqueda(loc, locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experiencia, estudios);
									}
									else
										throw new ParametroFormularioFactoryException("El tipo de estudio ingresado no existe"); 
								}
								else
									throw new ParametroFormularioFactoryException("La experiencia indicada no existe"); 
							}
							else
								throw new ParametroFormularioFactoryException("El rango etario indicado no existe"); 
						}
						else
							throw new ParametroFormularioFactoryException("La carga horaria indicada no existe"); 
					}
					else
						throw new ParametroFormularioFactoryException("El tipo de puesto indicado no existe"); 
				}
				else
					throw new ParametroFormularioFactoryException("La remuneracion indicada no existe"); 
			}
			else
				throw new ParametroFormularioFactoryException("La locacion indicada no existe"); 
		
	}
}