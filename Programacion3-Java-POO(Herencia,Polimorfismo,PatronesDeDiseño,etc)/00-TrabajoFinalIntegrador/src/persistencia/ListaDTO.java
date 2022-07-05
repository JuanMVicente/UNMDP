package persistencia;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListaDTO implements Serializable {
	private LocalDateTime fecha;
	private ArrayList<ListadoResultadoDTO> arrayResultadosRondaEncuentros = new ArrayList<ListadoResultadoDTO>();
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public ArrayList<ListadoResultadoDTO> getArrayResultadosRondaEncuentros() {
		return arrayResultadosRondaEncuentros;
	}
	public void setArrayResultadosRondaEncuentros(ArrayList<ListadoResultadoDTO> arrayResultadosRondaEncuentros) {
		this.arrayResultadosRondaEncuentros = arrayResultadosRondaEncuentros;
	}
	
	
}
