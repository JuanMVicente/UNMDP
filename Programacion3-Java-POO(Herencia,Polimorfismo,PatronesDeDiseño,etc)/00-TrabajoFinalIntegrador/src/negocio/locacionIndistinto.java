package negocio;

public class locacionIndistinto implements Ilocacion {

	@Override
	public double versus(Ilocacion o) {
		// TODO Auto-generated method stub
		return o.versusIndistinto();
	}

	@Override
	public double versusHomeOffice() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double versusPresencial() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double versusIndistinto() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		return "INDISTINTO";
	}
}
