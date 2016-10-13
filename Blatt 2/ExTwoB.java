import ch.unibas.informatik.cs101.ImageWindow;

public class ExTwoB {
  public static ImageWindow w;

  public static void main(String args[]) {
    //creates a new instance of the ImageWindow Class
    //with a viewable image area of 500x500 pixels
    w = new ImageWindow (width, height);

    //opens the corresponding window (makes it visible)
    w.openWindow();
    
    int startX = 50;
    int startY = 50;
    
    int endX = 100;
    int endY = 100;

    // draw square
    for (int x = startX; x < endX; x++) {
    	for (int y = startY; y < endY; y++) {
    		w.setPixel(x, y, 254, 0, 0);
    	}
    }
    
    

    //redraws the image on the screen so all changes
    //become visible
    w.redraw();
  }
}
