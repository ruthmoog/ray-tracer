package tuple;

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
        Tuple tuple = new Point(1,2,3);
        // When
        boolean isPoint = tuple.isPoint();
        // Then
        Assert.assertTrue(isPoint);
    }

    @Test
    public void testCreateVector() {
        // Given
        Tuple tuple = new Vector(1,2,3);
        // When
        boolean isVector = tuple.isVector();
        // Then
        Assert.assertTrue(isVector);
    }

    @Test
    public void testTuplesForEquality() {
        // Given
        Tuple tuple1 = new Point(1,1,1);
        Tuple tuple2 = new Point(1,1,1);

        // When
        boolean areTuplesEqual = tuple1.equals(tuple2);

        // Then
        Assert.assertTrue(areTuplesEqual);
    }

    @Test
    public void testTuplesNotEqual() {
        // Given
        Tuple tuple1 = new Point(1,1,1);
        Tuple tuple2 = new Vector(1,1,1);

        // When
        boolean areTuplesEqual = tuple1.equals(tuple2);

        // Then
        Assert.assertFalse(areTuplesEqual);
    }

    @Test
    public void testTupleNoteEqualToNull() {
        // Given
        Tuple tuple1 = new Point(1,1,1);

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
        Tuple point1 = new Point(3,2,1);
        Tuple point2 = new Point(6,7,8);
        Tuple expected = new Vector(-3, -5, -7);

        // When
        Tuple actual = point1.subtract(point2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSubtractVectorFromPoint() {
        // Given
        Tuple point = new Point(1,1,1);
        Tuple vector = new Vector(5,6,7);
        Tuple expected = new Point(-4,-5,-6);

        // When
        Tuple actual = point.subtract(vector);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSubtractTwoVectors() {
        // Given
        Tuple vector1 = new Vector(3,2,1);
        Tuple vector2 = new Vector(5,6,7);
        Tuple expected = new Vector(-2,-4,-6);

        // When
        Tuple actual = vector1.subtract(vector2);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSubtractVectorFromZeroVector() {
        // Given
        Tuple vector = new Vector(1,-2,3);
        Tuple zeroVector = new Vector(0,0,0);
        Tuple expected = new Vector(-1,2,-3);

        // When
        Tuple actual = zeroVector.subtract(vector);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void negateTuple() {
        // Given
        Tuple tuple = new Tuple(1,-2,3,-4);
        Tuple expected = new Tuple(-1,2,-3,4);

        // When
        Tuple actual = tuple.negate();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void multiplyingATupleByAScalar() {
        // Given
        Tuple tuple = new Tuple(1, -2, 3, -4);
        Tuple expected = new Tuple(3.5, -7, 10.5, -14);

        // When
        Tuple actual = tuple.multiply(3.5);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dividingATupleByAScalar() {
        // Given
        Tuple tuple = new Tuple(1, -2, 3, -4);
        Tuple expected = new Tuple(0.5, -1, 1.5, -2);

        // When
        Tuple actual = tuple.divide(2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    //TODO: refactor me into a table
    @Test
    public void computingTheMagnitude() {
        // Given
        Tuple tuple1 = new Vector(1, 0, 0);
        Tuple tuple2 = new Vector(0, 1, 0);
        Tuple tuple3 = new Vector(0, 0, 1);
        Tuple tuple4 = new Vector(1, 2, 3);
        Tuple tuple5 = new Vector(-1, -2, -3);

        double expected1 = 1;
        double expected2 = 1;
        double expected3 = 1;
        double expected4 = Math.sqrt(14);
        double expected5 = Math.sqrt(14);

        // When
        double actual1 = tuple1.magnitude();
        double actual2 = tuple2.magnitude();
        double actual3 = tuple3.magnitude();
        double actual4 = tuple4.magnitude();
        double actual5 = tuple5.magnitude();

        // Then
        Assert.assertEquals(expected1, actual1, 0);
        Assert.assertEquals(expected2, actual2, 0);
        Assert.assertEquals(expected3, actual3, 0);
        Assert.assertEquals(expected4, actual4, 0);
        Assert.assertEquals(expected5, actual5, 0);
    }

    @Test
    public void normalizeVector() {
        // Given
        Vector vector1 = new Vector(4,0,0);
        Vector vector2 = new Vector(1,2,3);
        Vector expected1 = new Vector(1,0,0);
        Vector expected2 = new Vector(0.2672612419124244,0.5345224838248488,0.8017837257372732);

        // When
        Vector actual1 = vector1.normalize();
        Vector actual2 = vector2.normalize();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void magnitudeOfNormalizedVector() {
        // Given
        Vector vector = new Vector(1,2,3);
        double expected = 1;

        // When
        Vector normalizedVector = vector.normalize();
        double actual = normalizedVector.magnitude();

        // Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void dotProductOfTwoVectors() {
        // Given
        Tuple vectorA = new Vector(1,2,3);
        Tuple vectorB = new Vector(2,3,4);
        double expected = 20;

        // When
        double actual = Tuple.dotProduct(vectorA, vectorB);

        // Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void crossProductOfTwoVectors() {
        // Given
        Tuple vector1 = new Vector(1,2,3);
        Tuple vector2 = new Vector(2,3,4);
        Tuple expected1 = new Vector(-1,2,-1);
        Tuple expected2 = new Vector(1,-2,1);

        // When
        Tuple actual1 = Tuple.crossProduct(vector1, vector2);
        Tuple actual2 = Tuple.crossProduct(vector2, vector1);

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

}
