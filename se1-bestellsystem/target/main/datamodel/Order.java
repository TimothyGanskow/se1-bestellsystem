package datamodel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private final long id;
	private final Date date;
	private final Customer customer;
	private final List<OrderItem> items = new ArrayList<>();

	protected Order(long id, Date date, Customer customer) {
		this.id = id;
		this.date = date;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public Date getDate() {
		if (this.date != null) {
		return date;
		} else {
			return new Date();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Order addItem(OrderItem o) {
		if (!this.items.contains(o)) {
		if(o != null) {
		items.add(o);
		}}
		return new Order(this.id, this.date, this.customer);
	}

	public Order removeItem(OrderItem o) {
		items.remove(o);
		return new Order(this.id, this.date, this.customer);
	}

	public Order cleareItems() {
		items.removeAll(items);
		return new Order(this.id, this.date, this.customer);
	}

	public Object count() {
		//clearItems();
		return items.size();
	}



}
