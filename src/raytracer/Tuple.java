package raytracer;

public class Tuple {
    private double x;
    private double y;
    private double z;

    public double getW() {
        return w;
    }

    private double w;

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static Tuple point(double x, double y, double z) {
        return new Tuple(x, y, z,1.0);
    }

    public static Tuple vector(double x, double y, double z) {
        return new Tuple(x, y, z,0.0);
    }

    public boolean isPoint() {
        return this.w == 1;
    }

    public boolean isVector() {
        return this.w == 0;
    }
}
