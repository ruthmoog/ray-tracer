package tuple;

public class Canvas {
    private int width;
    private int height;
    private Color[][] pixels;

    public Canvas(int width, int height) {
        this.height = height;
        this.width = width;
        initializeCanvas();
    }

    private void initializeCanvas() {
        this.pixels = new Color[width][height];
        for (int row = 0; row < this.pixels.length; row++) {
            for (int column = 0; column < this.pixels[row].length; column++) {
                this.pixels[row][column] = Color.DEFAULT_COLOR;
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
