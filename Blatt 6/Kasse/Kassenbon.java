import java.util.ArrayList;

public class Kassenbon {

	ArrayList<Artikel> artikelliste = new ArrayList<Artikel>();
	Adresse adresse;
	
	public Kassenbon (Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void add(Artikel a) {
		artikelliste.add(a);
	}
	
	public float total() {
  		float total = 0;
  		for (int i = 0; i < artikelliste.size(); i++) {
  			total += artikelliste.get(i).getPrice() * artikelliste.get(i).getAmount(); 
  		}	
  		return total;
  	}
	
	public void print() {
		String out = "";
 		out += adresse.printAdresse();
 		out += "\n";
 		out += "\n";
 		for (int i = 0; i < artikelliste.size(); i++) {
  			out += artikelliste.get(i).printArtikel();
  			out += "\n";
  		}	
  		out += "\n";
 		out += "----------------------------";	//28
 		out += "\n";
 		out += "Total                  " + total() + "0";	//18
 		out += "\n";
 		out += "============================";	//28 
 		System.out.println(out);
 	}

}