package Ejercicio3.App.Views.Reservations;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Ejercicio3.App.Controllers.ReservationController;
import Ejercicio3.App.Elements.Button;
import Ejercicio3.App.Elements.Image;
import Ejercicio3.App.Elements.Label;
import Ejercicio3.App.Elements.TextField;
import Ejercicio3.App.Elements.Window;
import Ejercicio3.App.Elements.WindowBack;
import Ejercicio3.App.Models.Reservation;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ListReservations extends WindowBack {
	private JScrollPane listScroller = new JScrollPane();;
	private JList<Reservation> list = new JList<Reservation>();
	private final JLabel lblCantidadDePersonas = new JLabel("Cantidad de personas");
	private TextField txtQuantity;
	private JComboBox<String> cmbType = new JComboBox<String>();
	private JCheckBox chkWifi = new JCheckBox("WIFI");
	private JCheckBox chkBreakFast = new JCheckBox("Desayuno");
	private JCheckBox chkGym = new JCheckBox("Gimnasio");
	private JCheckBox chkGameRoom = new JCheckBox("Sala de Juegos");
	private final JLabel lblTipo = new JLabel("Tipo habitacion");
	
	public ListReservations() {
		this.setHeader("Lista de reservas");
		DefaultListModel<Reservation> dlist = new DefaultListModel<Reservation>();
		dlist.addAll(ReservationController.reservations);
		
		list.addListSelectionListener(this.onElementSelected());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(dlist);
        list.setLayoutOrientation(JList.VERTICAL);
        listScroller.setViewportView(list);
        listScroller.setBounds(47, 145, 546, 290);		
		JLabel lblID = new JLabel("0");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setBounds(83, 447, 47, 15);		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(57, 447, 25, 15);
		getContentPane().add(lblId);
		lblCantidadDePersonas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDePersonas.setBounds(124, 447, 175, 15);txtQuantity = new TextField(131, 161, 181, 19);
		txtQuantity.setBounds(289, 445, 59, 19);
		cmbType.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Triple", "Doble", "Cuadruple", "Suite "}));
		cmbType.setSelectedIndex(0);
		cmbType.setBounds(492, 442, 101, 24);
		Label lblType = new Label(330, 163, 66, 15, "Tipo de habitación");
		lblType.setBounds(265, 163, 131, 15);
		Label lblExtras = new Label(47, 223, 66, 15, "Servicios Adicionales");
		lblExtras.setBounds(47, 223, 148, 15);
		chkWifi.setBackground(Window.mainColor);
		chkWifi.setBounds(209, 219, 55, 23);
		chkBreakFast.setBackground(Window.mainColor);
		chkBreakFast.setBounds(270, 219, 96, 23);
		chkGym.setBackground(Window.mainColor);
		chkGym.setBounds(370, 219, 90, 23);
		chkGameRoom.setBackground(Window.mainColor);
		chkGameRoom.setBounds(464, 219, 131, 23);	
		

		getContentPane().add(listScroller);
		getContentPane().add(lblID);
		getContentPane().add(lblCantidadDePersonas);
		getContentPane().add(txtQuantity);
		getContentPane().add(cmbType);
		getContentPane().add(lblExtras);
		getContentPane().add(chkWifi);
		getContentPane().add(chkBreakFast);
		getContentPane().add(chkGym);
		getContentPane().add(chkGameRoom);
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setBounds(366, 447, 119, 15);
		
		getContentPane().add(lblTipo);

		this.setVisible(true);
	}
	
	private ListSelectionListener onElementSelected() {
		return new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			}
		};
	}
}
