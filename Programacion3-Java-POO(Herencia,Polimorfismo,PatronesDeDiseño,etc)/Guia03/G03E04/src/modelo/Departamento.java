package modelo;

import java.util.ArrayList;

public class Departamento {
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	public void agregaEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}
	public void eliminaEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}
	
	public void plantillaSueldos() {
		for(int i=0; i<this.empleados.size();i++)
			System.out.println(empleados.get(i).getNombre() +": " + empleados.get(i).calculoSueldo());
	}
}
