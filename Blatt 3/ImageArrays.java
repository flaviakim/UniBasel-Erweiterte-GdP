import ch.unibas.informatik.cs101.ImageWindow;
import java.util.Random;

public class ImageArrays {

	public static void main(String[] args) {
		//create & open the first window (to display the source image)
		ImageWindow sourceWindow= new ImageWindow(500,500);
		sourceWindow.openWindow("source",0,0);

		//load the image 
		sourceWindow.loadImage("horn.jpg");	

		//redraw to see the image
		sourceWindow.redraw();
		
		// a) Create an Array with the needed size.
		int[] imageData = new int[500*500*3];
		
		// b) Fill the Array with RGB Information (first all 250000 Red values, then all Green and then all Blue values).
		for (int x = 0; x < 500; x++) {
			for (int y = 0; y < 500; y++) {
				imageData[0*500*500 + x*500 + y] = sourceWindow.getPixelRed(x, y);
				imageData[1*500*500 + x*500 + y] = sourceWindow.getPixelGreen(x, y);
				imageData[2*500*500 + x*500 + y] = sourceWindow.getPixelBlue(x, y);
				
			}
		}
		
		
		// c) Create & open the second window (to draw your copy into)
		ImageWindow destinationWindow = new ImageWindow(500,500);
		destinationWindow.openWindow("Image rotated by 90 degree",550,0);
		
		// c) Writes the Data rotated by 90° Clockwise.
		for (int x = 0; x < 500; x++) {
			for (int y = 0; y < 500; y++) {
				int xPos = 500 - 1 - y;
				int yPos = x;				
				int red   = imageData[0*500*500 + x*500 + y];
				int green = imageData[1*500*500 + x*500 + y];
				int blue  = imageData[2*500*500 + x*500 + y];
				destinationWindow.setPixel(xPos, yPos, red, green, blue);
			}
		}

		// c) Redraw to see the changed image
        destinationWindow.redraw();
		
		// d) Create another output window
		ImageWindow destinationWindow2 = new ImageWindow(500,500);
		destinationWindow2.openWindow("Image with permuted color channels",0,550);
		
		// d) Call the function
		changeColorChannels(destinationWindow2, imageData);
		
		// d) redraw to see the changed image
		destinationWindow2.redraw();
	}
	
	
	// d) Function to change the color channels according to the ex d)
	public static void changeColorChannels(ImageWindow window, int[] data) {
		for (int x = 0; x < 500; x++) {
			for (int y = 0; y < 500; y++) {			
				int red   = data[0*500*500 + x      *500 + (499-y)];
				int green = data[1*500*500 + (499-x)*500 + y      ];
				int blue  = data[2*500*500 + (499-y)*500 + (499-x)];
				window.setPixel(x, y, red, green, blue);
			}
		}
	}

}
