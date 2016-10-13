import ch.unibas.informatik.cs101.ImageWindow;

public class ExTwoD {
	public static ImageWindow w;
	
	public static int width = 500;
	public static int height = 500;
		
	public static void main(String args[]) {
    	//creates a new instance of the ImageWindow Class
    	//with a viewable image area of 500x500 pixels
		w = new ImageWindow (width, height);

		//opens the corresponding window (makes it visible)
		w.openWindow();
		
		int r = 100;
		
		// draw square
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				if (x*x + y*y <= r*r) {
					w.setPixel(x, y, 0, 0, 0);
				}
				
			}
		}
	
	

		//redraws the image on the screen so all changes
		//become visible
		w.redraw();
  	}
}
