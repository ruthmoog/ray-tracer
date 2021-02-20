package tuple;

import org.junit.Assert;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void createCanvas() {
        // Given
        double height = 10;
        double width = 20;

        // When
        Canvas canvas = new Canvas(height, width);

        // Then
        Assert.assertEquals(height, canvas.getHeight(),0);
        Assert.assertEquals(width, canvas.getWidth(),0);
    }
}
