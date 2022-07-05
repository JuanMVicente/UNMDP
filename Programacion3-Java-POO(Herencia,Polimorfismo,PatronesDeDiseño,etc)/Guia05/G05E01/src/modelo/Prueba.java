package modelo;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<IEmisorDeSonido> animales = new ArrayList<IEmisorDeSonido>(); 
		
		animales.add(new Perro());
		animales.add(new Gato());
		animales.add(new Pollito());
		animales.add(new Vaca());
		animales.add(new Ambulancia());
		
		for(int i=0; i<animales.size();i++)
			animales.get(i).emiteSonido();
		
	
	
	}
	
	
	

}
