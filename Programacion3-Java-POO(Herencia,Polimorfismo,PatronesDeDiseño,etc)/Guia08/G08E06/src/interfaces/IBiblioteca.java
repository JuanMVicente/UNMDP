package interfaces;

import modelo.Revista;
import modelo.SocioLibro;
import modelo.SocioRevista;

public interface IBiblioteca
{
    
    void agregarLibro(ILibro libro);

    void solicitarLibro(SocioLibro socio);

    void devolverLibro(SocioLibro socio);
    
    void agregarRevista(IRevista revista);

    void solicitarRevista(SocioRevista socio);

    void devolverRevista(SocioRevista socio);
}
