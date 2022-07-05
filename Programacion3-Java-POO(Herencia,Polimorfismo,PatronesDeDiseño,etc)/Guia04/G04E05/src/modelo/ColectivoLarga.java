package modelo;

public class ColectivoLarga extends Colectivo {
	
	public ColectivoLarga(String modelo) {
		super(modelo);
		// TODO Auto-generated constructor stub
	}

	private boolean cocheCama;

	@Override
	public boolean aceptoChofer(Chofer chofer) {
		// TODO Auto-generated method stub
		return chofer.getCategoria().isHabilitaColectivoLarga();
	}
}
