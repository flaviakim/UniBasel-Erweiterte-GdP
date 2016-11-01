import java.util.*;

public class Kassenbon {
	
	
	// Felder
	final int TOTAL_WIDTH = 28; 
	
	Adresse adresse;
	List<Artikel> artikel;
	
	
	// Konstruktor
	
	public Kassenbon (Adresse adr) {
		adresse = adr;
		artikel = new ArrayList<Artikel>();
	}
	
	
	// Methoden
	
	public void add(Artikel art) {
		artikel.add(art);
	}
	
	public void print() {
		String out = "";
		out += adresse.toString();
		out += "\n"
		for (int i = 0; i < artikel.length(); i++) {
			out += artikel.toString();
		}
		out += "\n"
		for (int i = 0; i < TOTAL_WIDTH; i++) {
			out += "-";
		}
		
		out += "Total";
		for (int i = 0; i < (TOTAL_WIDTH - 5 - total().length); i++) {
			out += " ";
		}
		out += total();
		out += "\n";
		for (int i = 0; i < TOTAL_WIDTH; i++) {
			out += "=";
		}
		
	}
	
	/**
	 *	Returns the total price as a String.
	 */
	public String total() {
		return "28.30";
	}
	
}