package canvas;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PPMTest {

    private final Dimension DIMENSIONS = new Dimension(new Width(5),new Height(3));

    @Test
    public void constructPPMHeader() {
        // Given
        Canvas canvas = new Canvas(DIMENSIONS);
        String expected = "P3\n5 3\n255\n";

        // When
        String actual = PPM.convert(canvas);

        // Then
        Assert.assertTrue(actual.startsWith(expected));
    }

    @Test
    public void constructPPMPixelData() {
        // Given
        Canvas canvas = new Canvas(DIMENSIONS);
        Color color1 = new Color(1.5, 0, 0);
        Color color2 = new Color(0, 0.5, 0);
        Color color3 = new Color(-0.5, 0, 1);

        // When
        canvas.writePixel(0, 0, color1);
        canvas.writePixel(1, 2, color2);
        canvas.writePixel(2, 4, color3);
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
    public void PPMFilesAreTerminatedWithNewlineChar() {
        // Given
        Canvas canvas = new Canvas(DIMENSIONS);

        // When
        String actual = PPM.convert(canvas);

        // Then
        Assert.assertTrue(actual.endsWith(System.lineSeparator()));
    }

    /**
     * Parked - not sure if the new line should be mapped to the canvas AND
     * capped line length at 70?  Most programs dont cap line length so parking this for now.
     */
    @Ignore
    @Test
    public void splitLinesForPPMFiles() {
        // Given
        Canvas canvas = new Canvas(new Dimension(new Width(10),new Height(2)));
        Color color = new Color(1,0.8,0.6);
        int maxLineLength = 70;

        for (int row = 0; row < canvas.getHeight(); row++) {
            for (int column = 0; column < canvas.getWidth(); column++) {
                canvas.writePixel(row, column, color);
            }
        }

        // When
        String actual = PPM.convert(canvas);
        String[] lines = actual.split("\n");

        // Then
        Assert.assertTrue("bebe says no", lines[3].length() <= maxLineLength);
        Assert.assertTrue(lines[4].length() <= maxLineLength);
        Assert.assertTrue(lines[5].length() <= maxLineLength);
        Assert.assertTrue(lines[6].length() <= maxLineLength);
    }
}
