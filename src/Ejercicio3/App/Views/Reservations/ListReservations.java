package Ejercicio3.App.Views.Reservations;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import Ejercicio3.App.Controllers.ReservationController;
import Ejercicio3.App.Elements.Alert;
import Ejercicio3.App.Elements.WindowBack;
import Ejercicio3.App.Models.Reservation;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class ListReservations extends WindowBack {
	private JList<Reservation> list = new JList<Reservation>();
	
	public ListReservations() {
		this.setHeader("Lista de reservas");
		
		list.addListSelectionListener(this.onElementSelected());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Reservation> dlist = new DefaultListModel<Reservation>();
		dlist.addAll(ReservationController.reservations);
		list.setModel(dlist);
		list.setBounds(47, 145, 546, 290);
		getContentPane().add(list);

		this.setVisible(true);
	}
	
	private ListSelectionListener onElementSelected() {
		return new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				new Alert("sd", Integer.toString(list.getSelectedIndex()));				
			}
		};
	}
}
