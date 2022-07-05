package modelo;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socio Sa = new Socio(111,"aaaaaa", "1111");
		Socio Sb = new Socio(222,"bbbbbb", "2222");
		Socio Sc = new Socio(333,"cccccc", "3333");
		Socio Sd = new Socio(444,"dddddd", "4444");
		Socio Se = new Socio(555,"eeeeee", "5555");
		
		Llamado L1 = new Llamado(4,Sa);
		Llamado L2 = new Llamado(3,Sb);
		Llamado L3 = new Llamado(2,Sc);
		Llamado L4 = new Llamado(3,Sd);
		Llamado L5 = new Llamado(4,Se);
		
		ListaConPrioridades<Llamado> lista = new ListaConPrioridades<Llamado>();
		lista.agrega(L1);
		lista.agrega(L2);
		lista.agrega(L3);
		lista.agrega(L4);
		lista.agrega(L5);
		
		System.out.println(lista.getElemento());
		System.out.println(lista.consultaElemento());
		System.out.println(lista.getElemento());
		System.out.println(lista.getElemento());
		System.out.println(lista.consultaElemento());
		
		//System.out.println("ion".compareTo("ian"));

	}

}
