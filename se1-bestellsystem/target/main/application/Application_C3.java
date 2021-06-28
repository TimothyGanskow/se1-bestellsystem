package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datamodel.Article;
import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;
import system.ComponentFactory;

import system.OrderProcessor;
import system.OutputProcessor;
import system.*;

public final class Application_C3 {
	public static void main( String[] args ) {
	    System.out.println( "SE1‐Bestellsystem" );
	    ComponentFactory componentFactory = ComponentFactory.getInstance();
	    DataFactory dataFactory = componentFactory.getDataFactory();
	    
	    OutputProcessor outputProcessor =  
	    		componentFactory.getOutputProcessor();
	    
	    OrderProcessor orderProcessor =
	componentFactory.getOrderProcessor();

	    
	 //   DataFactory dataFactory = componentFactory.getDataFactory();
	    /*
	     * Erzeugung der Kunden, Artikel und Bestellungen über die DataFactory...
	     */
	    Customer cEric = dataFactory.createCustomer( "Eric Schulz‐Mueller",  
	"eric2346@gmail.com" );
	    Customer cAnne = dataFactory.createCustomer( "Meyer, Anne", "+4917223524" );
		Customer cNadine =dataFactory.createCustomer("Nadine Ulla Blumenfeld", "+4915292454");

		// neu Angelegte Customer
		Customer cTimo = dataFactory.createCustomer("Timo Werner", "tw@gmail.com");

		Customer cSandra = dataFactory.createCustomer("Sandra Müller", "samue62@gmx.de");
	    
	    
	    
	    
	    Article aTasse = dataFactory.createArticle( "Tasse", 299, 2000 );
	    Article aBecher = dataFactory.createArticle( "Becher", 149, 8400 );
	    Article aKanne = dataFactory.createArticle("Kanne", 2000, 2400);
		Article aTeller = dataFactory.createArticle("Teller", 649, 7000);

		// Neu Angelegte Artikle

		Article aKaffeMaschine = dataFactory.createArticle("Kaffemaschine", 2999, 500);

		Article aTeeKocher = dataFactory.createArticle("Teekocher", 1999, 2000);

	    // Eric's 1st order
	    Order o5234 = dataFactory.createOrder( cEric );
	    OrderItem oi1 = dataFactory.createOrderItem(
	aKanne.getDescription(), aKanne, 1 ); // 1x Kanne
	    o5234.addItem( oi1 );
	    
	 // Eric's 2nd order
	 		Order o8592 = dataFactory.createOrder( cEric );
	 		OrderItem oi2 = dataFactory.createOrderItem(aTeller.getDescription(), aTeller, 4);
	 		OrderItem oi3 =	dataFactory.createOrderItem(aBecher.getDescription(), aBecher, 8);
	 		OrderItem oi4 = dataFactory.createOrderItem("passende Tassen", aTasse, 4);
	 		o8592.addItem( oi2 );
	 		o8592.addItem( oi3 );
	 		o8592.addItem( oi4 );
	 		//// Annes order
	 		Order o3563 = dataFactory.createOrder(cAnne);
			OrderItem oi5 = dataFactory.createOrderItem(aKanne.getDescription() + " aus Porzellan", aKanne, 1);
			o3563.addItem(oi5);
	 		/// Nadines order
			Order o6135 = dataFactory.createOrder(cNadine);
			OrderItem oi6 = dataFactory.createOrderItem(aTeller.getDescription() + " blau/weiss Keramik", aTeller, 12);
			o6135.addItem(oi6);
			////Timos order
			Order o1135 = dataFactory.createOrder(cTimo);
			OrderItem oi7 = dataFactory.createOrderItem(aKaffeMaschine.getDescription(), aKaffeMaschine, 1);
			OrderItem oi8 = dataFactory.createOrderItem(aTasse.getDescription(), aTasse, 6);
			o1135.addItem(oi7);
			o1135.addItem(oi8);
			////Sandras order
			Order o2222 = dataFactory.createOrder(cSandra);
			OrderItem oi9 = dataFactory.createOrderItem(aTeeKocher.getDescription(), aTeeKocher, 1);
			OrderItem oi10 = dataFactory.createOrderItem(aBecher.getDescription(), aBecher, 4);
			OrderItem oi11 = dataFactory.createOrderItem(aTeller.getDescription(), aTeller, 4);
			o2222.addItem(oi9);
			o2222.addItem(oi10);
			o2222.addItem(oi11);
			
			
	    List<Order> orders = new ArrayList<Order>( List.of( o5234, o8592, o3563, o6135, o1135,o2222) );
	    outputProcessor.printOrders( orders, false ); // Ausgabe aller Bestellungen
	  }
	}
