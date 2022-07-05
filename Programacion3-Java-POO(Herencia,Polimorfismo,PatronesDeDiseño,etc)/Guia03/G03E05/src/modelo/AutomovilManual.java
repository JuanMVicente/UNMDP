package modelo;

public class AutomovilManual extends Automovil{



	public AutomovilManual(String patente, double velocidadMaxima) {
		super(patente, velocidadMaxima);
		// TODO Auto-generated constructor stub
	}

	public AutomovilManual(String patente) {
		super(patente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acelerar(double velocidad) {
		if(velocidad>0) {
			if(this.velocidad+velocidad>this.velocidadMaxima)
				this.velocidad = this.velocidadMaxima;
			else
				this.velocidad+=velocidad;	
		}
	}

	@Override
	public void frenar(double velocidad) {
		if(velocidad>0) {
			if(this.velocidad<velocidad)
				this.velocidad = 0;
			else
				this.velocidad-=velocidad;	
		}
	}
	

}
