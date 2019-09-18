package Ejercicio3.App.Controllers;

import javax.swing.JComponent;

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
	
	public static final void changeVisibility(Boolean visible, JComponent ...jComponents) {
		for (JComponent jComponent: jComponents) jComponent.setVisible(visible);
	}
}
