package vista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import modelo.Soldado;

public interface IVista
{
Soldado getSoldadoSeleccionado();
String getNombreNuevoSoldado();
void addActionListener(ActionListener listener);
void actualizaLista(Iterator<Soldado> iteratorSoldados);
}
