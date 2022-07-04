package modelo;

import java.util.ArrayList;

public class Empresa {
    private static Empresa _instancia=null;
    private String nombre;
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private ArrayList<Colectivo> colectivos = new ArrayList<Colectivo>();
     
    private Empresa(String nombre)
    {
        this.nombre=nombre;
    }
    
    public static Empresa getInstancia(String nombre)
    {
        if(_instancia == null)
                _instancia = new Empresa(nombre);
        
        return _instancia;              
    }
    
    public ArrayList<Chofer> getChoferes() {
                return choferes;
        }

        public ArrayList<Colectivo> getColectivos() {
                return colectivos;
        }

        public ArrayList<Categoria> getCategorias() {
                return categorias;
        }

        public void agregarChofer (Chofer chofer)
    {
        this.choferes.add(chofer);
    }
    
    public void agregarColectivo (Colectivo colectivo)
    {
        this.colectivos.add(colectivo);
    }
    
    public void eliminarChofer (Chofer chofer)
    {
        this.choferes.remove(chofer);
    }
    
    public void eliminarColectivo (Colectivo colectivo)
    {
        this.colectivos.remove(colectivo);
    }
    
    public void agregarCategorias (Categoria categoria)
    {
        this.categorias.add(categoria);
    }
    
    public void eliminarCategorias (Categoria categoria)
    {
        this.categorias.remove(categoria);
    }

}
