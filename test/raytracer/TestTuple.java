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

        Assert.assertEquals("A point has a `w` of 1", 1, tuple.getW(), 0);
        Assert.assertTrue("Should be a point but isn't", tuple.isPoint());
        Assert.assertFalse("Should not be a vector", tuple.isVector());
    }

    @Test
    public void testTupleIsVector() {
        double x = 4.3;
        double y = -4.2;
        double z = 3.1;
        Tuple tuple = Tuple.vector(x,y,z);

        Assert.assertEquals("A vector has a `w` of 0", 0, tuple.getW(), 0);
        Assert.assertTrue("Should be a vector but isn't", tuple.isVector());
        Assert.assertFalse("Should not be a point", tuple.isPoint());
    }

    @Test
    public void testTwoLikePointsAreEqual() {
        double x = 4.3;
        double y = -4.2;
        double z = 3.1;
        Tuple tupleA = Tuple.point(x,y,z);
        Tuple tupleB = Tuple.point(x,y,z);
        Tuple tupleC = Tuple.point(x,y,3);

        Assert.assertEquals("Identical points should be the same", tupleA, tupleB);
        Assert.assertNotEquals("Non-identical points should not be the same", tupleA, tupleC);
    }

    @Test
    public void testTwoLikeVectorsAreEqual() {
        double x = 4.3;
        double y = -4.2;
        double z = 3.1;
        Tuple tupleA = Tuple.vector(x,y,z);
        Tuple tupleB = Tuple.vector(x,y,z);
        Tuple tupleC = Tuple.vector(x,y,3);

        Assert.assertEquals("Identical vectors should be the same", tupleA, tupleB);
        Assert.assertNotEquals("Non-identical vectors should not be the same", tupleA, tupleC);
    }

    @Test
    public void testAddingTwoTuples() {
        Tuple point = Tuple.point(3,-2,5);
        Tuple vector = Tuple.vector(-2, 3, 1);
        Tuple expectedPoint = Tuple.point(1,1,6);

        Tuple actualPoint = point.add(vector);

        Assert.assertEquals(expectedPoint, actualPoint);
    }
}
