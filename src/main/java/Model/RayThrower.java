package Model;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class RayThrower {
    Camera cam;
    Scene scene;
    int imgwidth, imgheight;
    public RayThrower(Camera cam, Scene scene, int x, int y){
            this.cam = cam;
            this.scene = scene;
            this.imgwidth = x;
            this.imgheight = y;
    }

    public Vector orthonormalW(Camera cam){
        Triplet temp = cam.getLookFrom();

        Triplet temp2 = cam.getLookAt();

        Vector w1 = new Vector(cam.getLookFrom().subtract(cam.getLookAt()));
        Vector w2 = new Vector(temp.subtract(temp2));
        Vector w = new Vector((temp.divide(temp2)).normalize());
        return w;
    }

    public Vector orthonormalU(Camera cam){
        Triplet tmp = orthonormalW(cam).getTriplet();
        Triplet u1 = cam.getUp().multiply(tmp);

        Triplet upTemp = cam.getUp();

        Triplet TempW = orthonormalW(cam).getTriplet();


        Triplet u2 = upTemp.multiply(TempW).normalize();

        Vector y = new Vector(u1.divide(u2));
        return y;
    }

    public Vector orthonormalV(Camera cam){
        Vector v1 = orthonormalW(cam).multiply(orthonormalU(cam));
        Vector v2 = orthonormalW(cam).multiply(orthonormalU(cam)).normalize();
        Vector v = new Vector(v1.getTriplet().divide(v2.getTriplet()));
        return v;
    }

    public void SaveImage() throws Exception{
        try {
            // Retrieve image
            BufferedImage image = getMyImage();
            File outputfile = new File("output.png");
            ImageIO.write(image, "png", outputfile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
