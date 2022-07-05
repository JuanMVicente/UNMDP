package modelo;

public class Persona implements Cloneable, Comparable {
	private int DNI;
	private String apellido;
	private Domicilio domicilio;
	private int legajo;
	private Animal animal;
	
	public Persona() {
		super();
	}
	
	

	public Persona(int dNI, String apellido, Domicilio domicilio, Animal animal) {
		super();
		DNI = dNI;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.animal = animal;
	}
	
	


	public Animal getAnimal() {
		return animal;
	}



	public void setAnimal(Animal animal) {
		this.animal = animal;
	}



	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", apellido=" + apellido + ", domicilio=" + domicilio + ", animal=" + animal.toString()
				+ "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Persona personaClonada = null;
		personaClonada =(Persona) super.clone();
		
		if(this.domicilio!=null)personaClonada.domicilio = (Domicilio) this.domicilio.clone();
		if(this.animal!=null)personaClonada.animal = (Animal) this.animal.clone();
		
		return personaClonada;
		
	
	}


	@Override
	public int compareTo(Object o) {
		Persona compara = (Persona) o;
		if(this.apellido.compareTo(compara.apellido)!=0)
			return this.apellido.compareTo(compara.apellido);
		else
			return this.DNI - compara.DNI;
	}
	
}
