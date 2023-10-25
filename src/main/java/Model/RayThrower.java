package Model;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class RayThrower {
    private Camera cam;
    private Scene scene;
    private int imgwidth, imgheight;
    public RayThrower(Scene scene, int x, int y){
            this.scene = scene;
            this.cam = scene.getCamera();
            this.imgwidth = x;
            this.imgheight = y;
    }

    public int getImgwidth() {
        return imgwidth;
    }

    public int getImgheight() {
        return imgheight;
    }

    public Camera getCam() {
        return cam;
    }

    public Scene getScene() {
        return scene;
    }

    public Vector orthonormalW(){
        Triplet temp = getCam().getLookFrom();

        Triplet temp2 = getCam().getLookAt();

        Vector w1 = new Vector(getCam().getLookFrom().subtract(getCam().getLookAt()));
        Vector w2 = new Vector(temp.subtract(temp2));
        Vector w = new Vector((temp.divide(temp2)).normalize());
        return w;
    }

    public Vector orthonormalU(){
        Triplet tmp = orthonormalW().getTriplet();
        Triplet u1 = getCam().getUp().multiply(tmp);

        Triplet upTemp = getCam().getUp();

        Triplet TempW = orthonormalW().getTriplet();


        Triplet u2 = upTemp.multiply(TempW).normalize();

        Vector y = new Vector(u1.divide(u2));
        return y;
    }

    public Vector orthonormalV(){
        Vector v1 = orthonormalW().multiply(orthonormalU());
        Vector v2 = orthonormalW().multiply(orthonormalU()).normalize();
        Vector v = new Vector(v1.getTriplet().divide(v2.getTriplet()));
        return v;
    }

    public BufferedImage getMyImage(){
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        for (int x=0; x<getImgwidth(); x++){
            for (int y=0; y<getImgheight(); y++){
                image.setRGB(x, y, 0);
            }
        }
        return image;
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
