package Ejercicio3.App.Models;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
	private static int uniqueId = 1;
	private int id;
	private int customerQuantity;
	private String roomType;
	private List<Boolean> additionalServices = new ArrayList<>();

	public Reservation(int customerQuantity, String roomType) {
		this.setId(Reservation.uniqueId++);
		this.setCustomerQuantity(customerQuantity);
		this.setRoomType(roomType);
	}

	public void addAdditionalService(Boolean service) {
		additionalServices.add(service);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerQuantity() {
		return customerQuantity;
	}

	public void setCustomerQuantity(int customerQuantity) {
		this.customerQuantity = customerQuantity;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return String.format("%d | %d | %s | %s - %s - %s - %s",
				this.getId(),
				this.getCustomerQuantity(),
				this.getRoomType(),
				(this.additionalServices.get(0) ? "✓" : "✘") + " WIFI",
				(this.additionalServices.get(1) ? "✓" : "✘") + " Desayuno",
				(this.additionalServices.get(2) ? "✓" : "✘") + " Gimnasio",
				(this.additionalServices.get(3) ? "✓" : "✘") + " Sala de juegos");
	}
}
