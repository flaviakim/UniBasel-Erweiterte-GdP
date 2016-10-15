import ch.unibas.informatik.cs101.ImageWindow;

public class BasicTurtle {
	
	public static void main(String args[]) {
		
		ImageWindow w = new ImageWindow(500,500);
		w.openWindow();
		
		
		// TURTLE 1
		
		Turtle t1 = new Turtle(w);
		t1.move(200);
		t1.setPen();
		t1.move(10);
		t1.turn(1, true);
		t1.move(20, 200, 0, 0);
		t1.turn(1, false);
		t1.move(20, 0, 0, 200);
		
		
		// TURTLE 2
		
		Turtle t2 = new Turtle(w);
		int[][] colors = {{254, 0, 0}, {0, 254, 0}, {0, 0, 254}, {100, 200, 0}};
		int lineLength = 20;
		t2.setPen();
		for (int i = 0; i < 4; i++) {
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, true);
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, false);
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, true);
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, true);
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, false);
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, true);
			t2.move(lineLength, colors[i][0], colors[i][1], colors[i][2]);
			t2.turn(1, false);
		}
	}
	
}




class Turtle {
	
	// PROPERTIES
	
	public ImageWindow w;		// this turtle's window
	public int x;				// x position
	public int y;				// y position
	public int direction;		// 0123 for NESW
	public boolean penPosition;	// true for down, false for up
	
	
	// INITIALIZING
	
	public Turtle (ImageWindow w) {
		this.w = w;
		x = w.getImageWidth() / 2;
		y = w.getImageHeight() / 2;
		direction = 1;
		penPosition = false;
	}
	
	
	// METHODS
	
	public void setPen () {
		penPosition = !penPosition;
	}
	
	public void turn (int turns, boolean clockwise) {
		if (clockwise) {
			direction += turns;
			while (direction > 3) {
				direction -= 4;
			}
		} else {
			direction -= turns;
			while (direction < 0) {
				direction += 4;
			}
		}
	}
	
	public void move(int distance, int r, int g, int b) {
		for (int i = 0; i < distance; i++) {
			switch (direction) {
				case 0:
					y--;
					break;
				case 1:
					x++;
					break;
				case 2:
					y++;
					break;
				case 3:
					x--;
					break;
				default:
					System.out.println("ERROR! Turtle::move -- Switch Default: Why are we here?! Probably turn did sth wrong.");
					break;
			}
			if (penPosition) {
				w.setPixel(x, y, r, g, b);
				w.redraw();
				w.pause(20);
			}
		}
	}
	
	public void move(int distance) {
		move(distance, 100, 100, 100);
	}
	
	public void move() {
		move(10);
	}
	
	
	
}