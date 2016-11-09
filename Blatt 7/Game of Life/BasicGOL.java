public class BasicGOL {
	
	public static void main (String[] args) throws InterruptedException {
		
		GameOfLife gol = new GameOfLife(6);
		
		while (true) {
			System.out.println(gol.toString());
			Thread.sleep(500);
			if(gol.update() == false) break;
		}
		System.out.println(gol.toString());
		
	}
	
}