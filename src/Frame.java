import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Frame extends JFrame {
    public JPanel panel;

    public Frame(){
        panel = new JPanel();
        getContentPane().add(panel);
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        System.out.println("asd "+f.panel.getGraphics());
        f.setVisible(true);


        Fish fish = new Fish(100,250, new File("E:\\JavaSem2\\fishes\\fish.png"));
     //   fish.draw(f.getGraphics());
        fish.setXval(20);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    fish.draw(f.getGraphics());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (fish.getX() < 0 || fish.getX() > 600) {
                        fish.setXval(-1*fish.getXval());
                    }
                    fish.move();
                    f.removeAll();
                    f.revalidate();
                    f.repaint();
                    System.out.println("fish moves");
                }
            }
        });
        thread.start();
    }
}
