package Ejercicio3.App.Views.Reservations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Ejercicio3.App.Controllers.ReservationController;
import Ejercicio3.App.Elements.Alert;
import Ejercicio3.App.Elements.Button;
import Ejercicio3.App.Elements.Image;
import Ejercicio3.App.Elements.Label;
import Ejercicio3.App.Elements.TextField;
import Ejercicio3.App.Elements.Window;
import Ejercicio3.App.Elements.WindowBack;
import Ejercicio3.App.Models.Reservation;
import java.awt.Color;

@SuppressWarnings("serial")
public class ListReservations extends WindowBack {
	private JScrollPane listScroller = new JScrollPane();;
	private JList<Reservation> list = new JList<Reservation>();
	private final JLabel lblCantidadDePersonas = new Label(124, 447, 175, 15, "Cantidad de personas");
	private TextField txtQuantity = new TextField(289, 445, 59, 19);
	private JComboBox<String> cmbType = new JComboBox<String>();
	private JCheckBox chkWifi = new JCheckBox("WIFI");
	private JCheckBox chkBreakFast = new JCheckBox("Desayuno");
	private JCheckBox chkGym = new JCheckBox("Gimnasio");
	private JCheckBox chkGameRoom = new JCheckBox("Sala de Juegos");
	private JLabel lblTipo = new Label(366, 447, 119, 15, "Tipo habitacion");
	private JLabel lblID = new Label(83, 447, 47, 15, "0");
	private JLabel lblId = new Label(50, 447, 25, 15, "ID:");
	private Button btnEdit = new Button(124, 474, 24, 24, "Confirmar edición de reserva", new Image("edit.png", 310, 537, 50, 50), this.onElementEdit());
	private Button btnRemove = new Button(50, 474, 24, 24, "Remover reserva", new Image("trash.png", 300, 537, 50, 50), this.onElementRemove());
	
	public ListReservations() {
		this.setHeader("Lista de reservas");
		cmbType.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Triple", "Doble", "Cuadruple", "Suite "}));
		cmbType.setSelectedIndex(0);
		cmbType.setBounds(492, 442, 101, 24);
		chkWifi.setBackground(Window.mainColor);
		chkWifi.setBounds(209, 474, 55, 23);
		chkBreakFast.setBackground(Window.mainColor);
		chkBreakFast.setBounds(268, 474, 96, 23);
		chkGym.setBackground(Window.mainColor);
		chkGym.setBounds(368, 474, 90, 23);
		chkGameRoom.setBackground(Window.mainColor);
		chkGameRoom.setBounds(462, 474, 131, 23);
		DefaultListModel<Reservation> dlist = new DefaultListModel<Reservation>();
		dlist.addAll(ReservationController.reservations);
		list.setBackground(new Color(239, 156, 185));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(dlist);
		list.setLayoutOrientation(JList.VERTICAL);
		listScroller.setViewportView(list);
		listScroller.setBounds(47, 145, 546, 290);
		list.addListSelectionListener(this.onElementSelected());

		getContentPane().add(lblId);
		getContentPane().add(lblID);
		getContentPane().add(lblCantidadDePersonas);
		getContentPane().add(txtQuantity);
		getContentPane().add(cmbType);
		getContentPane().add(chkWifi);
		getContentPane().add(chkBreakFast);
		getContentPane().add(chkGym);
		getContentPane().add(chkGameRoom);		
		getContentPane().add(lblTipo);
		getContentPane().add(btnEdit);
		getContentPane().add(btnRemove);
		getContentPane().add(listScroller);
		
		ReservationController.changeVisibility(false, lblId, lblID, lblCantidadDePersonas, txtQuantity, cmbType,
											   chkWifi, chkBreakFast, chkGym, chkGameRoom, lblTipo, btnEdit, btnRemove);

		this.setVisible(true);
	}
	
	private ListSelectionListener onElementSelected() {
		return new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Reservation reservation = list.getSelectedValue();
				
				if (reservation == null) return;
				
				lblID.setText(Integer.toString(reservation.getId()));
				txtQuantity.setText(Integer.toString(reservation.getCustomerQuantity()));
				cmbType.setSelectedItem(reservation.getRoomType());
				chkWifi.setSelected(reservation.getAdditionalServices().get(0));
				chkBreakFast.setSelected(reservation.getAdditionalServices().get(1));
				chkGym.setSelected(reservation.getAdditionalServices().get(2));
				chkGameRoom.setSelected(reservation.getAdditionalServices().get(3));
				
				ReservationController.changeVisibility(true, lblId, lblID, lblCantidadDePersonas, txtQuantity, cmbType,
						   chkWifi, chkBreakFast, chkGym, chkGameRoom, lblTipo, btnEdit, btnRemove);
			}
		};
	}
	
	private ActionListener onElementEdit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ReservationController.setError(false);
				ReservationController.validate(txtQuantity, "[1-5]");
				
				if (ReservationController.hasError()) return;
				
				ReservationController.edit(list.getSelectedValue(),
						Integer.parseInt(txtQuantity.getText()),
						cmbType.getSelectedItem().toString(),
						chkWifi.isSelected(),
						chkBreakFast.isSelected(),
						chkGym.isSelected(),
						chkGameRoom.isSelected());

				new Alert("Edición exitosa", "La reserva se ha editado exitosamente!");
				
				listScroller.repaint(); // Simula reactividad
			}
		};
	}
	
	private ActionListener onElementRemove() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationController.reservations.remove(list.getSelectedValue());

				new Alert("Eliminación exitosa", "La reserva se ha eliminado exitosamente!");
				
				ReservationController.changeVisibility(false, lblId, lblID, lblCantidadDePersonas, txtQuantity, cmbType,
						   chkWifi, chkBreakFast, chkGym, chkGameRoom, lblTipo, btnEdit, btnRemove);
				
				DefaultListModel<Reservation> dlist = new DefaultListModel<Reservation>();
				dlist.addAll(ReservationController.reservations);
				list.setModel(dlist);
			}
		};
	}
}
