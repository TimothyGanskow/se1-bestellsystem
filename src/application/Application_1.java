package application;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import datamodel.Article;
//import datamodel.Customer;
//import datamodel.Order;
//import datamodel.OrderItem;
//
//public class Application_1 {
//	long totalPrice;
//	long singlePrice;
//
//	public static void main(String[] args) {
//		System.out.println(" SE1 Bestellsystem");
//
//		Application_1 app = new Application_1();
//
//		Customer cEric = new Customer("C86516", "Eric Schulz‐Mueller", "eric2346@gmail.com");
//
//		Customer cAnne = new Customer("C64327", "Meyer, Anne", "+4917223524");
//
//		Customer cNadine = new Customer("C12396", "Nadine Ulla Blumenfeld", "+4915292454");
//
//		// neu Angelegte Customer
//		Customer cTimo = new Customer("C35812", "Timo Werner", "tw@gmail.com");
//
//		Customer cSandra = new Customer("C92341", "Sandra Müller", "samue62@gmx.de");
//
//		Article aTasse = new Article("SKU‐458362", "Tasse", 299, 2000);
//
//		Article aBecher = new Article("SKU‐693856", "Becher", 149, 8400);
//
//		Article aKanne = new Article("SKU‐518957", "Kanne", 2000, 2400);
//
//		Article aTeller = new Article("SKU‐638035", "Teller", 649, 7000);
//
//		// Neu Angelegte Artikle
//
//		Article aKaffeMaschine = new Article("SKU‐638111", "Kaffemaschine", 2999, 500);
//
//		Article aTeeKocher = new Article("SKU‐998035", "Teekocher", 1999, 2000);
//
//		// Eric's 1st order
//		Order o5234 = new Order(5234968294L, new Date(), cEric);
//		OrderItem oi1 = new OrderItem(aKanne.getDescription(), aKanne, 1);
//		o5234.addItem(oi1); // add OrderItem to Order 5234968294L
//
//		// Eric's 2nd order
//		Order o8592 = new Order(8592356245L, new Date(), cEric);
//		o8592.addItem( // add three OrderItems to Order 8592356245L
//				new OrderItem(aTeller.getDescription(), aTeller, 4) // 4x Teller
//		);
//		o8592.addItem(new OrderItem(aBecher.getDescription(), aBecher, 8) // 8x Becher
//		);
//		o8592.addItem(new OrderItem("passende Tassen", aTasse, 4) // 4x passende Tassen
//		);
//
//		// Anne's order
//		Order o3563 = new Order(3563561357L, new Date(), cAnne);
//		o3563.addItem(new OrderItem(aKanne.getDescription() + " aus Porzellan", aKanne, 1));
//
//		// Nadine's order
//		Order o6135 = new Order(6135735635L, new Date(), cNadine);
//		o6135.addItem(new OrderItem(aTeller.getDescription() + " blau/weiss Keramik", aTeller, 12));
//
//		// Timo's order
//		Order o1135 = new Order(6135123635L, new Date(), cTimo);
//		o1135.addItem(new OrderItem(aKaffeMaschine.getDescription(), aKaffeMaschine, 1));
//		o1135.addItem(new OrderItem(aTasse.getDescription(), aTasse, 6));
//
//		
//Order o2222 = new Order(2225735635L, new Date(), cSandra);
//		o2222.addItem(new OrderItem(aTeeKocher.getDescription(), aTeeKocher, 1));
//		o2222.addItem(new OrderItem(aBecher.getDescription(), aBecher, 4));
//		o2222.addItem(new OrderItem(aTeller.getDescription(), aTeller, 4));
//		List<Order> orders = new ArrayList<Order>(List.of(o5234, o8592, o3563, o6135, o1135, o2222));
//		app.printOrders(orders); // Ausgabe aller Bestellungen
//	}
//
//	private void printOrders(List<Order> orders) {
//
//		StringBuffer sbAllOrdersStart = new StringBuffer(" ‐‐‐‐‐‐‐‐‐‐‐‐‐");
//		StringBuffer sbAllOrders = new StringBuffer();
//		StringBuffer sbLineItem = new StringBuffer();
//
//		for (Order o : orders) {
//			sbLineItem.append(" #" + o.getId() + ", " + o.getCustomer().getFirstName() + "'s Bestellung: ");
//
//			for (OrderItem oi : o.getItems()) {
//				sbLineItem.append(oi.getUnitsOrdered() + "x " + oi.getDescription() + ", ");
//
//			}
//			sbLineItem.deleteCharAt(sbLineItem.length() - 2);
//
//			for (OrderItem oi : o.getItems()) {
//
//				singlePrice = singlePrice + (oi.getUnitsOrdered() * oi.getArticle().getUnitPrice());
//				totalPrice = totalPrice + (oi.getUnitsOrdered() * oi.getArticle().getUnitPrice());
//			}
//
//			sbLineItem.append(pad(fmtPrice(singlePrice, "", " EUR"), 14, true));
//			sbLineItem.append("\n");
//			singlePrice = 0;
//		}
//
//		String fmtPriceTotal = pad(fmtPrice(totalPrice, " ", " EUR"), 14, true);
//		sbAllOrders.append("\n").append(fmtLine(" ‐‐‐‐‐‐‐‐‐‐", "‐‐‐‐‐‐‐‐‐‐ ‐‐‐‐‐‐‐‐‐‐", 100)).append("\n")
//				.append(fmtLine(" Gesamtwert aller Bestellungen:", fmtPriceTotal, 100));
//
//		System.out.println(sbAllOrdersStart.toString());
//		System.out.print(sbLineItem.toString());
//		System.out.println(sbAllOrders.toString());
//	}
//
//	private String fmtLine(String string, String string2, int i) {
//		return String.format("%s %1s", string, string2);
//	}
//
//	private String pad(String fmtPrice, int distance, boolean b) {
//		String s = ("%" + -distance + "s");
//		return String.format(s, fmtPrice);
//	}
//
//	private String fmtPrice(long totalPrice, String space, String currency) {
//		double ttp = totalPrice / 100.00;
//		return String.format("%50.2f", ttp) + space + currency;
//	}
//
//}
