public abstract class Knoten {
	
	int schluessel;
	public int getSchluessel () { return schluessel; }
	/* unused
	// Der übergeordnete Knoten, also der Knoten, an welchem dieser Knoten dranhängt.
	// Muss ein Innerer Knoten sein, denn ein Blatt kann ja kein Kind-Knoten mehr haben.
	// ACHTUNG: Kann null sein. Dann ist dieser Knoten die Wurzel des Suchbaumes.
	InnereKnoten parentKnoten;
	*/
	
	public Knoten (int schluessel) {
		this.schluessel = schluessel;
	}
	
}