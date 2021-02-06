package tuple;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {

    @Test
    public void testTick() {
        // Given
        Projectile projectile = new Projectile(new Point(0,1,0), new Vector(1,1,0).normalize());
        Environment environment = new Environment(new Vector(0,-0.1,0), new Vector(-0.01,0,0));
        Point expected = new Point(0.7071067811865475, 1.7071067811865475, 0.0);
        // When
        projectile.tick(environment);

        // Then
        Assert.assertEquals(expected, projectile.getPosition());
    }
}
