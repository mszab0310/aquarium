import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

final public class Test {

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 7;
    private int oneY = 7;

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    private List<Fish> fish;

    public static void main(String... args) {
        new Test().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fish = new ArrayList<>();
        drawPanel = new DrawPanel();
        Random random = new Random();
        for (int i = 0; i < 19; i++) {
            int dim = random.nextInt(40) + 50;
            Fish f = new Fish(random.nextInt(450), random.nextInt(650), dim, dim, new File("E:\\JavaSem2\\fishes\\fish.png"));
            f.setYVelocity(random.nextInt(10) - 5);
            f.setXVelocity(random.nextInt(10) - 5);
            fish.add(f);
        }


        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(false);
        frame.setSize(Dimension.WIDTH, Dimension.HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        List<Thread> threads = new ArrayList<>();
        fish.forEach(fish1 -> {
            Thread thread = new Thread(() -> {
                while (true) {
                    fish1.move();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    frame.repaint();
                }
            });
            thread.start();
            threads.add(thread);
        });
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLACK);
            fish.forEach(fish1 -> {
                fish1.draw(g);
            });
        }
    }

    private void moveIt() {
        while (true) {
            if (oneX >= 283) {
                right = false;
                left = true;
            }
            if (oneX <= 7) {
                right = true;
                left = false;
            }
            if (oneY >= 259) {
                up = true;
                down = false;
            }
            if (oneY <= 7) {
                up = false;
                down = true;
            }
            if (up) oneY--;
            if (down) oneY++;
            if (left) oneX--;
            if (right) oneX++;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame.repaint();
        }
    }

}
