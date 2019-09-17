package Ejercicio3.App.Views.Reservations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import Ejercicio3.App.Controllers.ReservationController;
import Ejercicio3.App.Elements.Alert;
import Ejercicio3.App.Elements.Button;
import Ejercicio3.App.Elements.Image;
import Ejercicio3.App.Elements.Label;
import Ejercicio3.App.Elements.TextField;
import Ejercicio3.App.Elements.Window;
import Ejercicio3.App.Elements.WindowBack;
import Ejercicio3.App.Interfaces.IForm;

@SuppressWarnings("serial")
public class AddReservation extends WindowBack implements IForm {
	private TextField txtQuantity;
	private JComboBox<String> cmbType = new JComboBox<String>();
	private JCheckBox chkWifi = new JCheckBox("WIFI");
	private JCheckBox chkBreakFast = new JCheckBox("Desayuno");
	private JCheckBox chkGym = new JCheckBox("Gimnasio");
	private JCheckBox chkGameRoom = new JCheckBox("Sala de Juegos");
	public AddReservation() {
		this.setHeader("Agregar reserva");
		
		Label lblQuantity = new Label(47, 163, 66, 15, "Cantidad");
		txtQuantity = new TextField(131, 161, 181, 19);
		txtQuantity.setBounds(131, 161, 116, 19);
		txtQuantity.requestFocus();
		Label lblType = new Label(330, 163, 66, 15, "Tipo de habitación");
		lblType.setBounds(265, 163, 131, 15);
		Label lblExtras = new Label(47, 223, 66, 15, "Servicios Adicionales");
		lblExtras.setBounds(47, 223, 148, 15);
		Button btnCheck = new Button(570, 261, 24, 24, "Validar Formulario", new Image("check.png", 310, 537, 50, 50), this.submit());
		Button btnClean = new Button(47, 261, 24, 24, "Limpiar Formulario", new Image("trash.png", 310, 537, 50, 50), this.clean());
		chkWifi.setBackground(Window.mainColor);
		chkWifi.setBounds(209, 219, 55, 23);
		chkBreakFast.setBackground(Window.mainColor);
		chkBreakFast.setBounds(270, 219, 96, 23);
		chkGym.setBackground(Window.mainColor);
		chkGym.setBounds(370, 219, 90, 23);
		chkGameRoom.setBackground(Window.mainColor);
		chkGameRoom.setBounds(464, 219, 131, 23);		
		cmbType.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Triple", "Doble", "Cuadruple", "Suite "}));
		cmbType.setSelectedIndex(0);
		cmbType.setBounds(414, 158, 180, 24);
		

		getContentPane().add(lblQuantity);
		getContentPane().add(txtQuantity);
		getContentPane().add(lblType);
		getContentPane().add(cmbType);
		getContentPane().add(lblExtras);
		getContentPane().add(btnCheck);
		getContentPane().add(btnClean);
		getContentPane().add(chkWifi);
		getContentPane().add(chkBreakFast);
		getContentPane().add(chkGym);
		getContentPane().add(chkGameRoom);
		
		this.setVisible(true);
	}

	@Override
	public ActionListener submit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationController.setError(false);
				ReservationController.validate(txtQuantity, "[1-5]");
				
				if (ReservationController.hasError()) return;
				
				ReservationController.save(Integer.parseInt(txtQuantity.getText()),
						cmbType.getSelectedItem().toString(),
						chkWifi.isSelected(),
						chkBreakFast.isSelected(),
						chkGym.isSelected(),
						chkGameRoom.isSelected());

				new Alert("Creación exitosa", "La reserva se ha creado exitosamente!");
				ReservationController.clean(txtQuantity, cmbType, chkWifi, chkBreakFast, chkGym, chkGameRoom);
				txtQuantity.requestFocus();
			}
		};
	}

	@Override
	public ActionListener clean() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationController.clean(txtQuantity, cmbType, chkWifi, chkBreakFast, chkGym, chkGameRoom);
			}
		};
	}
}
