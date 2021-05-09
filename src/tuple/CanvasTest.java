package tuple;

import org.junit.Assert;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void createCanvas() {
        // Given
        Dimension dimension = new Dimension(new Width(20), new Height(10));

        // When
        Canvas canvas = new Canvas(dimension);

        // Then
        Assert.assertEquals(10, canvas.getHeight(),0);
        Assert.assertEquals(20, canvas.getWidth(),0);
    }

    @Test
    public void writePixelsToCanvas() {
        // Given
        Dimension dimension = new Dimension(new Width(20), new Height(10));
        Canvas canvas = new Canvas(dimension);
        Color red = new Color(1,0,0);
        int x = 2;
        int y = 3;

        // When
        canvas.writePixel(y, x, red);

        // Then
        Assert.assertEquals(red, canvas.pixelAt(y, x));
    }
}
