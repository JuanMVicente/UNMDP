package modelo;

public class Prueba {

	public static void main(String[] args) {
		Departamento mantenimiento = new Departamento();
		Departamento contabilidad = new Departamento();
		
		Empleado e1 = new EmpleadoPermanente("Juan Perez", 1234, "Matheu 2343", 7, 12000, "Intermedio");
		mantenimiento.agregaEmpleado(e1);
		e1 = new EmpleadoTemporario("Julio Garcia", 3209, "Colon 5561", 80, 160);
		mantenimiento.agregaEmpleado(e1);
		e1 = new EmpleadoTemporario("Martin Rodriguez", 3210, "Mitre 3451", 70, 100);
		mantenimiento.agregaEmpleado(e1);
		
		e1 = new EmpleadoPermanente("Mara Anchorena", 9876, "Luro 3489", 18, 13000, "Experto");
		contabilidad.agregaEmpleado(e1);
		e1 = new EmpleadoPermanente("Sandra Fernandez", 1276, "Cordoba 3843", 6, 11500, "Principiante");
		contabilidad.agregaEmpleado(e1);
		e1 = new EmpleadoPermanente("Luis Gomez", 1544, "Formosa 2354", 2, 10500, "Principiante");
		contabilidad.agregaEmpleado(e1);
		e1 = new EmpleadoPermanente("Lucas Benitez", 1276, "Castelli 4563", 18, 12500, "Intermedio");
		contabilidad.agregaEmpleado(e1);
		
		mantenimiento.plantillaSueldos();
		contabilidad.plantillaSueldos();
		
		//System.out.println(e1.prueba());
	}
	
}
