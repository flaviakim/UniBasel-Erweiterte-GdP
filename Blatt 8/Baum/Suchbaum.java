public class Suchbaum {
	
	Knoten wurzel;
	public Knoten getWurzel() { return wurzel; }
	
	
	public Suchbaum () {
		wurzel = null; // Ist eigentlich schon null, nur zur Klarheit.
	}
	
	public Suchbaum (Knoten wurzel) {
		this.wurzel = wurzel;
	}
	
	
	public void einfügen (int s, String w) {
		// Wenn der Baum noch leer ist, fügen wir das erste Blatt als Wurzel ein.
		if (wurzel == null) {
			wurzel = new Blatt (s, w);
			return;
		}
		
		// Der Baum hat schon Werte. Wir müssen solange von innerem Knoten zu
		// innerem Knoten gehen, bis wir am richtigen Ort angelangt sind.
		
		// In dieser Variable ist der Knoten gespeichert, den wir gerade anschauen.
		Knoten aktuellerKnoten = wurzel;
		InnereKnoten parentKnoten = null;
		
		while (true) {
			
			// Ist der aktuelle Knoten ein Blatt, wissen wir, dass wir am Ziel angekommen sind.
			// Jetzt wollen wir an dieser Stelle statt dem Blatt ein neuer innerer Knoten erstellen
			// und diesem links und rechts (je nach Werte) das alte Blatt und ein neues Blatt
			// mit den einzufügenden Werten erstellen.
			if (aktuellerKnoten instanceof Blatt) {
				Blatt aktuellesBlatt = (Blatt)aktuellerKnoten;
						
				// Sind die Werte gleich geben wir einfach einen Error aus.
				if (aktuellerKnoten.schluessel == s) {
					System.out.println("ERROR: Suchbaum::einfügen -- Schlüssel bereits vorhanden!");
					return;
				}
		
				// Speichere die beiden Blätter je nach ihrem Wert als linkes und rechtes Blatt.
				Blatt linkesBlatt;
				Blatt rechtesBlatt;
				if (aktuellesBlatt.schluessel > s) {
					linkesBlatt = new Blatt(s, w);
					rechtesBlatt = aktuellesBlatt;
				} else {
					rechtesBlatt = new Blatt(s, w);
					linkesBlatt = aktuellesBlatt;
				}
		
				// Erstelle einen neuen Inneren Knoten mit dem Schlüssel des linken (kleineren)
				// Blatts und füge die beiden Blätter als linker und rechter Knoten an.
				InnereKnoten neuerKnoten = new InnereKnoten(linkesBlatt.getSchluessel(), linkesBlatt, rechtesBlatt);
				
				// Den neuen Knoten müssen wir jetzt noch dort anhängen, wo momentan
				// immernoch das Blatt hängt, also am parentKnoten.
				// Zuerst testen wir aber, ob dieser null ist, denn dan müssten wir den
				// neuen Knoten als wurzel in diesen Suchbaum speichern
				if (parentKnoten == null) {
					wurzel = neuerKnoten;
					return;
				}
				
				if (parentKnoten.getLinkesKind() == aktuellerKnoten) {
					parentKnoten.setLinkesKind(neuerKnoten);
				} else {
					parentKnoten.setRechtesKind(neuerKnoten);
				}
		
				// Das wars, jetzt haben wir das Blatt an einem neuen Knoten und diesen
				// an der richtigen Stelle angehängt.
				return;
		
			} else {
				// Der aktuelle Knoten ist ein Innerer Knoten und hat bereits zwei Kind-Knoten.
				
				// Zuerst aktualisieren wir den parentKnoten als den aktuellen Knoten,
				// der ja jetzt klar ein Innerer Knoten ist.
				parentKnoten = (InnereKnoten)aktuellerKnoten;
				
				// Dann schauen wir, ob wir in den linken oder rechten Knoten müssen.
				if (aktuellerKnoten.getSchluessel() > s) {
					aktuellerKnoten = parentKnoten.getLinkesKind();
				} else {
					aktuellerKnoten = parentKnoten.getRechtesKind();
				}
				
			}
			
		}
		
	}
	
	public String suche (int s) {
		// Damit wir die nicht überall umschreiben müssen.
		String notFoundMessage = "Schlüssel " + s + " wurde nicht gefunden!";
		
		// Falls der Baum nur ein Blatt hat oder ganz leer ist. 
		if (wurzel == null) return notFoundMessage;
		if (wurzel instanceof Blatt) {
			if (wurzel.getSchluessel() == s) {
				return ((Blatt)wurzel).getWert();
			} else {
				return notFoundMessage;
			}
		}
		
		// Die wurzel ist jetzt sicher ein Innerer Knoten. Jetzt suchen wir, solange, bis
		// wir auf ein Blatt treffen.
		
		InnereKnoten aktuellerKnoten = (InnereKnoten)wurzel;
		
		while (true) {
			if (aktuellerKnoten.getSchluessel() >= s) {
				// links weiter
				if (aktuellerKnoten.getLinkesKind() instanceof Blatt) {
					// Wir sind auf ein Blatt gestossen! Hat es den gewünschten Schlüssel
					// geben wir dessen Wert zurück, andernfalls gibt es den Schlüssel nicht.
					// (Ausser wir haben beim Einfügen einen Fehler gemacht und ein Blatt
					// an der falschen Stelle eingefügt)
					Blatt b = (Blatt)aktuellerKnoten.getLinkesKind();
					if (b.getSchluessel() == s) return b.getSchluessel() + " hat den Wert " + b.getWert();
					return notFoundMessage;
					
				} else {
					// Es ist ein weiterer Innerer Knoten. Wir machen den Loop nochmals
					// mit dem neuen Inneren Knoten als aktuellen Knoten.
					aktuellerKnoten = (InnereKnoten)aktuellerKnoten.getLinkesKind();
					continue;
				}
				
			} else {
				// rechts weiter
				// (genau dasselbe wie oben, einfach mit dem nazi Kind statt dem kommunisten Kind)
				if (aktuellerKnoten.getRechtesKind() instanceof Blatt) {
					// Wir sind auf ein Blatt gestossen! Hat es den gewünschten Schlüssel
					// geben wir dessen Wert zurück, andernfalls gibt es den Schlüssel nicht.
					// (Ausser wir haben beim Einfügen einen Fehler gemacht und ein Blatt
					// an der falschen Stelle eingefügt)
					Blatt b = (Blatt)aktuellerKnoten.getRechtesKind();
					if (b.getSchluessel() == s) return b.getSchluessel() + " hat den Wert " + b.getWert();
					return notFoundMessage;
					
				} else {
					// Es ist ein weiterer Innerer Knoten. Wir machen den Loop nochmals
					// mit dem neuen Inneren Knoten als aktuellen Knoten.
					aktuellerKnoten = (InnereKnoten)aktuellerKnoten.getRechtesKind();
					continue;
				}
			}
			
		}
	}
	
}