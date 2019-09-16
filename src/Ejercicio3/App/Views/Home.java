package Ejercicio3.App.Views;

import java.awt.Font;

import javax.swing.JLabel;

import Ejercicio3.App.Elements.Image;
import Ejercicio3.App.Elements.Label;
import Ejercicio3.App.Elements.Window;

@SuppressWarnings("serial")
public class Home extends Window {
	public Home() {
		this.setHeader("Inicio");
		
		JLabel lbl1 = new Label(119, 134, 415, 36, "Trabajo Práctico Nº 3");
		lbl1.setSize(365, 36);
		lbl1.setLocation(22, 15);
		lbl1.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JLabel lbl2 = new Label(12, 572, 101, 15, "Alejandro M. Tidele");
		lbl2.setFont(new Font("Dialog", Font.ITALIC, 10));
		
		JLabel lbl3 = new Label(563, 572, 75, 15, "Legajo: 21841");
		lbl3.setFont(new Font("Dialog", Font.ITALIC, 10));

		getContentPane().add(lbl1);
		getContentPane().add(lbl2);
		getContentPane().add(lbl3);
		Image image = new Image("main.gif", 12, 216, 626, 321);
		image.setBounds(127, 63, 430, 524);
		getContentPane().add(image);
		
		this.setVisible(true);
	}
}
