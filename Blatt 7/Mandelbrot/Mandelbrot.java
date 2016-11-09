import ch.unibas.informatik.cs101.ImageWindow;
import java.awt.Color;

public class Mandelbrot {

  ColorPalette colPal;
  int width;
  int height;
  ImageWindow sourceWindow;


  public static void main(String[] args) {
    int palette = Integer.parseInt(args[0]);
    double fact = Double.parseDouble(args[1]);
    long startTime = 0, endTime;
    int width = (int) Math.round(64 * fact);
    int height = (int) Math.round(48 * fact);

    Mandelbrot m1 = new Mandelbrot( width, height, palette);
    m1.show_mandelbrot(new Complex(-2.5, -1.3), 0.05/fact, 1000);
    //m1.show_mandelbrot_inplace(new Complex(-2.5, -1.3), 0.05/fact, 255);

    Mandelbrot m2 = new Mandelbrot( width, height, palette);
    m2.show_mandelbrot(new Complex(-0.755, -0.1), 0.0002/fact, 1000);
    //m2.show_mandelbrot_inplace(new Complex(-0.755, -0.1), 0.0002/fact, 1000);
  }


  public Mandelbrot(int _width, int _height, int pal) {
    width = _width;
    height = _height;
    sourceWindow= new ImageWindow(width,height);
    sourceWindow.openWindow("mandelbrot",0,0);
    colPal = new ColorPalette(pal);
  }

  void show_mandelbrot(Complex c_origin, double c_step, int max_iter) {
    /* Implementieren des Mandelbrot Algorithmus */

    // Color col = colPal.getColor(n,z);

    redraw();
  }

  void show_mandelbrot_inplace(Complex c_origin, double c_step, int max_iter) {
    /* Implementieren des Mandelbrot Algorithmus */

    // Color col = colPal.getColor(n,z);

    redraw();
  }

  public void redraw() {
    sourceWindow.redraw();
  }

}
