package tuple;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Canvas myCanvas = new Canvas(new Dimension(new Width(100), new Height(100)));


        Projectile projectile = new Projectile(new Point(90,0,0), new Vector(-1,1,0).normalize());
        Environment environment = new Environment(new Vector(0.005,0,0), new Vector(0,0,0));
        for (int i=0; i<130; i++) {
            Point position = projectile.getPosition();
            myCanvas.writePixel((int)position.getX(),(int)position.getY(),new Color(0,0.9,0.8));
            projectile.tick(environment);
        }

        try {
            PPM.saveToFile(myCanvas, "myFile.ppm");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
