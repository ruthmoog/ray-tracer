package tuple;

import java.io.StringWriter;

public class PPM {

    public static String convertToPpm(Canvas canvas) {
        StringWriter stringWriter = new StringWriter();
        stringWriter
                .append("P3")
                .append(System.getProperty("line.separator"))
                .append(canvas.getHeight() + " " + canvas.getWidth())
                .append(System.getProperty("line.separator"))
                .append("255");
        return stringWriter.toString();
    }
}
