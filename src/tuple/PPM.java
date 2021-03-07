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

        return stringWriter.toString();
    }
}
