package tuple;

import org.junit.Assert;
import org.junit.Test;

public class PPMTest {

    @Test
    public void constructPPMHeader() {
        // Given
        Canvas canvas = new Canvas(5,3);
        String expected = "P3\n5 3\n255";

        // When
        String actual = PPM.convertToPpm(canvas);

        // Then
        Assert.assertEquals(actual, expected);
    }

}
