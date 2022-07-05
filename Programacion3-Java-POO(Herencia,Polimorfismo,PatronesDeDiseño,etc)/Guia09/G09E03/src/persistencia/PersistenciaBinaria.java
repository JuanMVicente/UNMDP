package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistenciaBinaria implements IPersistencia
{
    private FileOutputStream fileOutput;
    private FileInputStream fileInput;
    private ObjectOutputStream objectOutput;
    private ObjectInputStream objectInput;
    
    public PersistenciaBinaria()
    {
        super();
    }

    @Override
    public void abrirInput(String nombre) throws IOException
    {
        fileInput = new FileInputStream(nombre);
        objectInput = new ObjectInputStream(fileInput);
    }

    @Override
    public void cerrarInput() throws IOException
    {
        if (objectInput != null)
            objectInput.close();
    }

    @Override
    public void abrirOutput(String nombre) throws IOException
    {
        fileOutput = new FileOutputStream(nombre);
        objectOutput = new ObjectOutputStream(fileOutput);
    }

    @Override
    public void cerrarOutput() throws IOException
    {
        if (objectOutput != null)
            objectOutput.close();
    }

    @Override
    public void escribir(Serializable obj) throws IOException
    {
        if (objectOutput != null)
            objectOutput.writeObject(obj);        
    }

    @Override
    public Serializable leer() throws IOException, ClassNotFoundException
    {
        Serializable obj = null;
        
        if (objectInput != null)
            obj = (Serializable) objectInput.readObject();        
        
        return obj;
    }
}
