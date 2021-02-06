package tuple;

public class Vector extends Tuple {

    public Vector(double x, double y, double z) {
        super(x, y, z, 0);
    }

    public Vector normalize() {
        double magnitude = this.magnitude();
        double x = this.getX() / magnitude;
        double y = this.getY() / magnitude;
        double z = this.getZ() / magnitude;
        return new Vector(x, y, z);
    }
}
