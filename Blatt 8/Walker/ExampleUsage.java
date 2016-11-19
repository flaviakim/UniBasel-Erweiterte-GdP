import ch.unibas.informatik.cs101.Walker;
import ch.unibas.informatik.cs101.ImageWindow;

public class ExampleUsage {

    public static void main (String[] args) {

        ImageWindow iw = new ImageWindow(100,100);
        Walker w = new Walker(iw);

        iw.openWindow("ImageWindow");
        w.setPos(10,10);
        w.setDir(0,1);
        w.move(10);
        w.pressBallPen();
        w.setColor(0,0,0);
        w.move(10);
        w.setColor(255,0,0);
        w.move(10);
        w.turn(-90);
        w.move(20);
        iw.redraw();

    }

}
