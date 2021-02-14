package tuple;

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

}
