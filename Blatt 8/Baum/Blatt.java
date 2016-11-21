public class Blatt extends Knoten {
	
	String wert;
	public String getWert() { return wert; }
	
	public Blatt (int schluessel, String wert) {
		super(schluessel);
		this.wert = wert;
	}
	
	
}