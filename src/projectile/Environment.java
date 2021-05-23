package projectile;

import tuple.Vector;

public class Environment {

    private Vector gravity;
    private Vector wind;

    public Environment(Vector gravity, Vector wind) {
        this.gravity = gravity;
        this.wind = wind;
    }

    public Vector getGravity() {
        return gravity;
    }

    public Vector getWind() {
        return wind;
    }
}
