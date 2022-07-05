package modelo;

public class ColectivoLinea extends Colectivo {

	public ColectivoLinea(String modelo) {
		super(modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean aceptoChofer(Chofer chofer) {
		// TODO Auto-generated method stub
		return chofer.getCategoria().isHabilitaColectivoLinea();
	}

}
