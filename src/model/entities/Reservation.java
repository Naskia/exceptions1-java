package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	protected Integer roomNumber;
	protected Date checkin;
	protected Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diference = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diference, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		if (duration() > 1) {
			return "Room " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout)
				+ ", " + duration() + " nights";
		} else {
			return "Room " + roomNumber + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout)
				+ ", " + duration() + " night";
		}

	}

}
