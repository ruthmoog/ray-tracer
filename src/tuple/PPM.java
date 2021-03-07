package tuple;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PPM {

    private static final String PPM_TYPE = "P3";
    private static final String MAX_COLOR_VALUE = "255";

    static String convertToPpm(Canvas canvas) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        printWriter.println(PPM_TYPE);
        printWriter.println(canvas.getWidth() + " " + canvas.getHeight());
        printWriter.println(MAX_COLOR_VALUE);

        // a color of 1.5, is capped to 1, and the max value we get is 255
        // so a way to look at it, is 1 == 100% red, so our colours are percentages

        printWriter.println("255 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        printWriter.println("0 0 0 0 0 0 0 128 0 0 0 0 0 0 0");
        printWriter.println("0 0 0 0 0 0 0 0 0 0 0 0 0 0 255");

        return stringWriter.toString();
    }

}
