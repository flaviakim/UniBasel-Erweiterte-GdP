public class InnereKnoten extends Knoten {
	
	// Kleiner Gleich dem Schlüssel in diesem Knoten.
	Knoten linkesKind;
	public Knoten getLinkesKind () { return linkesKind; }
	public void setLinkesKind (Knoten lk) { linkesKind = lk; }
	
	// Grösser dem Schlüssel in diesem Knoten.
	Knoten rechtesKind;
	public Knoten getRechtesKind () { return rechtesKind; }
	public void setRechtesKind (Knoten rk) { rechtesKind = rk; }
	
	
	public InnereKnoten (int schluessel, Knoten linkesKind, Knoten rechtesKind) {
		super(schluessel);
		this.linkesKind = linkesKind;
		this.rechtesKind = rechtesKind;
	}
	
}