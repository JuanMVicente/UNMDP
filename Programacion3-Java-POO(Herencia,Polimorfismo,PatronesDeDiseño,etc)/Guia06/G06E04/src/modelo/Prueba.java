package modelo;

public class Prueba {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ConjuntoNumeros conjA = new ConjuntoNumeros(3,"Ion");
		int [] x = {1,2,3};
		conjA.setCelda(x);
		
		System.out.println(conjA.toString());
		
		ConjuntoNumeros conjB = (ConjuntoNumeros) conjA.clone();
		
		
		if ((conjA) == (conjB))
	}

}
