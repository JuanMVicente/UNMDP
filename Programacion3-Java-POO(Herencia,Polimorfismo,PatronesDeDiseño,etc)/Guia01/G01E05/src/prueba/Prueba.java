package prueba;

import modelo.Guerrero;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guerrero g1;
		g1 = new Guerrero();
		g1.setNombre("Ion");
		g1.setVitalidad(1000);
		g1.setArmadura(600);
		g1.setX(200);
		g1.setY(150);
		
		g1.mover(40,-70);
		System.out.println(g1);
		g1.recibeDano(500);
		System.out.println(g1);
		g1.recibeDano(500);
		System.out.println(g1);
		
	}

}
