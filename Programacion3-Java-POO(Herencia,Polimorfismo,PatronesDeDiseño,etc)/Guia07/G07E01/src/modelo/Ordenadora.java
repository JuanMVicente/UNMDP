package modelo;

public class Ordenadora {
	
	public static void ordenar(Comparable[] array) {
		Comparable aux = null;
		for(int i=0; i < array.length;i++) {
			for(int j=0; j < array.length; j++) {
				if(array[i].compareTo(array[j])<0) {
					System.out.println(array[i].compareTo(array[j]) + " - " + i + " - " + j);
					aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
			}
				
		}
	}
}
