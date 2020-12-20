package vector;

import org.junit.Assert;
import org.junit.Test;

public class TupleTest {

    @Test
    public void testPointTuple() {

        // Given
        Tuple tuple = new Tuple(4.3, -4.2, 3.1, 1.0);
        double expectX = 4.3;
        double expectY = -4.2;
        double expectZ = 3.1;
        double expectW = 1.0;

        // When
        double actualX = tuple.getX();
        double actualY = tuple.getY();
        double actualZ = tuple.getZ();
        double actualW = tuple.getW();
        boolean isPoint = tuple.isPoint();
        boolean isVector = tuple.isVector();

        // Then
        Assert.assertEquals(expectX, actualX,0);
        Assert.assertEquals(expectY, actualY,0);
        Assert.assertEquals(expectZ, actualZ,0);
        Assert.assertEquals(expectW, actualW,0);
        Assert.assertTrue(isPoint);
        Assert.assertFalse(isVector);
    }

    @Test
    public void testVectorTuple() {
        // Given
        Tuple tuple = new Tuple(4.3, -4.2, 3.1, 0.0);

        // When
        boolean isPoint = tuple.isPoint();
        boolean isVector = tuple.isVector();

        // Then
        Assert.assertFalse(isPoint);
        Assert.assertTrue(isVector);
    }

    @Test
    public void testCreatePoint() {
        // Given
        Tuple tuple = Tuple.point(1,2,3);
        // When
        boolean isPoint = tuple.isPoint();
        // Then
        Assert.assertTrue(isPoint);
    }

    @Test
    public void testCreateVector() {
        // Given
        Tuple tuple = Tuple.vector(1,2,3);
        // When
        boolean isVector = tuple.isVector();
        // Then
        Assert.assertTrue(isVector);
    }

    @Test
    public void testTuplesForEquality() {
        // Given
        Tuple tuple1 = Tuple.point(1,1,1);
        Tuple tuple2 = Tuple.point(1,1,1);

        // When
        boolean areTuplesEqual = tuple1.equals(tuple2);

        // Then
        Assert.assertTrue(areTuplesEqual);
    }

    @Test
    public void testTuplesNotEqual() {
        // Given
        Tuple tuple1 = Tuple.point(1,1,1);
        Tuple tuple2 = Tuple.vector(1,1,1);

        // When
        boolean areTuplesEqual = tuple1.equals(tuple2);

        // Then
        Assert.assertFalse(areTuplesEqual);
    }

    @Test
    public void testTupleNoteEqualToNull() {
        // Given
        Tuple tuple1 = Tuple.point(1,1,1);

        // When
        boolean isEqual = tuple1.equals(null);

        // Then
        Assert.assertFalse(isEqual);
    }

@Test
    public void testAddTwoVectors() {
        // Given
        Tuple tuple1 = new Tuple(3, -2, 5, 1);
        Tuple tuple2 = new Tuple(-2, 3, 1, 0);
        Tuple expected = new Tuple(1,1,6,1);

        // When
        Tuple actual = tuple1.add(tuple2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSubtractTwoPoints() {
        // Given
        Tuple point1 = Tuple.point(3,2,1);
        Tuple point2 = Tuple.point(5,6,7);
        Tuple expected = Tuple.vector(-2, -4, -6);

        // When
        Tuple actual = point1.subtract(point2);

        // Then
        Assert.assertEquals(expected, actual);

    }
}
