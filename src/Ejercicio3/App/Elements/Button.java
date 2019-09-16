package Ejercicio3.App.Elements;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {
	public Button(int x, int y, int w, int h, String tooltip, Image image, ActionListener action) {
		this.setBounds(x, y, w, h);
		this.setBackground(image.getBackground());
		this.setToolTipText(tooltip);
		this.setIcon(image.getIcon());
		this.setBorder(null);
		this.addActionListener(action);
	}
}
