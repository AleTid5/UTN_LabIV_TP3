package Ejercicio3.App.Elements;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextField extends JTextField {
	public TextField(int x, int y, int w, int h) {
		this.setBounds(x, y, w, h);
		this.setColumns(10);
	}
	
	public TextField(int x, int y, int w, int h, String tooltip) {
		this(x, y, w, h);
		this.setToolTipText(tooltip);
	}
	
	public TextField(int x, int y, int w, int h, boolean visible) {
		this(x, y, w, h);
		this.setVisible(visible);
	}
	
	public TextField(int x, int y, int w, int h, String tooltip, boolean visible) {
		this(x, y, w, h, tooltip);
		this.setVisible(visible);
	}
}
