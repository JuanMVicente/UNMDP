package modelo;

public class AtaqueState implements IState
{
    private Soldado soldado;

    public AtaqueState(Soldado soldado)
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
	
    }

    @Override
    public void hayEvidencia()
    {
	

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
	//Muchas Lineas de codigo que realizan la accion correspondiente
	return "Esta ATACANDO";
    }

    @Override
    public String toString()
    {
	return "AtaqueState";
    }
    
    
    

}
