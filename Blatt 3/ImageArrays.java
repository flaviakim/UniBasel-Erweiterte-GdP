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


		/*  TODO: create an array that is large enough to hold
                 *       the complete image information
                 */



		/*  TODO: store the complete image information in the
                 *        array you have created.
                 *  HINT: int red=sourceWindow.getPixelRed(xPosition, yPosition);
		 *        int green=sourceWindow.getPixelGreen(xPosition, yPosition);
		 *        int blue=sourceWindow.getPixelBlue(xPosition, yPosition);
	 	 */



		//create & open the second windo (to draw your copy into)
		ImageWindow destinationWindow= new ImageWindow(500,500);
		destinationWindow.openWindow("Image rotated by 90 degree",550,0);



		/*  TODO: write back your array data into the destinationWindow so that
                 *        it appears to be rotated 90 degrees.
                 *  HINT: destinationWindow.setPixel(xPos,yPos,red,green,blue);
		 */



                // redraw to see the changed image
                destinationWindow.redraw();

                // Create another output window
		ImageWindow destinationWindow2= new ImageWindow(500,500);
		destinationWindow2.openWindow("Image with permuted color channels",0,550);



                /*  TODO: call here your function which permutes the color channels
                 */



                // redraw to see the changed image
		destinationWindow2.redraw();
	}


        /*  TODO: implement here the function to rotate the color channels.
         *  HINT: think about the arguments you need for the function.
         */





}
