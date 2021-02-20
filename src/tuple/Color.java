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

    public Color add(Color color) {
        double red = this.red + color.getRed();
        double green = this.green + color.getGreen();
        double blue = this.blue + color.getBlue();

        return new Color(red, green, blue);
    }


    public Color subract(Color color) {
        double red = this.red - color.getRed();
        double green = this.green - color.getGreen();
        double blue = this.blue - color.getBlue();

        return new Color(red, green, blue);
    }


    public Color multiply(int scalar) {
        double red = this.red * scalar;
        double green = this.green * scalar;
        double blue = this.blue * scalar;

        return new Color(red, green, blue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Color)) {
            return false;
        }

        Color other = (Color) obj;
        return  this.red == other.red &&
                this.green == other.green &&
                this.blue == other.blue;
    }

    @Override
    public String toString() {
        return "red:" + this.red + " green:" + this.green + " blue:" + this.blue;
    }
}
