package modelo;

public class Guerrero 
{
	//Atributos
	private String nombre;
	private double vitalidad = 1500;
	private double armadura = 600;
	private double x;
	private double y;
	
	//Constructor
	public Guerrero() {}
	public Guerrero(String nombre) {
		this.nombre = nombre;
	}
	public Guerrero(String nombre, double x, double y){
		this.nombre = nombre;
		this.x = x;
		this.y = y;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVitalidad() {
		return vitalidad;
	}
	public void setVitalidad(double vitalidad) {
		this.vitalidad = vitalidad;
	}
	public double getArmadura() {
		return armadura;
	}
	public void setArmadura(double armadura) {
		this.armadura = armadura;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void mover(double inc_x, double inc_y){
		this.x += inc_x;
		this.y += inc_y;
	}
	public void recibeDano(double cantidad) {
		if(cantidad <= this.armadura)
			this.armadura -= cantidad;
		else {
			this.vitalidad -= (cantidad - this.armadura);
			this.armadura = 0;			
		}
				
	}
	@Override
	public String toString() {
		return "Guerrero [nombre=" + nombre + ", vitalidad=" + vitalidad + ", armadura=" + armadura + ", x=" + x
				+ ", y=" + y + "]";
	}
	
	
}


