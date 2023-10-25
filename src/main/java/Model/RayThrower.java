package Model;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;

import static java.lang.Math.abs;

public class RayThrower {
    private Scene scene;
    private int imgwidth, imgheight;
    public RayThrower(Scene scene){
            this.scene = scene;
            this.imgwidth = scene.getImage().getImageWidth();
            this.imgheight = scene.getImage().getImageHeight();
    }

    public int getImgwidth() {
        return imgwidth;
    }

    public int getImgheight() {
        return imgheight;
    }

    public Scene getScene() {
        return scene;
    }

    public Vector orthonormalW(){
        Triplet temp = getScene().getCamera().getLookFrom();

        Triplet temp2 = getScene().getCamera().getLookAt();

        Vector w1 = new Vector(getScene().getCamera().getLookFrom().subtract(getScene().getCamera().getLookAt()));
        Vector w2 = new Vector(temp.subtract(temp2));
        Vector w = new Vector((temp.divide(temp2)).normalize());
        return w;
    }

    public Vector orthonormalU(){
        Triplet tmp = orthonormalW().getTriplet();
        Triplet u1 = getScene().getCamera().getUp().multiplyVectorial(tmp);

        Triplet upTemp = getScene().getCamera().getUp();

        Triplet TempW = orthonormalW().getTriplet();


        Triplet u2 = upTemp.multiplyVectorial(TempW).normalize();

        Vector y = new Vector(u1.divide(u2));
        return y;
    }

    public Vector orthonormalV(){
        Vector v1 = orthonormalW().multiplyVectorial(orthonormalU());
        Vector v2 = orthonormalW().multiplyVectorial(orthonormalU()).normalize();
        Vector v = new Vector(v1.getTriplet().divide(v2.getTriplet()));
        return v;
    }

    public BufferedImage getMyImage(){
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        for (int x=0; x<getImgwidth(); x++){
            for (int y=0; y<getImgheight(); y++){
                java.awt.Color color = new java.awt.Color(0, 0, 0);
                int rgb = color.getRGB();
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

    public void SaveImage() throws Exception{
        try {
            // Retrieve image
            BufferedImage image = getMyImage();
            File outputfile = new File(getScene().getImage().getImageName());
            ImageIO.write(image, "png", outputfile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
