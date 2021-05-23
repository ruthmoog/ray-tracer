package canvas;

import tuple.Dimension;

public class Canvas {
    private int width;
    private int height;
    private Color[][] pixels;

    public Canvas(Dimension dimension) {
        this.height = dimension.height.value;
        this.width = dimension.width.value;
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

    public Color pixelAt(int row, int column) {
        return pixels[column][row];
    }

    public void writePixel(int row, int column, Color color) {
//        if(row < 0 || column < 0) return;
//        if(row < this.getWidth() || column < this.getHeight())return;

        try {
            pixels[column][row] = color;
        }catch (Exception e) {

        }

    }

    @Override
    public String toString() {
        return "Canvas of width: " + this.getWidth() + " and height of: "+this.getHeight();
    }
}
