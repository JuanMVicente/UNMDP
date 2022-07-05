package modelo;

import modelo.Domicilio;

public class Chofer {
    private Categoria categoria;
    private Domicilio domicilio;
    private String nombre;
    private Colectivo colectivo;

    public Chofer(Categoria categoria, Domicilio domicilio, String nombre) {
        this.categoria = categoria;
        this.domicilio = domicilio;
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }
    public void asignarColectivo(Colectivo colectivo)
    {
        this.colectivo=colectivo;
    }
    
    public void desvincularColectivo()
    {
        this.colectivo=null;
    }
}

