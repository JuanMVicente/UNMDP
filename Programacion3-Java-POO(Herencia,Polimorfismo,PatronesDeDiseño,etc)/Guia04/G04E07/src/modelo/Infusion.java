package modelo;

public abstract class Infusion {
	
	
	public void prepararInfusion(){
		this.calentarAgua();
		this.agregarTipoInfusion();
		this.endulzar();
	}
	
	protected void calentarAgua() {
		System.out.println("Calentando el agua");
	}
	
	protected abstract void agregarTipoInfusion();
	
	protected void endulzar() {
		System.out.println("La bebida se tomara Amarga");
	}
	
}
