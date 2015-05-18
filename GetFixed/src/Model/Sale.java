package Model;

import java.text.*;
import java.util.*;

public class Sale {

	private int id;
	private String date;
	private Customer customer;
	private double totalPrice;

	public Sale() {

	}

	public Sale(int id, Customer customer) {
		this.id = id;
		date = createDate();
		this.customer = customer;
		totalPrice = getTotalPrice();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String createDate() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFormat = new Date();
		String stringDate = sdf.format(dateFormat);
		return stringDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}