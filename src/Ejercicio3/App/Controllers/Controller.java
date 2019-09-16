package Ejercicio3.App.Controllers;

public class Controller {
	private static Boolean error = false;

	protected static final void assertOrFail(Boolean comparison, Exception ex) throws Exception {
		if (! comparison) throw ex;
	}


	protected static final void assertOrFail(Boolean comparison, Boolean expected, Exception ex) throws Exception {
		if (comparison != expected) throw ex;
	}
	
	public static final Boolean hasError() {
		return error;
	}

	public static final void setError(Boolean error) {
		Controller.error = error;
	}
}
