package tuple;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PPM {

    private static final String PPM_TYPE = "P3";
    private static final int MAX_COLOR_VALUE = 255;

    static String convert(Canvas canvas) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        printWriter.println(PPM_TYPE);
        printWriter.println(canvas.getWidth() + " " + canvas.getHeight());
        printWriter.println(MAX_COLOR_VALUE);

        // a color of 1.5, is capped to 1, and the max value we get is 255
        // so a way to look at it, is 1 == 100% red, so our colours are percentages

        for (int row = 0; row < canvas.getHeight(); row++) {
            for (int column = 0; column < canvas.getWidth(); column++) {
                Color color = canvas.pixelAt(row, column);
                int red = getPixelColor(color.getRed());
                int green = getPixelColor(color.getGreen());
                int blue = getPixelColor(color.getBlue());

                String pixel = red + " " + green + " " + blue;
                if(column == (canvas.getWidth() - 1)) {
                    printWriter.println(pixel);
                } else {
                    printWriter.print(pixel + " ");
                }
            }
        }

        return stringWriter.toString();
    }

    private static int getPixelColor(double red) {
        return (int) Math.round(clamp(red) * MAX_COLOR_VALUE);
    }

    static private double clamp(double value) {
        if (value < 0 ) {
            return 0;
        }
        return Math.min(value, 1.0);
    }

}
