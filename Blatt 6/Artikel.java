public class Artikel {
	
	String name;
	int count;
	float price;
	
	
	public Artikel(String name, int count, float price) {
		
		this.name = name;
		this.count = count;
		this.price = price;
		
	}
	
	
	public float getSinglePrice() {
		return price;
	}
	
	public float getTotalPrice() {
		return price * count;
	}
	
	public String toString() {
		String out = "";
		
	}
	
}