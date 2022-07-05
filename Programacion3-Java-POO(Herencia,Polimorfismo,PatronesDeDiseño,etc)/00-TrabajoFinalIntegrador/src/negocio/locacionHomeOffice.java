package negocio;

public class locacionHomeOffice implements Ilocacion {

	@Override
	public double versus(Ilocacion o) {
		return o.versusHomeOffice();
	}

	@Override
	public double versusHomeOffice() {
		return 1;
	}

	@Override
	public double versusPresencial() {
		return -1;
	}

	@Override
	public double versusIndistinto() {
		return 1;
	}
	
	@Override
	public String toString() {
		return "HOME OFFICE";
	}

}
