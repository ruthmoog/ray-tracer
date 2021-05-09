package tuple;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Canvas myCanvas = new Canvas(new Dimension(new Width(2), new Height(2)));
        myCanvas.writePixel(0,0,new Color(1,0,0));
        try {
            PPM.saveToFile(myCanvas, "myFile.ppm");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
