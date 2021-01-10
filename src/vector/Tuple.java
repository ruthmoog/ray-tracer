package vector;

public class Tuple {

    private double x;
    private double y;
    private double z;
    private double w;

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static Tuple point(double x, double y, double z) {
        return new Tuple(x, y, z, 1.0);
    }

    public static Tuple vector(double x, double y, double z) {
        return new Tuple(x, y, z, 0.0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getW() {
        return w;
    }

    public boolean isPoint() {
        return w == 1;
    }

    public boolean isVector() {
        return w == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Tuple)) {
            return false;
        }

        Tuple other = (Tuple) obj;
        return  this.x == other.x &&
                this.y == other.y &&
                this.z == other.z &&
                this.w == other.w;
    }

    @Override
    public String toString() {
        return "x:" + this.x + " y:" + this.y + " z:" + this.z + " w:" + this.w;
    }

    public Tuple add(Tuple tuple) {
        double sumX = getX() + tuple.x;
        double sumY = getY() + tuple.y;
        double sumZ = getZ() + tuple.z;
        double sumW = getW() + tuple.w;
        return new Tuple(sumX,sumY,sumZ,sumW);
    }

    public Tuple subtract(Tuple tuple) {
        int wValue = 1;
        if (this.getW() == tuple.getW()) {
            wValue = 0;
        }
        double sumX = getX() - tuple.x;
        double sumY = getY() - tuple.y;
        double sumZ = getZ() - tuple.z;
        return new Tuple(sumX, sumY, sumZ, wValue);
    }

    public Tuple negate() {
        return new Tuple(-getX(),-getY(),-getZ(),-getW());
    }

    public Tuple multiply(double scalar) {
        return new Tuple(getX()*scalar, getY()*scalar, getZ()*scalar, getW()*scalar);
    }

    public Tuple divide(double scalar) {
        return new Tuple(getX()/scalar, getY()/scalar, getZ()/scalar, getW()/scalar);
    }
}
