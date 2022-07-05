package modelo;

public class EmpleadoPermanente extends Empleado {
	private int antiguedad;
	private double sueldoBase;
	private String categoria;
	
	public EmpleadoPermanente(String nombre, int legajo, String domicilio, int antiguedad, double sueldoBase,
			String categoria) {
		super(nombre, legajo, domicilio);
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.setCategoria(categoria);
	}

	@Override
	public double calculoSueldo() {
		double sueldo = this.sueldoBase;
		if(this.categoria == "Intermedio") {
			sueldo=sueldo*(1.25+0.01*this.antiguedad);
		}
		else
			if(this.categoria == "Experto")
				sueldo=sueldo*(1.5+0.015*this.antiguedad);
			else
				if (this.antiguedad>20)
					sueldo*=1.2;
				else
					if (this.antiguedad>15)
						sueldo*=1.15;	
					else
						if (this.antiguedad>10)
							sueldo*=1.1;
						else
							if (this.antiguedad>5)
								sueldo*=1.07;
							else
								if (this.antiguedad>2)
									sueldo*=1.05;				
		return sueldo*0.83;
	}

	public String getCategoria() {
		return categoria;
	}

	public String setCategoria(String categoria) {
		this.categoria = categoria;
		return categoria;
	}
	
	
}
