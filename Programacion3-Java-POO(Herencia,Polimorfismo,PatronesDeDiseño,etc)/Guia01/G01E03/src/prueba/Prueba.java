package prueba;

import modelo.Categoria;
import modelo.Empleado;

public class Prueba {

	public static void main(String[] args) {
	
		Categoria c1 = new Categoria("Principiante",80);
		Categoria c2 = new Categoria("Operario",100);
		Categoria c3 = new Categoria("Experto",130);
		Empleado e1 = new Empleado();
		e1.setNombre("Juan Perez");
		e1.setCat(c1);
		e1.setHorasTrabajadas(100);
		e1.setAntiguedad(4);
		Empleado e2 = new Empleado();
		e2.setNombre("Roberto Gonzalez");
		e2.setCat(c1);
		e2.setHorasTrabajadas(120);
		e2.setAntiguedad(8);
		Empleado e3 = new Empleado();
		e3.setNombre("Sandra Lopez");
		e3.setCat(c1);
		e3.setHorasTrabajadas(120);
		e3.setAntiguedad(14);
		Empleado e4 = new Empleado();
		e4.setNombre("German Gutierrez");
		e4.setCat(c2);
		e4.setHorasTrabajadas(110);
		e4.setAntiguedad(16);
		Empleado e5 = new Empleado();
		e5.setNombre("Vicente Hernandez");
		e5.setCat(c3);
		e5.setHorasTrabajadas(100);
		e5.setAntiguedad(9);
		Empleado e6 = new Empleado();
		e6.setNombre("Carolina Gomez");
		e6.setCat(c3);
		e6.setHorasTrabajadas(115);
		e6.setAntiguedad(20);
		System.out.println(e1.detalle());
		System.out.println(e2.detalle());
		System.out.println(e3.detalle());
		System.out.println(e4.detalle());
		System.out.println(e5.detalle());
		System.out.println(e6.detalle());
	}

}
