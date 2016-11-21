import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GOLFenster extends Component {
	
	// The speed in milliseconds per update.
	int UPDATE_SPEED = 2000;
	// The number of pixels for one Cell.
	int CELL_SIZE = 20;
	
	GameOfLife game;
	int gameSize
	
	JFrame frame;
	
	// This updates the Game.
	Timer timer;
	
	
	public GOLFenster (GameOfLife game) {
		this.game = game;
		gameSize = game.getSize();
		
		frame = new JFrame();
		frame.add(this);
		frame.setSize(gameSize * CELL_SIZE, gameSize * CELL_SIZE);
        frame.setTitle("Game of Life");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		timer = new Timer(UPDATE_SPEED, this);
		timer.start();
	}
	
	
	public void paint(Graphics g) {
		for (int x = 0; x < gameSize; x++) {
			for (int y = 0; y < gameSize; y++) {
				if (game.getFieldAt(x, y) {
					drawSquare(x, y);
				}
			}
		}
	}
	
	void drawSquare(x, y) {
		for (int i = 0; i < CELL_SIZE; i++) {
			for (int j = 0; j < CELL_SIZE; j++) {
				// TODO: Check real method
				setPixel( (x*CELL_SIZE) + i, (y*CELL_SIZE) + j);
			}
		}
	}
	
	public Dimension getPreferredSize() {
		return gameSize * CELL_SIZE;
	}
	
	public void redraw() {
		
	}
	
}