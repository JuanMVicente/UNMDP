package modelo;

import java.util.HashMap;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto a = new Contacto("Juan","324","32424");
		
		Agenda agenda = new Agenda();
		agenda.addContacto(a);
		a = new Contacto("Pablo","324", "4353");
		agenda.addContacto(a);
		a = new Contacto("Augusto","324", "4353");
		agenda.addContacto(a);
		agenda.muestraContactos();
		System.out.println("============================");
		a = new Contacto("Ariel","324", "4353");
		agenda.addContacto(a);
		a = new Contacto("Ezequiel","324", "4353");
		agenda.addContacto(a);
		//a = new Contacto("Augusto","324", "4353");
		//agenda.addContacto(a);
		a = new Contacto("Victor","324", "4353");
		agenda.addContacto(a);
		System.out.println("============================");
		agenda.muestraContactos();
	}

}
