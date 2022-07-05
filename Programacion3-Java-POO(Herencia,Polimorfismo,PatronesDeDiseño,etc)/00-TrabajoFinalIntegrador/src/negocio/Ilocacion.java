package negocio;

public interface Ilocacion {
	double versus(Ilocacion o);
	
	double versusHomeOffice();
	double versusPresencial();
	double versusIndistinto();
	String toString();
	
}
	