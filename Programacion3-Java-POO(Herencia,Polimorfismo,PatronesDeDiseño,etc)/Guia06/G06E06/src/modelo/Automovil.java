package modelo;

public class Automovil implements Cloneable{
	private String marca;
	private String modelo;
	private Motor motor;
	private String patente;
	
	@Override
	 public Object clone() throws CloneNotSupportedException
	 {
		Automovil aux = (Automovil) super.clone();
		Motor motorClonado=new Motor();
		motorClonado.setFabricante(this.motor.getFabricante());
		motorClonado.setNSerie(this.motor.getNSerie());
		motorClonado.setPotencia(this.motor.getPotencia());
		aux.setMotor(motorClonado);
		return aux;
	 }
	//El problema de clonar así es que si se quiere cambiar y hacer que alguno de estos atributos no sean primitivos
	//no se va a clonear bien el objeto ya que no cumpliría con la clonación en cascada.

	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
}
