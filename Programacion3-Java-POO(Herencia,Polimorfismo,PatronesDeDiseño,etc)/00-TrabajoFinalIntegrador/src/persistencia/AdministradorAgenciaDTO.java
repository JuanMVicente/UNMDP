package persistencia;

import java.io.Serializable;

public class AdministradorAgenciaDTO extends UsuarioDTO implements Serializable {
	public double comisionesCobradas;

	public double getComisionesCobradas() {
		return comisionesCobradas;
	}

	public void setComisionesCobradas(double comisionesCobradas) {
		this.comisionesCobradas = comisionesCobradas;
	}
	
}
