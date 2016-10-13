import ch.unibas.informatik.cs101.ImageWindow;

public class BasicDrawing {
  public static ImageWindow w;
  public static void main(String args[]) {
    //creates a new instance of the ImageWindow Class
    //with a viewable image area of 500x500 pixels
    w = new ImageWindow(500,500);

    //opens the corresponding window (makes it visible)
    w.openWindow();

    //colors the pixel at position 255,100 in the image
    //with the rgb color 254 (red), 0 (green), 0 (blue)
    w.setPixel(255, 100, 254, 0, 0);

    // Add your code here

    //redraws the image on the screen so all changes
    //become visible
    w.redraw();
  }
}
