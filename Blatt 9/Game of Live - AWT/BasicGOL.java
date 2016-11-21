public class BasicGOL {
	
	public static void main (String[] args) throws InterruptedException {
		
		GameOfLife game = new GameOfLife(6);
		GOLFenster window = new GOLFenster(game);
		
	}
	
}