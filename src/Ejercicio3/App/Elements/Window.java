package Ejercicio3.App.Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ejercicio3.App.Interfaces.IApp;
import Ejercicio3.App.Interfaces.INavBar;
import Ejercicio3.App.Views.Reservations.AddReservation;
import Ejercicio3.App.Views.Reservations.ListReservations;

@SuppressWarnings("serial")
public class Window extends JFrame implements INavBar, IApp {	
	public Window() {
		getContentPane().setFont(new Font("Khmer OS System", Font.PLAIN, 11));
		getContentPane().setBackground(Window.mainColor);
		setTitle("TP3 | ");
		setBackground(Color.DARK_GRAY);
		setSize(650, 650);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Khmer OS", Font.BOLD, 11));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menú principal");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmEjercicio = new JMenuItem("Agregar reserva");
		mntmEjercicio.addActionListener(this.AddReservation());
		mnNewMenu.add(mntmEjercicio);
		
		JMenuItem mntmEjercicio_1 = new JMenuItem("Listado de reserva");
		mntmEjercicio_1.addActionListener(this.ListReservations());
		mnNewMenu.add(mntmEjercicio_1);

		getContentPane().setLayout(null);
		getContentPane().add(new Image("utn.png", 478, 12, 160, 50));
	}

	@Override
	public ActionListener AddReservation() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddReservation();
			}
		};
	}

	@Override
	public ActionListener ListReservations() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ListReservations();
			}
		};		
	}
	
	public ActionListener exit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
	}
	
	/**
	 * Establece el titulo en cada pantalla.
	 * Es protected para que cada clase derivada la vea como private.
	 * @param title
	 */
	protected void setHeader(String title) {
		this.setTitle(this.getTitle() + title);
	}
	
}
