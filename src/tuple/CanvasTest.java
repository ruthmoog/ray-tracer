package tuple;

import org.junit.Assert;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void createCanvas() {
        // Given
        int height = 10;
        int width = 20;

        // When
        Canvas canvas = new Canvas(height, width);

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
        canvas.writePixel(x, y, red);

        // Then
        Assert.assertEquals(red, canvas.pixelAt(x, y));
    }

    @Test
    public void writeGREENPixelsToCanvas() {
        // Given
        Canvas canvas = new Canvas(10, 20);
        Color red = new Color(0,1,0);
        int x = 2;
        int y = 3;

        // When
        canvas.writePixel(x, y, red);

        // Then
        Assert.assertEquals(red, canvas.pixelAt(x, y));
    }
}
