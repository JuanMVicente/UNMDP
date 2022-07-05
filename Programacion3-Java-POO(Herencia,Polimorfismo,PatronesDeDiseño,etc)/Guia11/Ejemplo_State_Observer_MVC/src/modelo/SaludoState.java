package modelo;

public class SaludoState implements IState
{
    private Soldado soldado;

    public SaludoState(Soldado soldado)
    {
	this.soldado = soldado;
    }

    @Override
    public void volvePatrullar()
    {
	this.soldado.setEstado(new PatrullaState(this.soldado));
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
    }

    @Override
    public void recibeDanoLetal()
    {
	this.soldado.setEstado(new MuertoState(this.soldado));
    }

    @Override
    public String actua()
    {
	return ("esta SALUDANDO a un superior");
    }

    @Override
    public String toString()
    {
	return "SaludoState";
    }

}
