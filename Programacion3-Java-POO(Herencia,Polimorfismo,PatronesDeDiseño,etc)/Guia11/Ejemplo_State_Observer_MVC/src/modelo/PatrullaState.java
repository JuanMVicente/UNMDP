package modelo;

public class PatrullaState implements IState
{
    private Soldado soldado;

    public PatrullaState(Soldado soldado)
    {
	this.soldado = soldado;
    }

    @Override
    public void volvePatrullar()
    {
	
    }

    @Override
    public void haySospechas()
    {
	this.soldado.setEstado(new SospechaState(this.soldado));
    }

    @Override
    public void hayEvidencia()
    {
	this.soldado.setEstado(new AtaqueState(this.soldado));
	    }

    @Override
    public void saludaSuperior()
    {
	this.soldado.setEstado(new SaludoState(this.soldado));
	
    }

    @Override
    public void recibeDanoLetal()
    {
	this.soldado.setEstado(new MuertoState(this.soldado));
	
    }

    @Override
    public String actua()
    { // Muchas Lineas de codigo que realizan la accion correspondiente
	return ("Esta patrullando");
    }

    @Override
    public String toString()
    {
	return "PatrullaState";
    }

}
