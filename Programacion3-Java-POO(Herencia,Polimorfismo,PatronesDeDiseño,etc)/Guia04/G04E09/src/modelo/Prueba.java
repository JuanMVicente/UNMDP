package modelo;

public class Prueba {

	public static void main(String[] args)
	 {
	 Base b = new Base();
	 Base e = new Extendida();
	 System.out.println("== 1 ==");
	 System.out.println(b.metodo1(e));
	 System.out.println("== 2 ==");
	 System.out.println(e.metodo1(e));
	 System.out.println("== 3 ==");
	 System.out.println(b.metodo1((Extendida) e));
	 System.out.println("== 4 ==");
	 System.out.println(e.metodo1((Extendida) e));
	 System.out.println("== 5 ==");
	 //System.out.println(b.metodo2(b));
	 System.out.println("== 6 ==");
	 //System.out.println(e.metodo2(e));
	 System.out.println("== 7 ==");
	 //System.out.println(e.metodo2((Extendida) b));
	 System.out.println("== 8 ==");
	 System.out.println(e.metodo2((Extendida) e));
	 Extendida x = (Extendida) e;
	 System.out.println("== 9 ==");
	 System.out.println(x.metodo2(b));
	 System.out.println("== 10 ==");
	 System.out.println(x.metodo2(e));
	 }
}
