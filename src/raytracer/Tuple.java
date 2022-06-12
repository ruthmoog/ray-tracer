package raytracer;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.x, x) == 0 && Double.compare(tuple.y, y) == 0 && Double.compare(tuple.z, z) == 0 && Double.compare(tuple.w, w) == 0;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    public Tuple add(Tuple tuple) {
        return new Tuple(this.x + tuple.x,
                this.y + tuple.y,
                this.z + tuple.z,
                this.w + tuple.w);
    }
}
