package tuple;

public class Canvas {
    private int width;
    private int height;
    private Color[][] pixels;

    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
        // create a 2d array of colors default to 000
        this.pixels = new Color[height][width];
        for (int row = 0; row < this.pixels.length; row++) {
            for (int column = 0; column < this.pixels[row].length; column++) {
                this.pixels[row][column] = new Color(0,0,0);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color pixelAt(int x, int y) {
        return pixels[x][y];
    }

    public void writePixel(int x, int y, Color color) {
        pixels[x][y] = color;
    }
}
