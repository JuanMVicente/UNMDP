package persistencia;

import java.io.IOException;

import negocio.Sistema;

public class PersistenciaEscritura {


	private static Sistema sistema = Sistema.getInstance();

	public static void EscrituraArchivo() {
		
		IPersistencia persistencia = new PersistenciaBIN();
        try
        {
            persistencia.abrirOutput("Sistema.bin");
            System.out.println("Crea archivo escritura");
            SistemaDTO sdto=UtilSistema.sistemaDTOFromSistema(sistema);
            persistencia.escribir(sdto);
            System.out.println("Sistema grabado exitosamente");
            persistencia.cerrarOutput();
            System.out.println("Archivo cerrado");
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            System.out.println(e.getLocalizedMessage());
        }

	}
}
