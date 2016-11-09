import java.awt.*;

/**
 * Created by forster on 29.10.14.
 */
class ColorPalette {

  Color[] colors;

  // Durch den Konstruktor wird eine der vordefinierten Paletten gewählt.
  public ColorPalette (int pal) {
    init(pal);
  }

  // Vordefinierte Farbpaletten (kann geändert oder erweitert werden).
  final int[][][] colorPalette = {
    {
      {18, 0, 10, 20}, {18, 50, 100, 240}, {18, 20, 3, 26}, {18, 230, 60, 20}, {18, 25, 10, 9},
      {18, 230, 170, 0}, {18, 20, 40, 10}, {18, 0, 100, 0}, {18, 5, 10, 10}, {18, 210, 70, 30},
      {18, 90, 0, 50}, {18, 180, 90, 120}, {18, 0, 20, 40}, {18, 30, 70, 200}
    },
    {
      {32, 0, 0, 0},{32, 0, 0, 255},{32,0,255,0},{32,255,255,0},{32,255,0,0}
    }
  };

  void init(int palette) {

    // Erstell je nach Palette eine Anzahl Farben.
    int n = 0;
    for (int i = 0; i < colorPalette[palette].length; i++)
      n += colorPalette[palette][i][0];
    colors = new Color[n];
    n = 0;

    // Interpolier Farben zwischen je zwei Nachbarn in der Palette.
    for (int i = 0; i < colorPalette[palette].length; i++) {
      int[] col1 = colorPalette[palette][i];
      int[] col2 = colorPalette[palette][(i + 1) % colorPalette[palette].length];

      // Lineare interpolation der RGB Farben.
      for (int j = 0; j < col1[0]; j++)
        colors[n + j] = new Color(
          (col1[1] * (col1[0] - 1 - j) + col2[1] * j) / (col1[0] - 1),
          (col1[2] * (col1[0] - 1 - j) + col2[2] * j) / (col1[0] - 1),
          (col1[3] * (col1[0] - 1 - j) + col2[3] * j) / (col1[0] - 1));
      n += col1[0];
    }
  }

  // Berechnet eine Farbe anhand einer Zahl
  public Color color(int count) {
    int palSize = colors.length;
    Color color = colors[(count / 256) % palSize];
    Color color2 = colors[(count / 256 + palSize - 1) % palSize];
    int k1 = count % 256;
    int k2 = 255 - k1;
    int red = (k1 * color.getRed() + k2 * color2.getRed()) / 255;
    int green = (k1 * color.getGreen() + k2 * color2.getGreen()) / 255;
    int blue = (k1 * color.getBlue() + k2 * color2.getBlue()) / 255;
    color = new Color(red, green, blue);
    return color;
  }

  // Berechnet eine Farbe anhand einem Integer und einer komplexen Zahl.
  public Color getColor(int count, Complex c) {
    double diff = 0.00000001;
    int ret = 256*count + (int)(255.0 * Math.log(4 / (c.abs_sqr()+diff)) / Math.log(c.abs_sqr()) / (c.abs_sqr()+diff));
    return (0>ret) ? color(0) : color(ret);
  }

}
