public class Artikel {

	String product;
	int amount;
	float price;
	
	public Artikel(String product, int amount, double price) {
		this.product = product;
		this.amount = amount;
		this.price = (float)price;
	}
	
	public String printArtikel() {
 		String out = "";
 		out += product;
 		for (int i = 0; i < 16 - product.length(); i++) {
 			out += " ";
 		}
 		out += amount;
 		out += " x ";
 		out += Artikel.floatToString(price);
 		out += "\n";
 		for (int i = 0; i < 23; i++) {
 			out += " ";
 		}
 		if (amount * price < 10.0) out += " ";
 		out += Artikel.floatToString(amount * price);
 		return out;
 	}
  
  	public float getPrice() {
  		return price;
  	}
  	
  	public float getAmount() {
  		return amount;
  	}
  	
  	public static String floatToString(float f) {
  		String out = "";
  		out += (int)f;
  		out += ".";
  		if ((f - (int)f) == 0f) {
  			out += "00";
  		} else {
  			out += (int)((f - (int)f) * 100); 
  		}
  		return out;
  	}
  
}