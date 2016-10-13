import ch.unibas.informatik.cs101.ImageWindow;

public class ExTwoC {
	public static ImageWindow w;
	
	public static int width = 500;
	public static int height = 500;
	
	public static void main(String args[]) {
    	//creates a new instance of the ImageWindow Class
    	//with a viewable image area of 500x500 pixels
		w = new ImageWindow (width, height);

		//opens the corresponding window (makes it visible)
		w.openWindow();
		
		
		// draw square
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				// With (a % 2 == 0) we can check whether the variable a can be divided by two.
				// So if we use if (x % 2 == 0) { ... } we would check every other x coordinate.
				// By dividing x with 20 we check the first 20 x
				// (because every x from 0 to 19 divided by 20 equals 0 which can be divided by 2 so the statement is true and the if block gets executed.
				//	and then every x from 20 to 39 divided by 20 equals 1 which can't be divided by 2 so the else block gets executed. And so on.)
				// and then inside the first if block we do the same with the y.
				// and in the else we also do it with y all the other y's so it becomes a checkboard.
				
				if ( (x / 20) % 2 == 0 ) {
					if ( (y / 20) % 2 == 0 ) {
						w.setPixel(x, y, 0, 0, 0);			// color 1 (on every second y-row)
					} else {
						w.setPixel(x, y, 254, 254, 254);	// color 2 (on every other y-row)
					}
				} else {
					if ( (y / 20) % 2 == 0) {				// on every other x row we have to switch colors
						w.setPixel(x, y, 254, 254, 254);	// color 2 (on every second y-row)
					} else {
						w.setPixel(x, y, 0, 0, 0);			// color 1 (on every other y-row)
					}
				}
			}
		}
	
	

		//redraws the image on the screen so all changes
		//become visible
		w.redraw();
  	}
}
