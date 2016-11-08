public class Kasse {

  public static void main(String[] args) {
  	Kassenbon b = new Kassenbon( new Adresse("Herbstmesse Basel", "Uni Basel", "Petersplatz", "1", "4001", "Basel"));
  	b.add( new Artikel("Marroni",2,5.40));
  	b.add( new Artikel("Magebrot",5,1.10));
  	b.add( new Artikel("Glühwein",2,6));
  	b.print();
  }
}