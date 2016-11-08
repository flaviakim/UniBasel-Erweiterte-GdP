public class Adresse {

	String occasion;
	String location;
	String street;
	String number;
	String zip;
 	String city;
 	
 	public Adresse(String occasion, String location, String street, String number, String zip, String city) {
 		this.occasion = occasion;
 		this.location = location;
 		this.street = street;
 		this.number = number;
 		this.zip = zip;
 		this.city = city;
 	}
 	
 	public String printAdresse() {
 		String out = "";
 		out += "|==========================|";								//28
 		out += "\n";
 		out += "|    " + occasion + "     |";								//5, 6
 		out += "\n";
 		out += "|        " + location + "         |";						//9, 10
 		out += "\n";
 		out += "|      " + street + " " + number + "       |";				//7, 1, 8
 		out += "\n";
 		out += "|        " + zip + " " + city + "        |";				//9, 1, 9
 		out += "\n";
 		out += "|==========================|";								//28
 		return out;
 	}
 	
}