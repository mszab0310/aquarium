import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

final public class Test
{

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 7;
    private int oneY = 7;

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    BufferedImage fish;

    public static void main(String... args)
    {
        new Test().go();
    }

    private void go()
    {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();
        try{
            fish = ImageIO.read(new File("E:\\JavaSem2\\fishes\\fish.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(false);
        frame.setSize(300, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        Thread thread = new Thread(this::moveIt);
        thread.start();

    }

    class DrawPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.BLACK);
            g.drawImage(fish,oneX,oneY,50,50,null);
        }
    }

    private void moveIt()
    {
        while (true)
        {
            if (oneX >= 283)
            {
                right = false;
                left = true;
            }
            if (oneX <= 7)
            {
                right = true;
                left = false;
            }
            if (oneY >= 259)
            {
                up = true;
                down = false;
            }
            if (oneY <= 7)
            {
                up = false;
                down = true;
            }
            if (up) oneY--;
            if (down) oneY++;
            if (left) oneX--;
            if (right) oneX++;
            try
            {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            frame.repaint();
        }
    }
}
