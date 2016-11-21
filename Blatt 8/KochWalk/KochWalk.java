import ch.unibas.informatik.cs101.ImageWindow;
import ch.unibas.informatik.cs101.Walker;

public class KochWalk {
	
	
	public static void main (String[] args) {
		
		// Aufgabe 2a)
		
		int depth = Integer.parseInt(args[0]);
		
		ImageWindow window = new ImageWindow(500, 500);
		Walker walker = new Walker(window);
		
		window.openWindow("Koch Walk " + depth);
		walker.pressBallPen();
		
		walker.setPos(5.0, 200.0);
		walker.setDir(1.0, 0.0);
		
		walk (depth, 400, walker);
		
		/* alter Code mit mehrerer Fenstern gleichzeitig.
		int count = 3;
		
		ImageWindow[] windows = new ImageWindow[count];
		Walker[] walkers = new Walker[count];
		
		for (int i = 0; i < count; i++) {
			windows[i] = new ImageWindow(510, 510);
			walkers[i] = new Walker(windows[i]);
			
			windows[i].openWindow ("Koch Walk " + (i+1));
			walkers[i].pressBallPen();
			
			walkers[i].setPos(5.0, 200.0);
			walkers[i].setDir(1.0, 0.0);
			
			walk(i+1, 500, walkers[i]);
		}*/
		
		// Aufgabe 2b)
		
		ImageWindow window = new ImageWindow(600, 700);
		Walker walker = new Walker(window);
		
		window.openWindow("Schneeflocke");
		walker.pressBallPen();
		
		walker.setPos(0.0, 150.0);
		walker.setDir(1.0, 0.0);
		
		snowflake(walker);
		
	}
	
	
	
	static void walk (int depth, double length, Walker walker) {
		// Depth has to be at least 1.
		if (depth < 1) return;
		
		if (depth ==  1) {
			walker.move(length/3);
			walker.turn(-60);
			walker.move(length/3);
			walker.turn(120);
			walker.move(length/3);
			walker.turn(-60);
			walker.move(length/3);
		} else {
			walk(depth - 1, length/3, walker);
			walker.turn(-60);
			walk(depth - 1, length/3, walker);
			walker.turn(120);
			walk(depth - 1, length/3, walker);
			walker.turn(-60);
			walk(depth - 1, length/3, walker);
		}
		
	}
	
	
	static void snowflake (Walker walker) {
		walk (3, 500, walker);
		walker.turn(120);
		walk (3, 500, walker);
		walker.turn(120);
		walk (3, 500, walker);
	}
	
	
	
}