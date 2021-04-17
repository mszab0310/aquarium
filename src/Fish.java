import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fish  {
    private BufferedImage fish;
    private int x;
    private int y;
    private int xval;

    public Fish( int x, int y,File path) {
        try{
            fish = ImageIO.read(path);
        }catch (IOException e){
            e.printStackTrace();
        }
        this.x = x;
        this.y = y;
        this.xval = 2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXval() {
        return xval;
    }

    public void setXval(int xval) {
        this.xval = xval;
    }

    public void move(){
        this.x += xval;
    }


    public void draw(Graphics g){
        g.drawImage(fish,x,y,100,100,null);
    }

}
