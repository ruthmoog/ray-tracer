package tuple;

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

    public static double dotProduct(Tuple a, Tuple b) {
        double x = a.getX() * b.getX();
        double y = a.getY() * b.getY();
        double z = a.getZ() * b.getZ();
        double w = a.getW() * b.getW();
        return x + y + z + w;
    }

    public static Tuple crossProduct(Tuple a, Tuple b) {
        double x = a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getZ() * b.getX() - a.getX() * b.getZ();
        double z = a.getX() * b.getY() - a.getY() * b.getX();
        return Tuple.vector(x,y,z);
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

    public double magnitude() {
        double xSquared = getX() * getX();
        double ySquared = getY() * getY();
        double zSquared = getZ() * getZ();
        double wSquared = getW() * getW();
        return Math.sqrt(xSquared+ySquared+zSquared+wSquared);
    }

    public Tuple normalize() {
        double magnitude = this.magnitude();
        double x = this.getX() / magnitude;
        double y = this.getY() / magnitude;
        double z = this.getZ() / magnitude;
        double w = this.getW() / magnitude;
        return new Tuple(x, y, z, w);
    }
}
