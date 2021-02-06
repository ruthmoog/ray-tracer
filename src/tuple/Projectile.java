package tuple;

public class Projectile {

    private Point position;
    private Vector velocity;

    public Projectile(Point position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Point getPosition() {
        return position;
    }

    public void tick(Environment environment) {
        Tuple newPosition = this.position.add(this.velocity);
        Tuple newVelocity = this.velocity.add(environment.getGravity()).add(environment.getWind());

        position = new Point(newPosition.getX(), newPosition.getY(), newPosition.getZ());
        velocity = new Vector(newVelocity.getX(), newVelocity.getY(), newVelocity.getZ());
    }
}
