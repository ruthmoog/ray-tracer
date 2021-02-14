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

}
