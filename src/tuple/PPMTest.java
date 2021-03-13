package tuple;

import org.junit.Assert;
import org.junit.Test;

public class PPMTest {

    @Test
    public void constructPPMHeader() {
        // Given
        Canvas canvas = new Canvas(5,3);
        String expected = "P3\n5 3\n255\n";

        // When
        String actual = PPM.convert(canvas);

        // Then
        Assert.assertTrue(actual.startsWith(expected));
    }

    @Test
    public void constructPPMPixelData() {
        // Given
        Canvas canvas = new Canvas(5,3);
        Color color1 = new Color(1.5, 0, 0);
        Color color2 = new Color(0, 0.5, 0);
        Color color3 = new Color(-0.5, 0, 1);

        // When
        canvas.writePixel(0, 0, color1);
        canvas.writePixel(2, 1, color2);
        canvas.writePixel(4, 2, color3);
        String actual = PPM.convert(canvas);
        String[] lines = actual.split("\n");

        String blackPixel = "0 0 0";

        // Then
        System.out.println(actual);
        Assert.assertEquals(6, lines.length);
        Assert.assertEquals(String.join(" ", "255 0 0", blackPixel, blackPixel, blackPixel, blackPixel), lines[3]);
        Assert.assertEquals(String.join(" ", blackPixel, blackPixel, "0 128 0", blackPixel, blackPixel), lines[4]);
        Assert.assertEquals(String.join(" ", blackPixel, blackPixel, blackPixel, blackPixel, "0 0 255"), lines[5]);
    }

    @Test
    public void constructPPMPixelDataANTISLIME() {
        // Given
        Canvas canvas = new Canvas(2,2);
        Color red = new Color(1, 0, 0);
        Color green = new Color(0,1,0);
        Color blue = new Color(0,0,1);

        // When
        canvas.writePixel(0, 0, green);
        canvas.writePixel(1, 1, red);
        canvas.writePixel(1, 0, blue);

        String actual = PPM.convert(canvas);
        String[] lines = actual.split("\n");

        System.out.println(actual);

        String blackPixel = "0 0 0";

        // Then
        Assert.assertEquals(5, lines.length);
        Assert.assertEquals(String.join(" ", "0 255 0", "0 0 255"), lines[3]);
        Assert.assertEquals(String.join(" ", blackPixel, "255 0 0"), lines[4]);
    }}
