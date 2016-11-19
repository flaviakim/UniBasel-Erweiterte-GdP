public class Test {
	
	static Suchbaum baum = new Suchbaum();
	
	public static void main (String[] args) {
		
		baum.einfügen (3920, "Zermatt");
		baum.einfügen (3215, "Gempenach");
		baum.einfügen (4000, "Basel");
		baum.einfügen (4312, "Magden");
		baum.einfügen (7436, "Medels");
		baum.einfügen (3800, "Interlaken");
		
		
		System.out.println(baum.suche(3920));
		System.out.println(baum.suche(3215));
		System.out.println(baum.suche(4000));
		System.out.println(baum.suche(4312));
		System.out.println(baum.suche(7436));
		System.out.println(baum.suche(3800));
		System.out.println(baum.suche(5555));	// muss nicht gefunden ausgeben!
		System.out.println(baum.suche(1));		// muss nicht gefunden ausgeben!
		System.out.println(baum.suche(9999));	// muss nicht gefunden ausgeben!
		
		
	}
	
}