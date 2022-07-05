package modelo;

public class AutomovilAutomatico extends Automovil{

	
	public AutomovilAutomatico(String patente, double velocidadMaxima) {
		super(patente, velocidadMaxima);
		// TODO Auto-generated constructor stub
	}

	public AutomovilAutomatico(String patente) {
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
			if(this.velocidad==0)
				this.marcha=0;
			else if(this.velocidad>0 && this.velocidad<=10)
				this.marcha=1;
			else if(this.velocidad>10 && this.velocidad<=35)
				this.marcha=2;
			else if(this.velocidad>35 && this.velocidad<=50)
				this.marcha=3;
			else if(this.velocidad>50 && this.velocidad<=90)
				this.marcha=4;
			else if(this.velocidad>00)
				this.marcha=5;
		}
		
	}

	@Override
	public void frenar(double velocidad) {
		if(velocidad>0) {
			if(this.velocidad>velocidad)
				this.velocidad = 0;
			else
				this.velocidad-=velocidad;
			if(this.velocidad==0)
				this.marcha=0;
			else if(this.velocidad>0 && this.velocidad<=10)
				this.marcha=1;
			else if(this.velocidad>10 && this.velocidad<=3510)
				this.marcha=2;
			else if(this.velocidad>35 && this.velocidad<=50)
				this.marcha=3;
			else if(this.velocidad>50 && this.velocidad<=90)
				this.marcha=4;
			else if(this.velocidad>00)
				this.marcha=5;
		}
		
		
	}
	
	

}
