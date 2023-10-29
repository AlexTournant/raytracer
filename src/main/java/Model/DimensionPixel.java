package Model;

import java.io.IOException;

public class DimensionPixel {
    private int imgwith;
    private int imgheight;
    private int fov;

    public DimensionPixel(int imgwith, int imgheight, int fov) {
        this.imgwith = imgwith;
        this.imgheight = imgheight;
        this.fov = fov;
    }
/*
    private double fovr=fov*Math.PI;

    private double pixelHeight=Math.tan(fovr/2);

    private int ratio=imgwith/imgheight;

    private double pixelWidht=pixelHeight*ratio;

    ArrayList<String> infGauche=new ArrayList<>(0,0);

    ArrayList<String> supDroit=new ArrayList<>(imgwidth,imgheight);

    ArrayList<String> middleScene=new ArrayList<>(imgwidth/2,imgheight/2);

    ArrayList<String> pixel=new ArrayList<>(-(imgwith/2)+(i+0.5)*(pixelWidht,imgheight/2)-(j+0.5)*pixelHeight);

    Vector
*/

    public static void main(String[] args) throws IOException {
    Parser p=new Parser();
    p.parse("2Sphere.txt");
    DimensionPixel dp= new DimensionPixel(p.getWidth(),p.getHeight(),p.getFov());
}

}
