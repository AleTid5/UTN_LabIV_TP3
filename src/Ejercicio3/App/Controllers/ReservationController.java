package Ejercicio3.App.Controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import Ejercicio3.App.Elements.TextField;
import Ejercicio3.App.Models.Reservation;

public class ReservationController extends Controller {
	public static List<Reservation> reservations = new ArrayList<Reservation>();
	
	public static final void validate(TextField value, String regex) {
		try {
			value.setBackground(Color.WHITE);
			assertOrFail(value.getText().trim().matches(regex), new Exception());
		} catch(Exception e) {
			setError(true);
			value.setBackground(Color.RED);
		}
	}
	
	public static final void save(int quantity, String selectedRoomType, Boolean withWifi, Boolean withBreakfast, Boolean withGym, Boolean withGameRoom) {
		Reservation reservation = new Reservation(quantity, selectedRoomType);
		reservation.addAdditionalService(withWifi);
		reservation.addAdditionalService(withBreakfast);
		reservation.addAdditionalService(withGym);
		reservation.addAdditionalService(withGameRoom);
		
		ReservationController.reservations.add(reservation);
	}
	
	public static final void clean(TextField txtQuantity, JComboBox<String> cmbType, JCheckBox chkWifi, JCheckBox chkBreakFast, JCheckBox chkGym, JCheckBox chkGameRoom) {
		txtQuantity.setBackground(Color.WHITE);
		txtQuantity.setText("");
		cmbType.setSelectedIndex(0);
		chkWifi.setSelected(false);
		chkBreakFast.setSelected(false);
		chkGym.setSelected(false);
		chkGameRoom.setSelected(false);
	}
}
