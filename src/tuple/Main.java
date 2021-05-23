package tuple;

import java.io.FileNotFoundException;

public class Main {

    public static final Color AQUA = new Color(0, 0.9, 0.8);
    public static final int TICKS = 130;
    public static final String MY_FILE_PPM = "myFile.ppm";

    public static void main(String[] args) {
        Canvas myCanvas = new Canvas(new Dimension(new Width(100), new Height(100)));
        Projectile projectile = new Projectile(new Point(90,0,0), new Vector(-1,1,0).normalize());
        Environment environment = new Environment(new Vector(0.005,0,0), new Vector(0,0,0));

        plotProjectile(myCanvas, projectile, environment);
        saveToDisk(myCanvas);
    }

    private static void saveToDisk(Canvas myCanvas) {
        try {
            PPM.saveToFile(myCanvas, MY_FILE_PPM);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void plotProjectile(Canvas myCanvas, Projectile projectile, Environment environment) {
        for (int i = 0; i<TICKS; i++) {
            Point position = projectile.getPosition();
            myCanvas.writePixel((int)position.getX(),(int)position.getY(), AQUA);
            projectile.tick(environment);
        }
    }
}
