package Ejercicio3.App.Elements;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Label extends JLabel {
	public Label(int x, int y, int w, int h, String label) {
		this.setText(label);
		this.setBounds(x, y, w, h);
	}
	
	public Label(int x, int y, int w, int h, String label, boolean visible) {
		this(x, y, w, h, label);
		this.setVisible(visible);
	}
}
