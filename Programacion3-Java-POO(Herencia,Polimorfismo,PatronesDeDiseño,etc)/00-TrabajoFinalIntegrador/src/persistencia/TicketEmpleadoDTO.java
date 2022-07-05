package persistencia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TicketEmpleadoDTO implements Serializable {
	private int resultado;
	private LocalDateTime fechaAlta;
	private String estado = "activo";
	private int locacionInt;
	private int remuneracion;
	private int cargaHoraria;
	private int tipoPuesto;
	private int rangoEtario;
	private int experienciaPrevia;
	private int estudios;
	private String nombreUsuarioEmpleador;
	
	
	public String getNombreUsuarioEmpleador() {
		return nombreUsuarioEmpleador;
	}
	public void setNombreUsuarioEmpleador(String nombreUsuarioEmpleador) {
		this.nombreUsuarioEmpleador = nombreUsuarioEmpleador;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getLocacionInt() {
		return locacionInt;
	}
	public void setLocacionInt(int locacionInt) {
		this.locacionInt = locacionInt;
	}
	public int getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(int remuneracion) {
		this.remuneracion = remuneracion;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public int getTipoPuesto() {
		return tipoPuesto;
	}
	public void setTipoPuesto(int tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}
	public int getRangoEtario() {
		return rangoEtario;
	}
	public void setRangoEtario(int rangoEtario) {
		this.rangoEtario = rangoEtario;
	}
	public int getExperienciaPrevia() {
		return experienciaPrevia;
	}
	public void setExperienciaPrevia(int experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}
	public int getEstudios() {
		return estudios;
	}
	public void setEstudios(int estudios) {
		this.estudios = estudios;
	}
	
	
	
}
