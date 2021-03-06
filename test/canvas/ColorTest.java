package canvas;

import canvas.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

    @Test
    public void colorsAreRedGreenAndBlue() {
        // Given / When
        Color color = new Color(-0.5, 0.4, 1.7);

        // Then
        Assert.assertEquals(color.getRed(), -0.5, 0);
        Assert.assertEquals(color.getGreen(), 0.4, 0);
        Assert.assertEquals(color.getBlue(), 1.7, 0);
    }

    @Test
    public void addingColors() {
        // Given
        Color color1 = new Color(0.9, 0.6, 0.75);
        Color color2 = new Color(0.7, 0.1, 0.25);
        Color expected = new Color(1.6, 0.7, 1.0);

        // When
        Color actual = color1.add(color2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void subtractingColors() {
        // Given
        Color color1 = new Color(0.9, 0.6, 0.75);
        Color color2 = new Color(0.7, 0.1, 0.25);
        Color expected = new Color(0.20000000000000007, 0.5, 0.5);

        // When
        Color actual = color1.subract(color2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiplyColorByScalar() {
        // Given
        Color color = new Color(0.2, 0.3, 0.4);
        int scalar = 2;
        Color expected = new Color(0.4, 0.6, 0.8);

        // When
        Color actual = color.multiply(scalar);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiplyColors() {
        // Given
        Color color1 = new Color(1, 0.2, 0.4);
        Color color2 = new Color(0.9, 1, 0.1);
        Color expected = new Color(0.9, 0.2, 0.04000000000000001);

        // When
        Color actual = color1.multiply(color2);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
