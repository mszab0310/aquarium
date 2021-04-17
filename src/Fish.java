import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fish {
    private BufferedImage fish;
    private int x;
    private int y;
    private int xVelocity;
    private int yVelocity;
    private int width;
    private int height;

    public Fish(int x, int y,int width,int height, File path) {
        try {
            fish = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.xVelocity = 1;
        this.yVelocity = 1;
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

    public int getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void move() {
            if (x >= Dimension.WIDTH - width  && xVelocity > 0) {
                xVelocity *= -1;
            }
            if(x <= 0 && xVelocity < 0){
                xVelocity *= -1;
            }

            if (y >= Dimension.HEIGHT - height && yVelocity > 0) {
                yVelocity *= -1;
            }
            if(y <= 0 && yVelocity < 0){
                yVelocity *= -1;
            }

            x += xVelocity;
            y += yVelocity;
    }


    public void draw(Graphics g) {
        g.drawImage(fish, x, y, width, height, null);
    }

}
