package tuple;

import org.junit.Assert;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void createCanvas() {
        // Given
        int height = 20;
        int width = 10;

        // When
        Canvas canvas = new Canvas(width, height);

        // Then
        Assert.assertEquals(height, canvas.getHeight(),0);
        Assert.assertEquals(width, canvas.getWidth(),0);
    }

    @Test
    public void writePixelsToCanvas() {
        // Given
        Canvas canvas = new Canvas(10, 20);
        Color red = new Color(1,0,0);
        int x = 2;
        int y = 3;

        // When
        canvas.writePixel(y, x, red);

        // Then
        Assert.assertEquals(red, canvas.pixelAt(y, x));
    }
}
