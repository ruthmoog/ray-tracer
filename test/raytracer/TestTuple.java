package raytracer;

import org.junit.Assert;
import org.junit.Test;

public class TestTuple {

    @Test
    public void testTupleIsPoint() {
        double x = 4.3;
        double y = -4.2;
        double z = 3.1;
        Tuple tuple = Tuple.point(x, y, z);

        Assert.assertTrue("Should be a point but isn't", tuple.isPoint());
        Assert.assertFalse("Should not be a vector", tuple.isVector());
    }

    @Test
    public void testTupleIsVector() {
        double x = 4.3;
        double y = -4.2;
        double z = 3.1;
        Tuple tuple = Tuple.vector(x,y,z);

        Assert.assertTrue("Should be a vector but isn't", tuple.isVector());
        Assert.assertFalse("Should not be a point", tuple.isPoint());
    }
}
