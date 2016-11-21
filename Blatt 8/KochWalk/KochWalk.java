import ch.unibas.informatik.cs101.ImageWindow;
import ch.unibas.informatik.cs101.Walker;

public class KochWalk {
	
	
	public static void main (String[] args) {
		
		// Aufgabe 2a)
		
		int depth;
		
		if (args.length != 1) {
			depth = 3;
		} else {
			depth = Integer.parseInt(args[0]);
		}
		
		ImageWindow windowA = new ImageWindow(500, 500);
		Walker walkerA = new Walker(windowA);
		
		windowA.openWindow("Koch Walk " + depth);
		walkerA.pressBallPen();
		
		walkerA.setPos(5.0, 200.0);
		walkerA.setDir(1.0, 0.0);
		
		walk (depth, 400, walkerA);
		
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
		
		ImageWindow windowB = new ImageWindow(600, 700);
		Walker walkerB = new Walker(windowB);
		
		windowB.openWindow("Schneeflocke");
		walkerB.pressBallPen();
		
		walkerB.setPos(0.0, 150.0);
		walkerB.setDir(1.0, 0.0);
		
		snowflake(walkerB);
		
	}
	
	
	
	static void walk (int depth, double length, Walker walker) {
		// Depth has to be at least 1 and max 5.
		if (depth < 1) return;
		if (depth > 5) return;
		
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
		walk (5, 500, walker);
		walker.turn(120);
		walk (5, 500, walker);
		walker.turn(120);
		walk (5, 500, walker);
	}
	
	
	
}