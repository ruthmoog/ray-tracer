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
                Color color = canvas.pixelAt(column, row);
                int red = (int)Math.round(clamp(color.getRed()) * MAX_COLOR_VALUE);
                int green = (int)Math.round(clamp(color.getGreen()) * MAX_COLOR_VALUE);
                int blue = (int)Math.round(clamp(color.getBlue()) * MAX_COLOR_VALUE);

                if(column == (canvas.getWidth() - 1)) {
                    printWriter.println(red + " " + green + " " + blue);
                } else {
                    printWriter.print(red + " " + green + " " + blue + " ");
                }
            }
        }

        return stringWriter.toString();
    }

    static private double clamp(double value) {
        if (value < 0 ) {
            return 0;
        }
        return Math.min(value, 1.0);
    }

}
