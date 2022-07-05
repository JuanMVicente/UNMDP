package modelo;

import java.util.GregorianCalendar;

public class Llamado implements Comparable {
	GregorianCalendar fechaHoraAtendido;
	GregorianCalendar fechaHoraPedido;
	int prioridad;
	Socio socio;
	
	public Llamado(int prioridad, Socio socio) {
		super();
		this.prioridad = prioridad;
		this.socio = socio;
		GregorianCalendar obj = new GregorianCalendar();
		this.fechaHoraAtendido = new GregorianCalendar(obj.getTimeZone());
	}

	public GregorianCalendar getFechaHoraAtendido() {
		return fechaHoraAtendido;
	}

	public void setFechaHoraAtendido(GregorianCalendar fechaHoraAtendido) {
		this.fechaHoraAtendido = fechaHoraAtendido;
	}

	public GregorianCalendar getFechaHoraPedido() {
		return fechaHoraPedido;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public Socio getSocio() {
		return socio;
	}

	@Override
	public String toString() {
		return "Llamado [fechaHoraAtendido=" + fechaHoraAtendido + ", fechaHoraPedido=" + fechaHoraPedido
				+ ", prioridad=" + prioridad + ", socio=" + socio + "]";
	}

	@Override
	public int compareTo(Object o) {
		Llamado aux = (Llamado) o;
		if(this.prioridad==aux.prioridad)
			return this.fechaHoraAtendido.compareTo(aux.fechaHoraAtendido);
		else if(this.prioridad<aux.prioridad)
			return 1;
		else
			return -1;
	}
	
	
}
