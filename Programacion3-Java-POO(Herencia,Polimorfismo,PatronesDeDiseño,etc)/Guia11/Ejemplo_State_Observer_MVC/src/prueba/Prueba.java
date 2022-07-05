package prueba;

import controlador.Controlador;
import vista.Ventanita;

public class Prueba
{
    public static void main(String[] args)
    {
	Ventanita frame = new Ventanita();

	Controlador controlador = new Controlador(frame);

	frame.setVisible(true);
    }

}
