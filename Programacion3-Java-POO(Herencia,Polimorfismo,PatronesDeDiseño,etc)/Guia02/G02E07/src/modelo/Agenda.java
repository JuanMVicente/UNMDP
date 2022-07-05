package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {

	public ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	
	
	public Contacto buscar(String contacto) {
		int i=0;
		while(this.contactos.size() >0 && this.contactos.get(i).getNombre().equals(contacto));
			i++;
		return this.contactos.get(i);
	}
	
	public void addContacto(Contacto contacto) {
		int i=0;
		while(i<this.contactos.size() && this.contactos.get(i).getNombre() != contacto.getNombre()) {
			i++;
		}
		if(this.contactos.size()==0)
			this.contactos.add(contacto);
		else {	
			if(i==this.contactos.size()){
				this.contactos.add(contacto);
				Collections.sort(this.contactos, new Comparator<Contacto>() {
					@Override
					public int compare(Contacto o1, Contacto o2) {
						// TODO Auto-generated method stub
						return new String(o1.getNombre()).compareTo((o2.getNombre()));
					}
				});
			}
			else
				System.out.println("Contacto existente");	
		}
	}
	
	public void muestraContactos() {
		for(int i=0; i<this.contactos.size();i++) {
			System.out.println(this.contactos.get(i).toString());
		}
	}
	
}
