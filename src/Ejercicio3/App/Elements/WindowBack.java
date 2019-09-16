package Ejercicio3.App.Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;

import Ejercicio3.App.Interfaces.IBackButton;
import Ejercicio3.App.Views.Home;

@SuppressWarnings("serial")
public class WindowBack extends Window implements IBackButton {
	public WindowBack() {
		JButton btnNewButton = new Button(310, 537, 50, 50, "Volver a la pantalla principal", new Image("home.png", 310, 537, 50, 50), this.goBack());
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(153, 51, 0));
		separator.setBackground(new Color(153, 51, 0));
		separator.setBounds(47, 131, 548, 13);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(153, 51, 0));
		separator_1.setBackground(new Color(153, 51, 0));
		separator_1.setBounds(47, 512, 548, 13);

		getContentPane().add(btnNewButton);
		getContentPane().add(separator);
		getContentPane().add(separator_1);
	}
	
	@Override
	public ActionListener goBack() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home();
			}
		};
	}	
}
