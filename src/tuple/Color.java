package tuple;

public class Color {
    private final double red;
    private final double green;
    private final double blue;

    public Color(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getRed() {
        return red;
    }
}
