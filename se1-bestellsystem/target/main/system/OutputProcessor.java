package system;

import java.util.List;

import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;

public class OutputProcessor implements Components.OutputProcessor {
	
	private InventoryManager inventoryManager;
	private OrderProcessor orderProcessor;
	long totalPrice;
	long singlePrice;

	OutputProcessor(InventoryManager inventoryManager, OrderProcessor orderProcessor) {
		this.inventoryManager = inventoryManager;
		this.orderProcessor = orderProcessor;
	}
	
	@Override
	public void printOrders(List<Order> orders, boolean printVAT) {
		StringBuffer sbAllOrdersStart = new StringBuffer(" ‐‐‐‐‐‐‐‐‐‐‐‐‐");
		StringBuffer sbAllOrders = new StringBuffer();
		StringBuffer sbLineItem = new StringBuffer();
		String currency = "EUR";
	

		for (Order o : orders) {
			Customer customer = o.getCustomer();
			String customerName = splitName( customer, singleName(customer));
			
			sbLineItem.append(" #" + o.getId() + ", " + customerName + "'s Bestellung: ");

			for (OrderItem oi : o.getItems()) {
				sbLineItem.append(oi.getUnitsOrdered() + "x " + oi.getDescription() + ", ");

			}
			sbLineItem.deleteCharAt(sbLineItem.length() - 2);

			for (OrderItem oi : o.getItems()) {

				singlePrice = singlePrice + (oi.getUnitsOrdered() * oi.getArticle().getUnitPrice());
				totalPrice = totalPrice + (oi.getUnitsOrdered() * oi.getArticle().getUnitPrice());
			}

			sbLineItem.append(fmtPrice(singlePrice, currency, 14));
			sbLineItem.append("\n");
			singlePrice = 0;
		}

		String fmtPriceTotal = fmtPrice(totalPrice, currency);
		sbAllOrders.append("\n").append(fmtLine(" ‐‐‐‐‐‐‐‐‐‐", " ‐‐‐‐‐‐‐‐‐‐", 500)).append("\n")
				.append(fmtLine(" Gesamtwert aller Bestellungen:", fmtPriceTotal, 50));

		System.out.println(sbAllOrdersStart.toString());
		System.out.print(sbLineItem.toString());
		System.out.println(sbAllOrders.toString());
	}
		
	

	@Override
	public void printInventory(boolean sortedByInventoryValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String fmtPrice(long price, String currency) {
		double ttp = totalPrice/100.00;
		String f = String.format("%1.2f", ttp);
		return f + " " + currency;
	}

	@Override
	public String fmtPrice(long price, String currency, int width) {
		//String s = ("%" + -width + "%d, %s");
		double sp = singlePrice/100.00;
		String f = String.format("%20.2f", sp);
		return f + " " + currency;
	}

	@Override
	public StringBuffer fmtLine(String leftStr, String rightStr, int width) {
		String s = String.format("%s %30s", leftStr, rightStr);
		StringBuffer sb = new StringBuffer(); 
//				sb.append(leftStr).append(rightStr);
				sb.append(s);
			return sb;
		
	}

	@Override
	public String splitName(Customer customer, String name) {
		String firstName;
		String lastName;
		//String name = firstName + lastName;
		
			if (name.contains(",")) { // Wenn ein Komma im String name enthalten ist, dann ist der Nachname vorne,
				lastName = name.substring(0, name.indexOf(","));
				firstName = name.substring(name.indexOf(",") + 1, name.length()).trim();
			} else {
				firstName = name.substring(0, name.lastIndexOf(" ")).trim();
				lastName = name.substring(name.lastIndexOf(" "), name.length()).trim();
			}
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		return  customer.getLastName() + ", "+ customer.getFirstName();
	}

	@Override
	public String singleName(Customer customer) {
			return customer.name;

	}

}
