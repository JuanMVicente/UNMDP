package modelo;

public class SospechaState implements IState
{
    private Soldado soldado;

    public SospechaState(Soldado soldado)
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
	return ("Esta sospechando algo raro");
    }

    @Override
    public String toString()
    {
	return "SospechaState";
    }

}
