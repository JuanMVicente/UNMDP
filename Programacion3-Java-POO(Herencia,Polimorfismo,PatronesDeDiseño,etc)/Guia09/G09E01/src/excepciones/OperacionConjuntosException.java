package excepciones;

public class OperacionConjuntosException extends Exception
{
    private Object elemento;
    
    public OperacionConjuntosException(String mensaje, Object elemento)
    {
        super(mensaje);
        this.elemento = elemento;
    }

    public Object getElemento()
    {
        return elemento;
    }
}
