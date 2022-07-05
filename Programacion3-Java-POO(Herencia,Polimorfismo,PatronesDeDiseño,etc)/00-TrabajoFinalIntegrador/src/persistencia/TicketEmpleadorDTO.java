package persistencia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TicketEmpleadorDTO implements Serializable {
	
	private int cantidadEmpleadosSolicitados;
	private int cantidadEmpleadosObtenidos = 0;
	private LocalDateTime fechaAlta;
	private String estado = "activo";
	private int locacionInt;
	private int remuneracion;
	private int cargaHoraria;
	private int tipoPuesto;
	private int rangoEtario;
	private int experienciaPrevia;
	private int estudios;
	private String nombreUsuarioEmpleado;
	
	public String getNombreUsuarioEmpleado() {
		return nombreUsuarioEmpleado;
	}
	public void setNombreUsuarioEmpleado(String nombreUsuarioEmpleado) {
		this.nombreUsuarioEmpleado = nombreUsuarioEmpleado;
	}
	public int getCantidadEmpleadosSolicitados() {
		return cantidadEmpleadosSolicitados;
	}
	public void setCantidadEmpleadosSolicitados(int cantidadEmpleadosSolicitados) {
		this.cantidadEmpleadosSolicitados = cantidadEmpleadosSolicitados;
	}
	public int getCantidadEmpleadosObtenidos() {
		return cantidadEmpleadosObtenidos;
	}
	public void setCantidadEmpleadosObtenidos(int cantidadEmpleadosObtenidos) {
		this.cantidadEmpleadosObtenidos = cantidadEmpleadosObtenidos;
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
